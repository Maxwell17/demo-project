package ua.com.lsd25.demoproject.service;

import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.lsd25.demoproject.domain.Account;

public interface AccountService extends ReactiveUserDetailsService {

    Mono<Account> findById(final String id);

    Flux<Account> findAll();

    Mono<Account> save(final Account account);

}
