package ua.com.lsd25.demoproject.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import ua.com.lsd25.demoproject.domain.Account;

@Repository
public interface AccountRepository extends ReactiveMongoRepository<Account, String> {

    Mono<UserDetails> findAccountByUsername(final String username);

}
