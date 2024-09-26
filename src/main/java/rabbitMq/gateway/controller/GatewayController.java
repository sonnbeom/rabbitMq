package rabbitMq.gateway.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rabbitMq.common.dto.Response;
import rabbitMq.gateway.dto.ReqMsgDto;
import rabbitMq.gateway.service.GatewayService;
import rabbitMq.rabbitMq.common.response.SingleResponse;
import rabbitMq.rabbitMq.common.service.ResponseService;
import rabbitMq.rabbitMq.service.ProducerService;

@Slf4j
@RestController
@RequestMapping(value = "api/v1/gateway")
@RequiredArgsConstructor
public class GatewayController {

    private final GatewayService gatewayService;


    @PostMapping()
    public <T> Response directSendMessage(@RequestBody ReqMsgDto req){
        return gatewayService.sendMessage(req);
    }
}
