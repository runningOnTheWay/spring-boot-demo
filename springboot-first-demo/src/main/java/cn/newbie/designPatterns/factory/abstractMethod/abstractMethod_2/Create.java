package cn.newbie.designPatterns.factory.abstractMethod.abstractMethod_2;

public class Create {

    public static IProductA createProductA(String val){

        IProductA productA = null;
        try {
            Class<?> aClass = Class.forName("cn.newbie.designPatterns.factory.abstractMethod.abstractMethod_2." + val);

            Object o = aClass.newInstance();

            productA = (IProductA)o;


        } catch (Exception e) {
            e.printStackTrace();
        }

        return productA;

    }
    public static IProductB createProductB(String val){

        IProductB productB = null;
        try {
            Class<?> bClass = Class.forName("cn.newbie.designPatterns.factory.abstractMethod.abstractMethod_2." + val);

            Object o = bClass.newInstance();

            productB = (IProductB)o;


        } catch (Exception e) {
            e.printStackTrace();
        }

        return productB;

    }
}
