package cn.newbie.designPatterns.factory.simple.simple_2;

public class OperationFactory {
    public static Operation getOperation(String operationVal){
        Operation operation;

        switch (operationVal){
            case "+" :
                operation = new OperationAdd();
                return operation;
            case "-" :
                operation = new OperationSub();
                return operation;
            case "*" :
                operation = new OperationMul();
                return operation;

                default:
                    operation = null;

        return operation;
        }
    }
}
