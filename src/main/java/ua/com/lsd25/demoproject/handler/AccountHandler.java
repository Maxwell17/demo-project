package ua.com.lsd25.demoproject.handler;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyExtractor;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import ua.com.lsd25.demoproject.domain.Account;
import ua.com.lsd25.demoproject.domain.Role;
import ua.com.lsd25.demoproject.repository.AccountRepository;

import java.util.List;

@Log4j2
@Component
@AllArgsConstructor
public class AccountHandler {

    private AccountRepository repository;

    public Mono<ServerResponse> createAccount(final ServerRequest request) {
        log.info("Create account...");
        final Account account = request.body(new BodyExtractor<Account, ServerHttpRequest>() {
            @Override
            public Account extract(ServerHttpRequest inputMessage, Context context) {
                return new Account("", "admin", "1234", List.of(Role.ADMIN));
            }
        });
        final Mono<Account> savedAccount = this.repository.save(account);
        return ServerResponse.ok().build();
    }

}
