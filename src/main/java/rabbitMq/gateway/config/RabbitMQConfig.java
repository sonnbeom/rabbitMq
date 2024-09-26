package rabbitMq.gateway.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



import static rabbitMq.gateway.constant.ExchangeConstant.*;
import static rabbitMq.gateway.constant.QueueConstant.*;
import static rabbitMq.gateway.constant.RoutingKeyConstant.*;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue paymentQueue() {
        return new Queue(PAYMENT_QUEUE);
    }

    @Bean
    public Queue shippingQueue() {
        return new Queue(SHIPPING_QUEUE);
    }

    @Bean
    public Queue inquiryQueue() {
        return new Queue(INQUIRY_QUEUE);
    }
    @Bean
    public Queue priorityQueue() {
        return QueueBuilder.durable(PRIORITY_QUEUE).withArgument("x-max-priority", 10).build();
    }
    @Bean
    public Queue deadLetterQueue() {
        return new Queue(DEAL_LETTER_QUEUE);
    }
    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(DIRECT_EXCHANGE);
    }
    @Bean
    public Binding bindingPaymentQueue(Queue paymentQueue, DirectExchange exchange) {
        return BindingBuilder.bind(paymentQueue).to(exchange).with(PAYMENT_ROUTING);
    }
    @Bean
    public Binding bindingShippingQueue(Queue shippingQueue, DirectExchange exchange) {
        return BindingBuilder.bind(shippingQueue).to(exchange).with(SHIPPING_ROUTING);
    }
    @Bean
    public Binding bindingInquiryQueue(Queue inquiryQueue, DirectExchange exchange) {
        return BindingBuilder.bind(inquiryQueue).to(exchange).with(INQUIRY_ROUTING);
    }
    @Bean
    public Binding bindingPriorityQueue(Queue priorityQueue, DirectExchange exchange) {
        return BindingBuilder.bind(priorityQueue).to(exchange).with(PRIORITY_ROUTING);
    }
    @Bean
    public Binding bindingDeadLetterQueue(Queue deadLetterQueue, DirectExchange exchange) {
        return BindingBuilder.bind(deadLetterQueue).to(exchange).with(DEAD_LETTER_ROUTING);
    }
}
