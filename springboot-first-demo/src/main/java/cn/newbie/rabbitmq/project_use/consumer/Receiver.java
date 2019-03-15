package cn.newbie.rabbitmq.project_use.consumer;


import cn.newbie.rabbitmq.project_use.MqRequestDto;

public interface Receiver {
	void process(MqRequestDto mqRequestDto);
}
