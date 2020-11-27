package cn.newbie.designPatterns.factory.simple.simple_2;

public class OperationSub extends Operation{
    @Override
    public Double getResult() {

        Double result = getNumber_A() - getNumber_B();

        return result;
    }
}
