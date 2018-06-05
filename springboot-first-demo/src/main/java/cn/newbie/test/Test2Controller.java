package cn.newbie.test;

import cn.newbie.bean.User;
import cn.newbie.bean.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test2")
public class Test2Controller {
    @Autowired
    private User user;
    @Autowired
    private User2 user2;
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "name:"+user.getUsername()+",age:"+user.getAge();
    }
    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    public String hello1(){
        return "name:"+user2.getUsername()+",age:"+user2.getAge();
    }
}
