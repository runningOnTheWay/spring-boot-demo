package cn.newbie.rabbitmq.project_use.util;


import cn.newbie.rabbitmq.project_use.MqRequestDto;

import java.util.Date;

public class OutUtil {
    public static String outMq(String queueName, MqRequestDto message){
        long nowtime = System.currentTimeMillis();
        String now = nowtime+","+DateUtil.formatDate(new Date(nowtime), DateUtil.DATE_TIME_FORMAT);
        return "LOGTIME:["+now+"],MESSAGE:[队列"+queueName+",test_uid:"+message.getRequestHeaderDto().getTest_uid()+"]";
    }
}
