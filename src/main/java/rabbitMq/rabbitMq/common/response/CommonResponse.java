package rabbitMq.rabbitMq.common.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CommonResponse {
    private boolean success;
    private HttpStatus code;
    private String message;
    public void setSuccessResponse(){
        this.success = true;
        this.message = "SUCCESS";
        this.code = HttpStatus.OK;
    }
}
