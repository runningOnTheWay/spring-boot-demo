package cn.newbie.designPatterns.builderPattern.builder_2;

public class testBuilder2 {

    public static void main(String[] args) {
        Director director = new Director(new Builder1());

        Product product = director.buildProduct();

        product.show();


        Director director2 = new Director(new Builder2());

        Product product2 = director2.buildProduct();

        product2.show();

    }
}
