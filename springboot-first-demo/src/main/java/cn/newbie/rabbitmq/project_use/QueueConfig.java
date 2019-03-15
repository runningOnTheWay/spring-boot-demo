package cn.newbie.rabbitmq.project_use;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class QueueConfig {

	@Value("${test.mq.queue.number}")
	private String queueNumber;

	@Value("${test.mq.queue.long}")
	private String queueLong;

	@Value("${test.mq.queue.long-delay}")
	private String queueLongDelay;

	@Value("${test.mq.queue.compensating}")
	private String queueCompensating;

	@Value("${test.mq.routing-key.long}")
	private String routingKeyLong;

	@Value("${test.mq.exchange.formal-direct}")
	private String exchangeFormalDirect;

	@Value("${test.mq.queue.log}")
	private String queueLog;

	/**
	 * 发番队列
	 * @return
	 */
	@Bean
	public Queue queueNumber() {
		return new Queue(queueNumber);
	}

	/**
	 * 事务一致性队列
	 * @return
	 */
	@Bean
	public Queue queueLong() {
		return new Queue(queueLong);
	}

	/**
	 * 事务一致性延迟队列
	 * @return
	 */
	@Bean
	public Queue queueLongDelay() {
		Map<String, Object> params = new HashMap<>();
		params.put(Constants.DEAD_LETTER_EXCHANGE, exchangeFormalDirect);
		/** 声明了这些死信在转发时携带的 routing-key 名称。*/
		params.put(Constants.DEAD_LETTER_ROUTING_KEY, routingKeyLong);
		return new Queue(queueLongDelay, true, false, false, params);
	}

	/**
	 * 分布式事务补偿
	 * @return
	 */
	@Bean
	public Queue queueCompensating() {
		return new Queue(queueCompensating);
	}

	/**
	 * 记录操作日志到数据库
	 * @return
	 */
	@Bean
	public Queue queueLog() {
		return new Queue(queueLog);
	}

}
