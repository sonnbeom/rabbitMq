package rabbitMq.rabbitMq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeaderExchange {
    @Bean
    HeadersExchange headersExchange() {
        // headers.exchange 이름의 Headers Exchange
        return new HeadersExchange("exchange.headers");
    }
    @Bean
    Queue queue3() {
        // queue3 이름의 큐를 구성합니다.
        return new Queue("queue3", false);
    }
    @Bean
    Binding headersBinding(HeadersExchange headersExchange, @Qualifier("queue3") Queue queue3) {
        return BindingBuilder
                .bind(queue3)
                .to(headersExchange)
                .where("x-api-key")     // Header 내에 "x-api-key" 라는 값이 존재하는 경우
                .exists();
    }
}
