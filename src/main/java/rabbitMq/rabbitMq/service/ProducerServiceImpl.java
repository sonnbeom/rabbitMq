package rabbitMq.rabbitMq.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import rabbitMq.rabbitMq.dto.MessageDto;

/*
* RabbitTemplate를 호출하며 convertAndSend 메소드활용
* exchange 이름과 binding Routing key를 기반으로 메시지를 전달
* Object를 Json으로 파싱
* */
@Service
@RequiredArgsConstructor
@Slf4j
public class ProducerServiceImpl implements ProducerService {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(MessageDto messageDto) {
        try {
            //객체를 json으로 변환
            ObjectMapper objectMapper = new ObjectMapper();
            String objectToJson = objectMapper.writeValueAsString(messageDto);
            rabbitTemplate.convertAndSend("exchange", "key", objectToJson);

        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e); 예외 처리를 고민해봐야한다!
            log.info("파싱 오류 발생");
        }
    }
}
