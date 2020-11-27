package cn.newbie.designPatterns.factory.abstractMethod.abstractMethod_3;

public class MysqlUser implements IUser{
    @Override
    public void show() {
        System.out.println("MysqlUser");
    }
}
