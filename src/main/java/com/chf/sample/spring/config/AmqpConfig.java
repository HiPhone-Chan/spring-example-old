package com.chf.sample.spring.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.chf.sample.spring.mq.rabbitmq.Receiver;

@Configuration
public class AmqpConfig {

	final static String QUEUE_NAME = "queue-chf";

	final static String EXCHANGE_NAME = "exchange-chf";

	final static String ROUTING_KEY = "ROUTING_KEY";

	@Bean
	Queue queue() {
		return new Queue(QUEUE_NAME, false);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(EXCHANGE_NAME, false, false);
	}

	@Bean
	public Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
	}

	@Bean
	public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(QUEUE_NAME);

		Receiver receiver = new Receiver();
		MessageListenerAdapter listenerAdapter = new MessageListenerAdapter(receiver, "receiveMessage");
		container.setMessageListener(listenerAdapter);
		return container;
	}

}
