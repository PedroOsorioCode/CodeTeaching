package co.com.openapi.aws.api;

import co.com.openapi.aws.api.config.ApiProperties;
import co.com.openapi.aws.api.doc.MethodHttpOpenAPI;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springdoc.webflux.core.fn.SpringdocRouteBuilder;

@Configuration
@RequiredArgsConstructor
public class RouterRest {
    private final ApiProperties properties;

    @Bean
    public RouterFunction<ServerResponse> routerFunction(Handler handler) {
        return SpringdocRouteBuilder.route()
                .GET(properties.getPathBase().concat(properties.getMethodGet()),
                        handler::methotGet, MethodHttpOpenAPI.openApiRoute("description method GET"))
                .POST(properties.getPathBase().concat(properties.getMethodPost()),
                        handler::methotPost, MethodHttpOpenAPI.openApiRoute("description method POST"))
                .PUT(properties.getPathBase().concat(properties.getMethodPut()),
                        handler::methotPut, MethodHttpOpenAPI.openApiRoute("description method PUT"))
                .DELETE(properties.getPathBase().concat(properties.getMethodDelete()),
                        handler::methotDelete, MethodHttpOpenAPI.openApiRoute("description method DELETE"))
                .GET(properties.getPathBase().concat(properties.getMethodFind()),
                        handler::methotFind, MethodHttpOpenAPI.openApiRoute("description method FIND"))
                .build();
    }
}