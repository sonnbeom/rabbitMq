package rabbitMq.rabbitMq.dto;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MessageDto {
    private String title;
    private String message;

    @Builder
    public MessageDto(String title, String message){
        this.title = title;
        this.message = message;
    }
}
