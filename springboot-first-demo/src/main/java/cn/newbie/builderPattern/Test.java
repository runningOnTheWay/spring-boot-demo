package cn.newbie.builderPattern;

public class Test {
  public static void main(String[] args){
    MealBuilder mealBuilder = new MealBuilder();
    Meal vegMeal = mealBuilder.prepareVegMeal();
    System.out.println("Veg Meal");
    vegMeal.showItems();
    System.out.println("Total Cost: " +vegMeal.getCost());

    Meal nonVegMeal = mealBuilder.prepareChickenMeal();
    System.out.println("\n\nNon-Veg Meal");
    nonVegMeal.showItems();
    System.out.println("Total Cost: " +nonVegMeal.getCost());
  }


}
