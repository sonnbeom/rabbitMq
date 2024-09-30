package rabbitMq.rabbitMq.auth.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Passport {
    private Long memberId;
    private String name;
    private String role;
    @Builder
    public Passport(Long memberId, String name, String role) {
        this.memberId = memberId;
        this.name = name;
        this.role = role;
    }
}
