package rabbitMq.rabbitMq.gateway.converter;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rabbitMq.rabbitMq.gateway.dto.RoutingKeyDto;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import static rabbitMq.rabbitMq.gateway.constant.RoutingKeyConstant.*;

@Transactional
@Service
public class RoutingKeyChecker {

    private static final Map<String, String> validRoutingKeys;
    // 외부에서 라우팅 키를  모르게 하기 위함
    static {
        Map<String, String> routingKeys = new HashMap<>();
        routingKeys.put(REQ_PAYMENT_ROUTING,PAYMENT_ROUTING);
        routingKeys.put(REQ_SHIPPING_ROUTING,SHIPPING_ROUTING);
        routingKeys.put(REQ_INQUIRY_ROUTING,INQUIRY_ROUTING);

        validRoutingKeys = Collections.unmodifiableMap(routingKeys);
    }

    public RoutingKeyDto checkValidRoutingKey(String req){
        // 라우팅 키 존재 x
        if (!validRoutingKeys.containsKey(req)){
            return RoutingKeyDto.builder()
                    .success(false)
                    .key(req)
                    .build();
        }
        else {
            return RoutingKeyDto.builder()
                    .success(true)
                    .key(validRoutingKeys.get(req))
                    .build();
        }
    }
}
