package cn.newbie.rabbitmq.project_use.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BindingConfig {

	@Value("${test.mq.routing-key.number}")
	private String routingKeyNumber;

	@Value("${test.mq.routing-key.long}")
	private String routingKeyLong;

	@Value("${test.mq.routing-key.long-delay}")
	private String routingKeyLongDelay;

	@Value("${test.mq.routing-key.compensating}")
	private String routingKeyCompensating;

	@Value("${test.mq.routing-key.log}")
	private String routingKeyLog;

	@Bean
    Binding bindingExchangeNumber(Queue queueNumber, DirectExchange exchangeFormalDirect) {
		return BindingBuilder.bind(queueNumber).to(exchangeFormalDirect).with(routingKeyNumber);
	}

	@Bean
    Binding bindingExchangeLong(Queue queueLong, DirectExchange exchangeFormalDirect) {
		return BindingBuilder.bind(queueLong).to(exchangeFormalDirect).with(routingKeyLong);
	}

	@Bean
    Binding bindingExchangeLongDelay(Queue queueLongDelay, DirectExchange exchangeDelayDirect) {
		return BindingBuilder.bind(queueLongDelay).to(exchangeDelayDirect).with(routingKeyLongDelay);
	}

	@Bean
    Binding bindingExchangeCompensating(Queue queueCompensating, DirectExchange exchangeFormalDirect) {
		return BindingBuilder.bind(queueCompensating).to(exchangeFormalDirect).with(routingKeyCompensating);
	}

	@Bean
    Binding bindingExchangeLog(Queue queueLog, DirectExchange exchangeFormalDirect) {
		return BindingBuilder.bind(queueLog).to(exchangeFormalDirect).with(routingKeyLog);
	}

}
