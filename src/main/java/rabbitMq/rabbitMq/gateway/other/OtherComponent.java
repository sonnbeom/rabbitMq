package rabbitMq.rabbitMq.gateway.other;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static rabbitMq.rabbitMq.gateway.constant.QueueConstant.*;

@Slf4j
@Component
public class OtherComponent {

    @RabbitListener(queues = PAYMENT_QUEUE)
    public void receivePaymentMessage(String msg){
        log.info("큐의 결과값을 받았씁니다 queue {}, msg = {}", PAYMENT_QUEUE, msg);
    }
    @RabbitListener(queues = SHIPPING_QUEUE)
    public void receiveShippingMessage(String msg){
        log.info("큐의 결과값을 받았씁니다 queue {}, msg = {}", SHIPPING_QUEUE, msg);
    }
    @RabbitListener(queues = INQUIRY_QUEUE)
    public void receiveInquiryMessage(String msg){
        log.info("큐의 결과값을 받았씁니다 queue {}, msg = {}", INQUIRY_QUEUE, msg);
    }
    @RabbitListener(queues = DEAL_LETTER_QUEUE)
    public void receiveDeadLetterMessage(String msg){
        log.info("큐의 결과값을 받았씁니다 queue {}, msg = {}", DEAL_LETTER_QUEUE, msg);
    }
}