package cn.newbie.designPatterns.factory.simple_2;

public class OperationAdd extends Operation{
    @Override
    public Double getResult() {

        Double result = getNumber_A() + getNumber_B();

        return result;
    }
}
