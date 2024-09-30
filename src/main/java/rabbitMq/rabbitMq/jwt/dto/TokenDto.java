package rabbitMq.rabbitMq.jwt.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TokenDto {
    private String accessToken;

    @Builder
    public TokenDto(String accessToken) {
        this.accessToken = accessToken;
    }
}
