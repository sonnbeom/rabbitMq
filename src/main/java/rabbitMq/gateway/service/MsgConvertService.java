package rabbitMq.gateway.service;

import rabbitMq.gateway.dto.ReqMsgDto;

public interface MsgConvertService {
    String getRoutingKey(ReqMsgDto req);
    String getMsg(ReqMsgDto req);
}
