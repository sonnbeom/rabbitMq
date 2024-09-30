package rabbitMq.rabbitMq.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberDtoForJwt {
    private Long id;
    private String name;
    private String email;
    @Builder
    public MemberDtoForJwt(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
