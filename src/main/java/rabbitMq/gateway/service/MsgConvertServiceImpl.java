package rabbitMq.gateway.service;

import rabbitMq.gateway.dto.ReqMsgDto;

public class MsgConvertServiceImpl implements MsgConvertService{
    @Override
    public String getRoutingKey(ReqMsgDto req) {
        return req.getRoutingKey();
    }

    @Override
    public String getMsg(ReqMsgDto req) {
        return req.getMessage();
    }
}
