package rabbitMq.gateway.exceptionhandler;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import rabbitMq.gateway.exception.RoutingKeyValidException;

@ControllerAdvice
public class RoutingKeyExceptionHandler {
    @ExceptionHandler(RoutingKeyValidException.class)
    public ResponseEntity<String> handleRoutingKeyException(RoutingKeyValidException ex){
        return new ResponseEntity<>(ex.getMessage(), ex.getHttpStatusCode());
    }
}
