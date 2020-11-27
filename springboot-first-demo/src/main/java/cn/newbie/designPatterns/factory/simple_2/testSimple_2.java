package cn.newbie.designPatterns.factory.simple_2;

public class testSimple_2 {
    public static void main(String[] args) {
        Operation operationSub = OperationFactory.getOperation("-");
        operationSub.setNumber_A(2d);
        operationSub.setNumber_B(1d);
        System.out.println(operationSub.getResult().toString());

        Operation operationAdd = OperationFactory.getOperation("+");
        operationAdd.setNumber_A(2d);
        operationAdd.setNumber_B(1d);
        System.out.println(operationAdd.getResult().toString());

        Operation operationMul = OperationFactory.getOperation("*");
        operationMul.setNumber_A(2d);
        operationMul.setNumber_B(1d);
        System.out.println(operationMul.getResult().toString());
    }
}
