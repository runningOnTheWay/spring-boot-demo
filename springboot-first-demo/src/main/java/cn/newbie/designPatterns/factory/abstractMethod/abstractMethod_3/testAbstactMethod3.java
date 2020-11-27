package cn.newbie.designPatterns.factory.abstractMethod.abstractMethod_3;

public class testAbstactMethod3 {
    public static void main(String[] args) {

        IFactory sqlserverFactory = new SqlserverFactory();

        IUser sqlserverUser = sqlserverFactory.createUser();
        sqlserverUser.show();

        IDepartment sqlserverDepartment = sqlserverFactory.createDepartment();
        sqlserverDepartment.show();


        IFactory mysqlFactory = new MysqlFactory();

        IUser mysqlFactoryUser = mysqlFactory.createUser();
        mysqlFactoryUser.show();

        IDepartment mysqlFactoryDepartment = mysqlFactory.createDepartment();
        mysqlFactoryDepartment.show();
    }
}
