package cn.newbie.rabbitmq.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Sender {
  @Autowired
  private AmqpTemplate amqpTemplate;

  public void sendDirectQueue(){
//    User user = new User();
    User user = User.builder().name("test").userId("123456").build();
    log.info("【sendDirectQueue已发送消息】");
    // 第一个参数是指要发送到哪个队列里面， 第二个参数是指要发送的内容
    this.amqpTemplate.convertAndSend(RabbitMQConfig.QUEUE, user);
  }
}
