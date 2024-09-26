package rabbitMq.gateway.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rabbitMq.common.dto.Response;
import rabbitMq.common.service.ResponseService;
import rabbitMq.gateway.converter.RoutingKeyChecker;
import rabbitMq.gateway.dto.ReqMsgDto;
import rabbitMq.gateway.dto.RoutingKeyDto;
import rabbitMq.gateway.exception.RoutingKeyValidException;

import static org.springframework.http.HttpStatus.*;
import static rabbitMq.gateway.constant.ExchangeConstant.*;
import static rabbitMq.gateway.constant.QueueConstant.PRIORITY_NUM;
import static rabbitMq.gateway.constant.RoutingKeyConstant.*;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class GatewayServiceImpl implements GatewayService {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;
    private final RoutingKeyChecker routingKeyChecker;
    private final ResponseService responseService;

    @Override
    public <T> Response sendMessage(ReqMsgDto req) {
        String routingKey = "";
        String objectToJson = "";
        RoutingKeyDto routingKeyDto = routingKeyChecker.checkValidRoutingKey(req.getRoutingKey());
        if (!routingKeyDto.isSuccess()) {
            throw new RoutingKeyValidException("적절한 라우팅 키가 아닙니다", BAD_REQUEST);
        } else {
            routingKey = routingKeyDto.getKey();
        }
        try {
            objectToJson = objectMapper.writeValueAsString(req);
            rabbitTemplate.convertAndSend(DIRECT_EXCHANGE, routingKey, objectToJson);
            return responseService.getResponse(req, true, OK);
        } catch (JsonProcessingException e) {
            log.info("Queue msg json 파싱에러");
            throw new RuntimeException("Queue msg json 파싱에러", e);

        } catch (AmqpException e) {
            log.info("AMQP 오류");
            return handleFailure(objectToJson, req);
        }
    }

    private <T> Response handleFailure(String objectToJson, ReqMsgDto req) {
        try {
            rabbitTemplate.convertAndSend(DIRECT_EXCHANGE, PRIORITY_ROUTING, objectToJson, msg ->{
                msg.getMessageProperties().setPriority(PRIORITY_NUM);
                return msg;
            });
            return responseService.getResponse(req, true, OK);
        } catch (AmqpException e) {
            rabbitTemplate.convertAndSend(DIRECT_EXCHANGE, DEAD_LETTER_ROUTING, objectToJson);
            return responseService.getResponse(req, false, INTERNAL_SERVER_ERROR);
        }
    }
}
