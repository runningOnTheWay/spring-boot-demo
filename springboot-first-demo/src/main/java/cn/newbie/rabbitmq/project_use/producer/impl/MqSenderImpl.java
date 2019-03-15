package cn.newbie.rabbitmq.project_use.producer.impl;

import cn.newbie.rabbitmq.project_use.MqRequestDto;
import cn.newbie.rabbitmq.project_use.MqSender;
import cn.newbie.rabbitmq.project_use.producer.DelaySender;
import cn.newbie.rabbitmq.project_use.producer.Sender;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("rabbitmqImpl")
public class MqSenderImpl implements MqSender {

	@Resource
	Sender numberSender;

	@Resource
	Sender compensatingSender;

	@Resource
	Sender logSender;

	@Resource
	DelaySender longSender;

	/**
	 * 发番回写数据库mq处理
	 * @param mqRequestDto
	 */
	@Override
	public void sendNumber(MqRequestDto mqRequestDto) {
		numberSender.send(mqRequestDto);
	}

	/**
	 * 登录mq消息发送
	 * @param mqRequestDto
	 */
	@Override
	public void sendLogin(MqRequestDto mqRequestDto) {

	}

	/**
	 * 事务补偿，包括成功和失败的处理
	 * @param mqRequestDto
	 */
	@Override
	public void sendCompensating(MqRequestDto mqRequestDto) {
		compensatingSender.send(mqRequestDto);
	}

	/**
	 * 事务延迟消息发送，设置5分钟延迟
	 * @param mqRequestDto
	 */
	@Override
	public void sendLongDelay(MqRequestDto mqRequestDto) {
		longSender.send(mqRequestDto, 5 * 60 * 1000);
	}

	/**
	 * 记录操作日志
	 * @param mqRequestDto
	 */
	@Override
	public void sendLog(MqRequestDto mqRequestDto) {
		logSender.send(mqRequestDto);
	}
}
