package cn.newbie.designPatterns.factory.simple;

public class SimpleFactory {

    public static Product createProduct(int productConstant){

        Product product = null;

        switch (productConstant){
            case ProductConstant.product_1:
                product = new Product_1();
                return product;
            case ProductConstant.product_2:
                product = new Product_2();
                return product;
                default:
        }

        return product;
    }
}
