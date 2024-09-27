package rabbitMq.rabbitMq.gateway.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rabbitMq.rabbitMq.common.dto.Response;
import rabbitMq.rabbitMq.gateway.dto.ReqMsgDto;
import rabbitMq.rabbitMq.gateway.service.GatewayService;

@RestController
@RequestMapping(value = "/api/v1/gateway")
@RequiredArgsConstructor
public class GatewayController {

    private final GatewayService gatewayService;

    @PostMapping()
    public <T> Response directSendMessage(@RequestBody ReqMsgDto req){
        return gatewayService.sendMessage(req);
    }
}
