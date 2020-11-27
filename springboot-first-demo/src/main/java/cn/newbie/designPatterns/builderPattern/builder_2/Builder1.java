package cn.newbie.designPatterns.builderPattern.builder_2;

public class Builder1 extends Builder {
    @Override
    public void buildPartA() {
        product.setPartA("1-A");
    }

    @Override
    public void buildPartB() {
        product.setPartB("1-B");
    }

    @Override
    public void buildPartC() {
        product.setPartC("1-C");
    }
}
