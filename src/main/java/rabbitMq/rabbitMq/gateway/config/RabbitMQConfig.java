package rabbitMq.rabbitMq.gateway.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



import static rabbitMq.rabbitMq.gateway.constant.ExchangeConstant.*;
import static rabbitMq.rabbitMq.gateway.constant.QueueConstant.*;
import static rabbitMq.rabbitMq.gateway.constant.RoutingKeyConstant.*;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue paymentQueue() {
        return QueueBuilder.durable(PAYMENT_QUEUE).withArgument(X_MAX_PRIORITY, PRIORITY_NUM).build();
    }

    @Bean
    public Queue shippingQueue() {
        return QueueBuilder.durable(SHIPPING_QUEUE).withArgument(X_MAX_PRIORITY, PRIORITY_NUM).build();
    }

    @Bean
    public Queue inquiryQueue() {
        return QueueBuilder.durable(INQUIRY_QUEUE).withArgument(X_MAX_PRIORITY, PRIORITY_NUM).build();
    }
    @Bean
    public Queue priorityQueue() {
        return QueueBuilder.durable(PRIORITY_QUEUE).withArgument(X_MAX_PRIORITY, PRIORITY_NUM).build();
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
    public Binding bindingPaymentQueue(@Qualifier(PAYMENT_QUEUE) Queue paymentQueue, DirectExchange exchange) {
        return BindingBuilder.bind(paymentQueue).to(exchange).with(PAYMENT_ROUTING);
    }
    @Bean
    public Binding bindingShippingQueue(@Qualifier(SHIPPING_QUEUE)Queue shippingQueue, DirectExchange exchange) {
        return BindingBuilder.bind(shippingQueue).to(exchange).with(SHIPPING_ROUTING);
    }
    @Bean
    public Binding bindingInquiryQueue(@Qualifier(INQUIRY_QUEUE)Queue inquiryQueue, DirectExchange exchange) {
        return BindingBuilder.bind(inquiryQueue).to(exchange).with(INQUIRY_ROUTING);
    }
    @Bean
    public Binding bindingPriorityQueue(@Qualifier(PRIORITY_QUEUE)Queue priorityQueue, DirectExchange exchange) {
        return BindingBuilder.bind(priorityQueue).to(exchange).with(PRIORITY_ROUTING);
    }
    @Bean
    public Binding bindingDeadLetterQueue(@Qualifier(DEAL_LETTER_QUEUE)Queue deadLetterQueue, DirectExchange exchange) {
        return BindingBuilder.bind(deadLetterQueue).to(exchange).with(DEAD_LETTER_ROUTING);
    }
}
