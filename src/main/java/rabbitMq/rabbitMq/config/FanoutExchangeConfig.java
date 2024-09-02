package rabbitMq.rabbitMq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutExchangeConfig {
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("exchange.fanout");
    }

    @Bean
    Queue fanoutQueue1() {
        return new Queue("queue4", false);
    }

    @Bean
    Queue fanoutQueue2() {
        return new Queue("queue5", false);
    }

    @Bean
    Binding fanoutBinding1(FanoutExchange fanoutExchange, @Qualifier("fanoutQueue1")Queue fanoutQueue1) {
        return BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
    }

    @Bean
    Binding fanoutBinding2(FanoutExchange fanoutExchange, @Qualifier("fanoutQueue2")Queue fanoutQueue2) {
        return BindingBuilder.bind(fanoutQueue2).to(fanoutExchange);
    }
}
