package cn.newbie.designPatterns.builderPattern.builder_2;

public class Product {

    private String partA;

    private String partB;

    private String partC;

    public void show(){
        System.out.println("partA:" + this.getPartA() + "；partB:" + this.getPartB() + ";partC:" + this.getPartC());
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public String getPartA() {
        return partA;
    }

    public String getPartB() {
        return partB;
    }

    public String getPartC() {
        return partC;
    }
}
