package sample.rabbitmqproducerdocker;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sample.rabbitmqproducerdocker.config.ApplicationConfigReader;
@SpringBootApplication
public class RabbitmqProducerDockerApplication {

	@Autowired
	private ApplicationConfigReader applicationConfigReader;
	
	public static void main(String[] args) {
		SpringApplication.run(RabbitmqProducerDockerApplication.class, args);
	}

    @Bean
    Queue queue() {
        return new Queue(applicationConfigReader.getApp1Queue(), false);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(applicationConfigReader.getApp1Exchange());
    }

    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(applicationConfigReader.getApp1RoutingKey());
    }

//    @Bean
//    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
//    final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//    rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
//    return rabbitTemplate;
//    }
    
    @Bean
    public MessageConverter jsonMessageConverter() {
    return new Jackson2JsonMessageConverter();
    }
    
//    @Bean
//    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
//            MessageListenerAdapter listenerAdapter) {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.setQueueNames(queueName);
//        container.setMessageListener(listenerAdapter);
//        return container;
//    }

//    @Bean
//    MessageListenerAdapter listenerAdapter(Receiver receiver) {
//        return new MessageListenerAdapter(receiver, "receiveMessage");
//    }



}
