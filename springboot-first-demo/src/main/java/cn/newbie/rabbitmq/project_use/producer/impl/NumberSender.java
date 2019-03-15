package cn.newbie.rabbitmq.project_use.producer.impl;

import cn.newbie.rabbitmq.project_use.MqRequestDto;
import cn.newbie.rabbitmq.project_use.producer.Sender;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NumberSender implements Sender {

	@Value("${test.mq.exchange.formal-direct}")
	private String exchangeFormalDirect;

	@Value("${test.mq.routing-key.number}")
	private String routingKeyNumber;

	@Autowired
	private AmqpTemplate rabbitTemplate;

	@Override
	public void send(MqRequestDto message) {
		rabbitTemplate.convertSendAndReceive(exchangeFormalDirect, routingKeyNumber, message);
	}

}
