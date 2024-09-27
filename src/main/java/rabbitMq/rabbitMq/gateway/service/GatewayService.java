package rabbitMq.rabbitMq.gateway.service;

import rabbitMq.rabbitMq.common.dto.Response;
import rabbitMq.rabbitMq.gateway.dto.ReqMsgDto;

public interface GatewayService {
    <T> Response sendMessage(ReqMsgDto req);
}
