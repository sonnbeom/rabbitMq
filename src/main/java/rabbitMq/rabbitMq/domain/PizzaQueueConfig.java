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
//public class PizzaQueueConfig {
//
//    @Bean
//    DirectExchange pizzaExchange() {
//        return new DirectExchange("pizzaExchange");
//    }
//
//    @Bean
//    Queue pizzaQueue() {
//        return new Queue("pizzaQueue", true);
//    }
//
//    @Bean
//    Binding pizzaBinding(DirectExchange pizzaExchange, Queue pizzaQueue) {
//        return BindingBuilder.bind(pizzaQueue).to(pizzaExchange).with("order.pizza");
//    }
//}