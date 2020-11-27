package cn.newbie.designPatterns.factory.method.method_2;

public class FactorySub implements IOperationFactory {
    @Override
    public Operation getOperation() {
        return new OperationSub();
    }
}
