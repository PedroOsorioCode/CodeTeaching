package co.com.openapi.aws.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {

    public Mono<ServerResponse> methotGet(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("¡Hi methodGet!");
    }

    public Mono<ServerResponse> methotPost(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("¡Hi methotPost!");
    }

    public Mono<ServerResponse> methotPut(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("¡Hi methotPut!");
    }

    public Mono<ServerResponse> methotDelete(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("¡Hi methotDelete!");
    }

    public Mono<ServerResponse> methotFind(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("¡Hi methotFind!");
    }
}
