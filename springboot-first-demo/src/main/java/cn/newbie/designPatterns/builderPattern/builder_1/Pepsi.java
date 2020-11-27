package cn.newbie.designPatterns.builderPattern.builder_1;

public class Pepsi extends ColdDrink {
  @Override
  public String name() {
    return "Pepsi";
  }

  @Override
  public float price() {
    return 30.0f;
  }
}
