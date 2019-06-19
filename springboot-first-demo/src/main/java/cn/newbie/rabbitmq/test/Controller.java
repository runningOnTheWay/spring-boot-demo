package cn.newbie.rabbitmq.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
  @Autowired
  private  Sender sender;
  @GetMapping("/sendDirectQueue")
  public Object sendDirectQueue() {
    sender.sendDirectQueue();
    return "ok";
  }
}
