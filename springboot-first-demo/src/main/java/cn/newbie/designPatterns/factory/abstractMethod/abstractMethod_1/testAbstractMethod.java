package cn.newbie.designPatterns.factory.abstractMethod.abstractMethod_1;

public class testAbstractMethod {

    public static void main(String[] args) {
        IFactory productFactory_1 = new IProductFactory_1();

        IProductA productA = productFactory_1.createProductA();
        productA.show();

        IProductB productB = productFactory_1.createProductB();
        productB.show();


        IProductFactory_2 productFactory_2 = new IProductFactory_2();

        IProductA productA2 = productFactory_2.createProductA();

        productA2.show();


        IProductB productB2 = productFactory_2.createProductB();

        productB2.show();


    }



}
