package rabbitMq.rabbitMq.common.service;

import rabbitMq.rabbitMq.common.response.CommonResponse;
import rabbitMq.rabbitMq.common.response.ListResponse;
import rabbitMq.rabbitMq.common.response.SingleResponse;

import java.util.List;


public interface ResponseService {
    /*
    * 메서드 앞의 T: 메서드가 제네릭 타입 T를 쓸 수 있음 메서드에 적어놔야 메서드 내에서 제네릭을 받고 이용할 수 있다
    *  SingleResponse<T> 반환 타입이 제네릭 만약 Integer를 넣으면 Integer를 리턴해야함
     * T data : 인자의 타입이 제네릭 무엇이 들어오냐에 따라 data 타입이 바뀜
    * */
    <T>SingleResponse<T> getSingleResponse(T data);
    <T> ListResponse<T> getListResponse(List<T> dataList);
    void setSuccessResponse(CommonResponse response);
}
