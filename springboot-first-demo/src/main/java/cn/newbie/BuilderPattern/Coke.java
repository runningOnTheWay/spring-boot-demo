package cn.newbie.BuilderPattern;

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
