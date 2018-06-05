package cn.newbie.test;

import cn.newbie.bean.User3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test3")
public class Test3Controller {
    @Autowired
    private User3 user3;
    @RequestMapping(value = "/user3",method = RequestMethod.GET)
    public String hello(){
//        logger.info("info:"+user3.getToString()+","+System.currentTimeMillis());
//        logger.error("error:"+user3.getToString()+","+System.currentTimeMillis());
//        logger.info("DEBUG:"+user3.getToString()+","+System.currentTimeMillis());
        return "name:"+user3.getUsername()+",age:"+user3.getAge()+",toString:"+user3.getToString();
    }

}
