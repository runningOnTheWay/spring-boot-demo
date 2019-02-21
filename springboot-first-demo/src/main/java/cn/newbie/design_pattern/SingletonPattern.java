package cn.newbie.design_pattern;

public class SingletonPattern {
  private static SingletonPattern singletonPattern;
  private SingletonPattern() {
  }

  public static synchronized SingletonPattern getInstance(){
    if (singletonPattern == null){
      System.out.println(1);
      singletonPattern = new SingletonPattern();
    }
    return singletonPattern;
  }
  public void showMessage(){
    System.out.println("Hello word!");
  }
}
