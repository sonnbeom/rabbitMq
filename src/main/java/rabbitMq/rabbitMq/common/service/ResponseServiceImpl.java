package rabbitMq.rabbitMq.common.service;

import org.springframework.stereotype.Service;
import rabbitMq.rabbitMq.common.response.CommonResponse;
import rabbitMq.rabbitMq.common.response.ListResponse;
import rabbitMq.rabbitMq.common.response.SingleResponse;

import java.util.List;

@Service
public class ResponseServiceImpl implements ResponseService{
    @Override
    public <T> SingleResponse<T> getSingleResponse(T data) {
        SingleResponse singleResponse = new SingleResponse(data);
        setSuccessResponse(singleResponse);
        return singleResponse;
    }

    @Override
    public <T> ListResponse<T> getListResponse(List<T> dataList) {
        ListResponse listResponse = new ListResponse(dataList);
        setSuccessResponse(listResponse);
        return listResponse;
    }

    @Override
    public void setSuccessResponse(CommonResponse response) {
        response.setSuccessResponse();
    }
}
