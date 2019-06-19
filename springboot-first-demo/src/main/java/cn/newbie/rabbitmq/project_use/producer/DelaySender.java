package cn.newbie.rabbitmq.project_use.producer;

import cn.newbie.rabbitmq.project_use.MqRequestDto;

public interface DelaySender {
	void send(MqRequestDto mqRequestDto, long delayTime);
}
