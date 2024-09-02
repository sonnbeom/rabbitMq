//package rabbitMq.rabbitMq.domain;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.DirectExchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class BurgerQueueConfig {
//
//    @Bean
//    DirectExchange burgerExchange() {
//        return new DirectExchange("burgerExchange");
//    }
//
//    @Bean
//    Queue burgerQueue() {
//        return new Queue("burgerQueue", true);
//    }
//
//    @Bean
//    Binding burgerBinding(DirectExchange burgerExchange, Queue burgerQueue) {
//        return BindingBuilder.bind(burgerQueue).to(burgerExchange).with("order.burger");
//    }
//}