package rabbitMq.message.domain;

import lombok.Builder;
import rabbitMq.member.Member;

import java.time.LocalDateTime;

public class BaseMessageEntity {
    private String message;
    private LocalDateTime sendTime;
    private LocalDateTime receiveTime;
    private boolean success;
    private Member member;
    @Builder
    public BaseMessageEntity(String message, LocalDateTime sendTime, LocalDateTime receiveTime, boolean success, Member member) {
        this.message = message;
        this.sendTime = sendTime;
        this.receiveTime = receiveTime;
        this.success = success;
        this.member = member;
    }
}
