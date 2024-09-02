package rabbitMq.rabbitMq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectExchangeConfig {
    @Bean
    DirectExchange directExchange() {
        return new DirectExchange("exchange.direct");
    }

    @Bean
    Queue directQueue1() {
        return new Queue("queue1", false);
    }

    @Bean
    Queue directQueue2() {
        return new Queue("queue2", false);
    }

    @Bean
    Binding directBinding1(DirectExchange directExchange, @Qualifier("directQueue1")Queue directQueue1) {
        return BindingBuilder.bind(directQueue1).to(directExchange).with("order.pizza");
    }

    @Bean
    Binding directBinding2(DirectExchange directExchange, @Qualifier("directQueue2")Queue directQueue2) {
        return BindingBuilder.bind(directQueue2).to(directExchange).with("order.burger");
    }
}
