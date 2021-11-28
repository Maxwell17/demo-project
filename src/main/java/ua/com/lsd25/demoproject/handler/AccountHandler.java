package ua.com.lsd25.demoproject.handler;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import ua.com.lsd25.demoproject.domain.Account;
import ua.com.lsd25.demoproject.repository.AccountRepository;

import java.net.URI;
import java.util.function.Function;
import java.util.logging.Level;

@Log4j2
@Component
@AllArgsConstructor
public class AccountHandler {

    private AccountRepository repository;

    public Mono<ServerResponse> createAccount(final ServerRequest request) {
        return request.bodyToMono(Account.class).log(null, Level.INFO).flatMap(new Function<Account, Mono<Account>>() {
            @Override
            public Mono<Account> apply(Account acc) {
                return repository.save(acc);
            }
        }).flatMap(new Function<Account, Mono<ServerResponse>>() {
            @Override
            public Mono<ServerResponse> apply(Account acc) {
                return ServerResponse.created(URI.create("")).contentType(MediaType.APPLICATION_JSON).bodyValue(acc);
            }
        }).onErrorResume(new Function<Throwable, Mono<? extends ServerResponse>>() {
            @Override
            public Mono<? extends ServerResponse> apply(Throwable th) {
                return ServerResponse.badRequest().contentType(MediaType.APPLICATION_JSON).bodyValue(th.getMessage());
            }
        });
    }

}
