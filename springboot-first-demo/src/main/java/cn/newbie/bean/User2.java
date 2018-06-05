package cn.newbie.bean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
/**
 *ignoreResourceNotFound含义是当指定的配置文件不存在是否报错，默认是false;比如上文中指定的加载属性文件是jdbc-bainuo-dev.properties。如果该文件不存在，则ignoreResourceNotFound为true的时候，程序不会报错，如果ignoreResourceNotFound为false的时候，程序直接报错。实际项目开发中，最好设置ignoreResourceNotFound为false。该参数默认值为false。
 *value值是设置需要加载的属性文件，可以一次性加载多个。name的值我们设置的是jdbc-bainuo-dev.properties。这个值在Springboot的环境中必须是唯一的，如果不设置，则值为：“class path resource [config/jdbc-bainuo-dev.properties]“。
 */
@PropertySource(value = "classpath:config/application-test.properties",ignoreResourceNotFound = false,encoding = "utf-8")
@ConfigurationProperties(prefix ="test.user")
public class User2 {
    private String username;
    private int age;
    private String toString;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getToString() {
        return toString;
    }

    public void setToString(String toString) {
        this.toString = toString;
    }
}
