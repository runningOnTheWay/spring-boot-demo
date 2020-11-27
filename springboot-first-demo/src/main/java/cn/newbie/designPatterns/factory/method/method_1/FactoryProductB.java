package cn.newbie.designPatterns.factory.method.method_1;

public class FactoryProductB implements IFactory {
    @Override
    public IProduct createProduct() {

        System.out.println("FactoryProductB");

        return new ProductB();
    }
}
