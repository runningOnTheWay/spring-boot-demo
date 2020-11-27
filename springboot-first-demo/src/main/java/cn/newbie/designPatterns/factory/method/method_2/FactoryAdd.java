package cn.newbie.designPatterns.factory.method.method_2;

public class FactoryAdd implements IOperationFactory{

    @Override
    public Operation getOperation() {
        return new OperationAdd();
    }
}
