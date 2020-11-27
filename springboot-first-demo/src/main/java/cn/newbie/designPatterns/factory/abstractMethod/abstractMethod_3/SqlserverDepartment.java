package cn.newbie.designPatterns.factory.abstractMethod.abstractMethod_3;

public class SqlserverDepartment implements IDepartment {
    @Override
    public void show() {
        System.out.println("SqlserverDepartment");
    }
}
