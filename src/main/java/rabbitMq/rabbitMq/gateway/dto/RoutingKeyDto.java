package rabbitMq.rabbitMq.gateway.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
public class RoutingKeyDto {
    private boolean success;
    @Getter
    private String key;
    public Boolean isSuccess(){
        return success;
    }
}
