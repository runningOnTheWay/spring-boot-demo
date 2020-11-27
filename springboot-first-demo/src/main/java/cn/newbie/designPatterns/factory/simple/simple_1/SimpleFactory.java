package cn.newbie.designPatterns.factory.simple.simple_1;

public class SimpleFactory {

    public static IProduct createProduct(int productConstant){

        IProduct product;

        switch (productConstant){
            case ProductConstant.product_1:
                product = new Product_1();
                return product;
            case ProductConstant.product_2:
                product = new Product_2();
                return product;
                default:
                    product = null;
        }

        return product;
    }
}
