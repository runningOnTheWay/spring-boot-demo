package cn.newbie.designPatterns.factory.simple_1;

public class testSimpleFactory {
    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();

        Product product1 = simpleFactory.createProduct(ProductConstant.product_1);
        Product product2 = simpleFactory.createProduct(ProductConstant.product_2);


        product1.show();

        product2.show();
        System.out.printf("11");

    }
}
