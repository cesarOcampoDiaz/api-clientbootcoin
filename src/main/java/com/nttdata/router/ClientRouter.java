package com.nttdata.router;

import com.nttdata.handler.ClientHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class ClientRouter {
    @Bean
    public RouterFunction<ServerResponse> clientyankiRouterFunc(ClientHandler clientHandler) {
        return RouterFunctions.route(POST("/clientbootcoin").and(accept(MediaType.APPLICATION_JSON)), clientHandler::add)
                .andRoute(GET("/clientbootcoin").and(accept(MediaType.TEXT_EVENT_STREAM)), clientHandler::findAll)
                .andRoute(GET("/clientbootcoin/{id}").and(accept(MediaType.APPLICATION_JSON)), clientHandler::findById)
                .andRoute(PUT("/clientbootcoin/{id}").and(accept(MediaType.APPLICATION_JSON)), clientHandler::update);


    }

}
