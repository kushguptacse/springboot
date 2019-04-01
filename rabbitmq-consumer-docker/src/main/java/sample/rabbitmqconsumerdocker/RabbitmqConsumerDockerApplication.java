package sample.rabbitmqconsumerdocker;

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

import sample.rabbitmqconsumerdocker.config.ApplicationConfigReader;

@SpringBootApplication
public class RabbitmqConsumerDockerApplication {

	@Autowired
	private ApplicationConfigReader applicationConfigReader; 
	
	public static void main(String[] args) {
		SpringApplication.run(RabbitmqConsumerDockerApplication.class, args);
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
    
    @Bean
    public MessageConverter producerJackson2MessageConverter() {
    return new Jackson2JsonMessageConverter();
    }
    

}
