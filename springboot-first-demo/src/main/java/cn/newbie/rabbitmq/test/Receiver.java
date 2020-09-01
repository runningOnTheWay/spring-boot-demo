package cn.newbie.rabbitmq.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Receiver {
  //queue要指定需要监听的队列的名字
  @RabbitListener(queues = RabbitMQConfig.QUEUE)
  public void reveiverDirectQueue(User user){
//    log.info("【receiverDirectQueue监听到消息】" + user.toString());
  }
}
