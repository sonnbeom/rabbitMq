package rabbitMq.common.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Builder
@Getter
public class Response<T> {
    private T data;
    private boolean success;
    private HttpStatus code;
}
