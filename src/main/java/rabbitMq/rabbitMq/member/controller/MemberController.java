package rabbitMq.rabbitMq.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rabbitMq.rabbitMq.common.dto.Response;
import rabbitMq.rabbitMq.member.dto.MemberDto;
import rabbitMq.rabbitMq.member.repository.MemberRepository;
import rabbitMq.rabbitMq.member.service.MemberService;

@RestController
@RequestMapping("api/v1/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping()
    public Response<MemberDto> create(@RequestBody MemberDto memberDto){
        return memberService.create(memberDto);
    }
}
