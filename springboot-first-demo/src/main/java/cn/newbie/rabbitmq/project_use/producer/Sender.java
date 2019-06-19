package cn.newbie.rabbitmq.project_use.producer;

import cn.newbie.rabbitmq.project_use.MqRequestDto;

public interface Sender {

	void send(MqRequestDto mqRequestDto);
}
