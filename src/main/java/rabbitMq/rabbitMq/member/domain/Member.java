package rabbitMq.rabbitMq.member.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;
import rabbitMq.rabbitMq.member.dto.MemberDto;

@Entity
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    private String name;
    private String email;
    private String password;

    @Builder
    public Member(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public MemberDto entityToDto() {
        return MemberDto.builder()
                .id(id)
                .email(email)
                .name(name)
                .build();
    }
}
