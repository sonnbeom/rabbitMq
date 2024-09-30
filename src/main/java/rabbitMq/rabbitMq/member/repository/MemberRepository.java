package rabbitMq.rabbitMq.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rabbitMq.rabbitMq.member.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
