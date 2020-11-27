package cn.newbie.designPatterns.factory.abstractMethod.abstractMethod_2;

public class testAbstractMethod2 {

    public static void main(String[] args) {
        IProductA prouctA_1 = Create.createProductA("ProductA_1");
        prouctA_1.show();

        IProductA prouctA_2 = Create.createProductA("ProductA_2");
        prouctA_2.show();

        IProductB prouctB_1 = Create.createProductB("ProductB_1");
        prouctB_1.show();

        IProductB prouctB_2 = Create.createProductB("ProductB_2");
        prouctB_2.show();
    }
}
