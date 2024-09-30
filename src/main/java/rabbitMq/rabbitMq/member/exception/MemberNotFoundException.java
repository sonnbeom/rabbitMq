package rabbitMq.rabbitMq.member.exception;

import org.springframework.http.HttpStatusCode;

public class MemberNotFoundException extends RuntimeException{
    HttpStatusCode statusCode;

    public MemberNotFoundException(String message, HttpStatusCode statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}
