package rabbitMq.message.domain;

import lombok.Builder;
import rabbitMq.member.Member;

import java.time.LocalDateTime;

public class ImageMessage extends BaseMessageEntity{
    private String imageUrl;

    @Builder
    public ImageMessage(String message, LocalDateTime sendTime, LocalDateTime receiveTime, boolean success, Member member, String imageUrl) {
        super(message, sendTime, receiveTime, success, member);
        this.imageUrl = imageUrl;
    }
}
