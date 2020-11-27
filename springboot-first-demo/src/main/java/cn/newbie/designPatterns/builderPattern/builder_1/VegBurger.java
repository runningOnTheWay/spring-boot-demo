package cn.newbie.designPatterns.builderPattern.builder_1;

public class VegBurger extends Burger {
  @Override
  public String name() {
    return "Veg Burger";
  }

  @Override
  public float price() {
    return 25.0f;
  }


}
