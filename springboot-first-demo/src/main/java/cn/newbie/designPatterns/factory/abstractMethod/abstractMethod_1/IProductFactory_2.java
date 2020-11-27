package cn.newbie.designPatterns.factory.abstractMethod.abstractMethod_1;

public class IProductFactory_2 implements IFactory {
    @Override
    public IProductA createProductA() {
        return new ProductA_2();
    }

    @Override
    public IProductB createProductB() {
        return new ProductB_2();
    }
}
