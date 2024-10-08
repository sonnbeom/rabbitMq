package rabbitMq.rabbitMq.common.service;

import org.springframework.http.HttpStatus;
import rabbitMq.rabbitMq.common.dto.Response;

public interface ResponseService {
    <T> Response getResponse(T data, boolean success, HttpStatus code);
}
