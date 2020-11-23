package cn.newbie.designPatterns.factory.simple;

public class testSimpleFactory {
    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();

        Product product1 = (Product_1)simpleFactory.createProduct(ProductConstant.product_1);
        Product product2 = (Product_2)simpleFactory.createProduct(ProductConstant.product_2);


        product1.show();

        product2.show();
        System.out.printf("11");

    }
}
