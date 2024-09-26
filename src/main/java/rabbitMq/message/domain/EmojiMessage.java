//package rabbitMq.message.domain;
//
//import lombok.Builder;
//import rabbitMq.member.Member;
//
//import java.time.LocalDateTime;
//
//public class EmojiMessage extends BaseMessageEntity{
//    private String emojiCode;
//
//    @Builder
//    public EmojiMessage(String message, LocalDateTime sendTime, LocalDateTime receiveTime, boolean success, Member member, String emojiCode) {
//        super(message, sendTime, receiveTime, success, member);
//        this.emojiCode = emojiCode;
//    }
//}
