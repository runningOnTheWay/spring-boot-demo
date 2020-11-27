package cn.newbie.designPatterns.builderPattern.builder_1;

public class Coke extends ColdDrink {
  @Override
  public String name() {
    return "Coke";
  }

  @Override
  public float price() {
    return 35.0f;
  }
}
