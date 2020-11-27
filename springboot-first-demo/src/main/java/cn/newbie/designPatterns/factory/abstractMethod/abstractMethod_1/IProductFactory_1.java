package cn.newbie.designPatterns.factory.abstractMethod.abstractMethod_1;

public class IProductFactory_1 implements IFactory {

    @Override
    public IProductA createProductA() {
        return new ProductA_1();
    }

    @Override
    public IProductB createProductB() {
        return new ProductB_1();
    }
}
