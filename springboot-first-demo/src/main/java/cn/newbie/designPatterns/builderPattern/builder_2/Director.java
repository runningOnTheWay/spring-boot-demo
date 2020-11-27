package cn.newbie.designPatterns.builderPattern.builder_2;

public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Product buildProduct(){
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();

        return builder.getProduct();
    }
}
