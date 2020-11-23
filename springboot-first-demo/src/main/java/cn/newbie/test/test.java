package cn.newbie.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    public static void main(String[] args){
//        Long d = 1497139200l;
//        Long d =  1527984000l;
        Long d =  1527984000l;
        Long d1 = 1527379200l;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = new Date(d*1000);
            String result = sf.format(date);

            Date date1 = new Date(d1*1000);
            String result1 = sf.format(date1);
//            System.out.printf("d:"+result+";d1:"+result1);


            Class<?> aClass = Class.forName("cn.newbie.test.TestAbstract2");
            TestAbstract o = (TestAbstract)aClass.newInstance();
            String execute = o.execute();
            System.out.println(execute);



            Class<?> bClass = Class.forName("cn.newbie.test.TestAbstract");
            TestAbstract testAbstract = (TestAbstract)bClass.newInstance();
            String execute1 = testAbstract.execute();
            System.out.println(execute1);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
