package cn.newbie.designPatterns.builderPattern;

public class Bottle implements Packing {
  @Override
  public String pack() {
    return "Bottle";
  }
}
