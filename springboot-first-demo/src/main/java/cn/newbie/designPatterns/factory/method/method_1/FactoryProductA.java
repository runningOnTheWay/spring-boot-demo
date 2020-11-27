package cn.newbie.designPatterns.factory.method.method_1;

public class FactoryProductA implements IFactory{

    @Override
    public IProduct createProduct() {

        System.out.println("FactoryProductA");

        return new ProductA();
    }
}
