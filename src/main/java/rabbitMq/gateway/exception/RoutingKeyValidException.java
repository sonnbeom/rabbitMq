package rabbitMq.gateway.exception;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;

@Slf4j
public class RoutingKeyValidException extends RuntimeException{
    @Getter
    private final HttpStatusCode httpStatusCode;
    public RoutingKeyValidException(String message, HttpStatusCode httpStatusCode) {
        super(message);
        log.info("message = {}", message);
        this.httpStatusCode = httpStatusCode;
    }
}
