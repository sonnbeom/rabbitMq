package rabbitMq.rabbitMq.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import rabbitMq.rabbitMq.member.domain.Member;

@Getter
@NoArgsConstructor
public class MemberDto {
    private String name;
    private String email;
    private String password;

    @Builder
    public MemberDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Member dtoToEntity() {
        return Member.builder()
                .email(email)
                .name(name)
                .password(password)
                .build();
    }
}
