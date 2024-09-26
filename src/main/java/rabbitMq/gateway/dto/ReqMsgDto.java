package rabbitMq.gateway.dto;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ReqMsgDto {
    private String routingKey;
    private String title;
    private String message;

    @Builder
    public ReqMsgDto(String title, String message, String routingKey){
        this.title = title;
        this.message = message;
        this.routingKey = routingKey;
    }

}

