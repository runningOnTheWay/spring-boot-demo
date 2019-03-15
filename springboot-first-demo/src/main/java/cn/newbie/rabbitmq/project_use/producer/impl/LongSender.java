package cn.newbie.rabbitmq.project_use.producer.impl;

import cn.newbie.rabbitmq.project_use.MqRequestDto;
import cn.newbie.rabbitmq.project_use.producer.DelaySender;
import cn.newbie.rabbitmq.project_use.producer.Sender;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LongSender implements Sender, DelaySender {

	@Value("${test.mq.exchange.formal-direct}")
	private String exchangeFormalDirect;

	@Value("${test.mq.routing-key.long}")
	private String routingKeyLong;

	@Value("${test.mq.exchange.delay-direct}")
	private String exchangeDelayDirect;

	@Value("${test.mq.routing-key.long-delay}")
	private String routingKeyLongDelay;

	@Autowired
	private AmqpTemplate rabbitTemplate;

	@Override
	public void send(MqRequestDto message) {
		rabbitTemplate.convertSendAndReceive(exchangeFormalDirect, routingKeyLong, message);
	}

	@Override
	public void send(MqRequestDto message, long delayTime) {
		rabbitTemplate.convertAndSend(exchangeDelayDirect, routingKeyLongDelay, message, msg -> {
			msg.getMessageProperties().setExpiration(delayTime + "");
			return msg;
		});
	}
}
