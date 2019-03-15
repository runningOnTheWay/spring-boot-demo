package cn.newbie.rabbitmq.project_use.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExchangeConfig {

	@Value("${test.mq.exchange.formal-direct}")
	private String exchangeFormalDirect;

	@Value("${test.mq.exchange.formal-topic}")
	private String exchangeFormalTopic;

	@Value("${test.mq.exchange.formal-fanout}")
	private String exchangeFormalFanout;

	@Value("${test.mq.exchange.delay-direct}")
	private String exchangeDelayDirect;

	@Bean
	public DirectExchange exchangeFormalDirect() {
		return new DirectExchange(exchangeFormalDirect);
	}

	@Bean
	public TopicExchange exchangeFormalTopic() {
		return new TopicExchange(exchangeFormalTopic);
	}

	@Bean
	public FanoutExchange exchangeFormalFanout() {
		return new FanoutExchange(exchangeFormalFanout);
	}

	@Bean
	public DirectExchange exchangeDelayDirect() {
		return new DirectExchange(exchangeDelayDirect);
	}
}
