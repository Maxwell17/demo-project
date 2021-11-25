package ua.com.lsd25.demoproject.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.lsd25.demoproject.domain.Account;
import ua.com.lsd25.demoproject.repository.AccountRepository;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AccountRepository repository;

    @Override
    public Mono<Account> findById(final String id) {
        return this.repository.findById(id);
    }

    @Override
    public Flux<Account> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Mono<Account> save(final Account account) {
        return this.repository.save(account);
    }

    @Override
    public Mono<UserDetails> findByUsername(final String username) {
        return this.repository.findAccountByUsername(username);
    }
}
