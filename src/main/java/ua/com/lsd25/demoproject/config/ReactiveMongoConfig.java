package ua.com.lsd25.demoproject.config;

import com.mongodb.reactivestreams.client.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableReactiveMongoRepositories
public class ReactiveMongoConfig {

//    @Bean
//    public ReactiveMongoTemplate reactiveMongoTemplate(final MongoClient mongoClient) {
//        return new ReactiveMongoTemplate(mongoClient, "local");
//    }

}
