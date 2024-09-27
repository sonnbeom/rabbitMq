package rabbitMq.rabbitMq.common.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rabbitMq.rabbitMq.common.dto.Response;


@Service
@Transactional
public class ResponseServiceImpl implements ResponseService{

    public <T>Response getResponse(T data, boolean success, HttpStatus code) {
        return Response.builder()
                .code(code)
                .success(success)
                .data(data)
                .build();
    }
}


