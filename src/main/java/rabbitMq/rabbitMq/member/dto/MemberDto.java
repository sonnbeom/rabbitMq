package rabbitMq.rabbitMq.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import rabbitMq.rabbitMq.member.domain.Member;

@Getter
@NoArgsConstructor
public class MemberDto {
    private Long id;
    private String name;
    private String email;
    private String password;

    @Builder
    public MemberDto(String name, String email, Long id) {
        this.name = name;
        this.email = email;
        this.id = id;
    }

    public Member dtoToEntity() {
        return Member.builder()
                .email(email)
                .name(name)
                .password(password)
                .build();
    }
}
