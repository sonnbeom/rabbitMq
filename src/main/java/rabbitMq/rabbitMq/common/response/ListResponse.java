package rabbitMq.rabbitMq.common.response;

import lombok.Getter;

import java.util.List;
@Getter
public class ListResponse<T> extends CommonResponse {
    private List<T> dataList;

    public ListResponse(List<T> dataList) {
        super();
        this.dataList = dataList;
    }
}
