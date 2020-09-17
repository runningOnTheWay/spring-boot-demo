package cn.newbie.test;


import cn.newbie.bean.PropertiesConfig;
import cn.newbie.bean.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;
import java.util.TreeSet;

@Controller
public class TestController {
    @Autowired
    private PropertiesConfig propertiesConfig;
    @Autowired
    private User2 user2;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ResponseBody
    public String hello(){
        return "hello hello";
    }
    @RequestMapping(value="/hello1",method = RequestMethod.GET)
    @ResponseBody
    public String hello1(){
        Set set = new TreeSet();
//        return propertiesConfig.getName()+propertiesConfig.getAge();
        return propertiesConfig.getToString()+","+user2.getToString();
    }
    
}
