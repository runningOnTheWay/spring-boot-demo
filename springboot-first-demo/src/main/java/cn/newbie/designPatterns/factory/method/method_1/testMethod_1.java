package cn.newbie.designPatterns.factory.method.method_1;

public class testMethod_1 {
    public static void main(String[] args) {
        FactoryProductA factoryProductA = new FactoryProductA();
        IProduct productA = factoryProductA.createProduct();
        productA.show();

        FactoryProductB factoryProductB = new FactoryProductB();
        IProduct productB = factoryProductB.createProduct();
        productB.show();
    }
}
