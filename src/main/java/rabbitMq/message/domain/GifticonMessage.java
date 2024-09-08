package rabbitMq.message.domain;

import lombok.Builder;
import rabbitMq.member.Member;

import java.time.LocalDateTime;

public class GifticonMessage extends BaseMessageEntity{
    private String couponCode;
    private String imageUrl;

    @Builder
    public GifticonMessage(String message, LocalDateTime sendTime, LocalDateTime receiveTime, boolean success, Member member, String couponCode, String imageUrl) {
        super(message, sendTime, receiveTime, success, member);
        this.couponCode = couponCode;
        this.imageUrl = imageUrl;
    }
}
