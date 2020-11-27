package cn.newbie.designPatterns.factory.abstractMethod.abstractMethod_3;

public class MysqlDepartment implements IDepartment{
    @Override
    public void show() {
        System.out.println("MysqlDepartment");
    }
}
