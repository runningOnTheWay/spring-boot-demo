package cn.newbie.designPatterns.factory.abstractMethod.abstractMethod_3;

public class MysqlFactory implements IFactory {
    @Override
    public IUser createUser() {
        return new MysqlUser();
    }

    @Override
    public IDepartment createDepartment() {
        return new MysqlDepartment();
    }
}
