package cn.newbie.designPatterns.builderPattern.builder_2;

public class Builder2 extends Builder {
    @Override
    public void buildPartA() {
        product.setPartA("2-A");
    }

    @Override
    public void buildPartB() {
        product.setPartB("2-B");
    }

    @Override
    public void buildPartC() {
        product.setPartC("2-C");
    }
}
