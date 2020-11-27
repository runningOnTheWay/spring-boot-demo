package cn.newbie.designPatterns.factory.method.method_2;

public class testMethod_2 {
    public static void main(String[] args) {
        FactoryAdd factoryAdd = new FactoryAdd();
        Operation addOperation = factoryAdd.getOperation();
        addOperation.setNumber_A(2d);
        addOperation.setNumber_B(1d);

        System.out.println(addOperation.getResult());

        FactorySub factorySub = new FactorySub();
        Operation subOperation = factorySub.getOperation();
        subOperation.setNumber_A(2d);
        subOperation.setNumber_B(1d);

        System.out.println(subOperation.getResult());


    }
}
