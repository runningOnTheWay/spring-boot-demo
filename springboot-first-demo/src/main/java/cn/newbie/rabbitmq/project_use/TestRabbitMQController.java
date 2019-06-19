package cn.newbie.rabbitmq.project_use;

import cn.newbie.rabbitmq.test.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRabbitMQController {
  @Autowired
  public MqSender mqSender;
  @GetMapping("/testRabbitMQProjectUse")
  public String testRabbitMQProjectUse(){
    MqRequestDto mqRequestDto = new MqRequestDto();
    mqRequestDto.setBody(User.builder().name("t1").userId("12").build());
    mqRequestDto.setRequestHeaderDto(RequestHeaderDto.builder().test_uid("t_uid").build());
    mqSender.sendNumber(mqRequestDto);
    return "ok";
  }
}
