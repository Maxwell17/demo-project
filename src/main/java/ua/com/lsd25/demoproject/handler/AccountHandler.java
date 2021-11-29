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
        return request
                .bodyToMono(Account.class)
//                .log(null, Level.INFO)
                .flatMap((Function<Account, Mono<Account>>) acc -> repository.save(acc))
                .flatMap((Function<Account, Mono<ServerResponse>>) acc -> ServerResponse.created(URI.create(""))
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(acc)
                ).onErrorResume(th -> ServerResponse.badRequest()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(th.getMessage())
                );
    }

}
