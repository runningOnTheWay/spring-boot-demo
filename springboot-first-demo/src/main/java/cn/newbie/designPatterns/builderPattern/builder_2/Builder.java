package cn.newbie.designPatterns.builderPattern.builder_2;

public abstract class Builder {

    protected Product product = new Product();

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract void buildPartC();

    public Product getProduct(){
        return product;
    }
}
