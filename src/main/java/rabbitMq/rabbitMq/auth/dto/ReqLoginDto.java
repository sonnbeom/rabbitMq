package rabbitMq.rabbitMq.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReqLoginDto {
    private String email;
    private String pwd;
}
