package cn.newbie.rabbitmq.project_use.consumer.impl;


import cn.newbie.rabbitmq.project_use.MqRequestDto;
import cn.newbie.rabbitmq.project_use.consumer.Receiver;
import cn.newbie.rabbitmq.project_use.util.OutUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "${test.mq.queue.number}")
public class NumberReceiver implements Receiver {
	private static Logger logger = LoggerFactory.getLogger(NumberReceiver.class);

	@Value("${test.mq.queue.number}")
	private String queueName;

	@RabbitHandler
	@Async
	public void process(MqRequestDto message) {
		logger.info(OutUtil.outMq(queueName, message));

		try {
			// 判断收到的消息不为空
			if (null!=message.getBody()&&""!=message.getBody()) {
				logger.info("message:"+message.toString());
			}
		} catch (Exception e) {
			//【并发会触发乐观锁】
			//logger.error("MESSAGE:[发番更新MQ消费错误]，MQ消息内容：["+FastJsonUtil.toJSONString(message)+"]");
			//MqErrorUtil.saveMqErrorUtil(e, message, "发番更新MQ消费错误", requestCommonDto);
			e.printStackTrace();
		}
	}
}
