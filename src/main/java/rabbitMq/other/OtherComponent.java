package rabbitMq.other;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OtherComponent {

//    @RabbitListener(queues = "queue1")
//    public void receiveMessage(String msg){
//        System.out.println("Queue1 내의 결과 값을 받았습니다. msg =" + msg);
//    }
}