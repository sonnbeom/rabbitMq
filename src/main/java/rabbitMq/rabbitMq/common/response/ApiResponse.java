package rabbitMq.rabbitMq.common.response;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ApiResponse {
    private String result;
    private int resultCode;
    private String resultMsg;
    @Builder
    public ApiResponse(String result, int resultCode, String resultMsg) {
        this.result = result;
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }
}
