package rabbitMq.rabbitMq.member.service;

import rabbitMq.rabbitMq.common.dto.Response;
import rabbitMq.rabbitMq.member.dto.MemberDto;

public interface MemberService {
    Response<MemberDto> create(MemberDto memberDto);
}
