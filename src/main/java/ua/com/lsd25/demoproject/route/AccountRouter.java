package ua.com.lsd25.demoproject.route;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import ua.com.lsd25.demoproject.handler.AccountHandler;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;

@Component
public class AccountRouter {

    @Bean
    public RouterFunction<ServerResponse> route(final AccountHandler accountHandler) {
        return RouterFunctions
                .route(POST("/accounts").and(contentType(APPLICATION_JSON)), accountHandler::createAccount);

    }

}
