package rabbitMq.rabbitMq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicExchangeConfig {
    @Bean
     TopicExchange topicExchange() {
        return new TopicExchange("exchange.topic");
    }

    @Bean
    Queue topicQueue1() {
        return new Queue("queue3", false);
    }

    @Bean
    Binding topicBinding1(TopicExchange topicExchange, @Qualifier("topicQueue1")Queue topicQueue1) {
        return BindingBuilder.bind(topicQueue1).to(topicExchange).with("order.delivery");
    }
}
