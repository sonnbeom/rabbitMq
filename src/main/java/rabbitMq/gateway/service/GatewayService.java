package rabbitMq.gateway.service;

import rabbitMq.common.dto.Response;
import rabbitMq.gateway.dto.ReqMsgDto;
import rabbitMq.rabbitMq.common.response.SingleResponse;

public interface GatewayService {
    <T> Response sendMessage(ReqMsgDto req);
}
