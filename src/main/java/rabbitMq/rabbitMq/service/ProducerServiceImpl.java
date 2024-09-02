package rabbitMq.rabbitMq.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
public class ProducerServiceImpl implements ProducerService {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    @Override
    @Transactional(readOnly = true)
    public void directSendMessage(MessageDto messageDto) {
        try {
            //객체를 json으로 변환
            ObjectMapper objectMapper = new ObjectMapper();
            String objectToJson = objectMapper.writeValueAsString(messageDto);
            rabbitTemplate.convertAndSend("exchange.direct", "order.pizza", objectToJson);

        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e); 예외 처리를 고민해봐야한다!
            // 예외에서 예외 객체를 만들어 여러 큐로 던지는 것도 하나의 방안이다 왜나면 연결되어있기 때문에
            log.info("파싱 오류 발생");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public void fanoutSendMessage(MessageDto messageDto) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String objectToJson = objectMapper.writeValueAsString(messageDto);
            rabbitTemplate.convertAndSend("exchange.fanout", "", objectToJson);
        } catch (JsonProcessingException e) {
            log.info("Fanout Exchange 파싱 오류");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public void headerSendMessage(MessageDto messageDto) {
        try {
            String objectToJson = objectMapper.writeValueAsString(messageDto);
            rabbitTemplate.convertAndSend("exchange.headers", "", objectToJson);
        } catch (JsonProcessingException e) {
            log.info("헤더 익스체인지 메시지 파싱 오류");
        }

    }

    @Override
    @Transactional(readOnly = true)
    public void topicSendMessage(MessageDto messageDto) {
        try {
            String objectToJson = objectMapper.writeValueAsString(messageDto);
            rabbitTemplate.convertAndSend("exchange.topic", "order.*", objectToJson);
        } catch (JsonProcessingException e) {
            log.info("토픽 익스체인지 파싱 오류");
        }
    }
}
