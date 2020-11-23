package cn.newbie.designPatterns.singleton;

public class HungrySingleton {
  private static HungrySingleton singletonPattern;
  private HungrySingleton() {
  }

  public static synchronized HungrySingleton getInstance(){
    if (singletonPattern == null){
      singletonPattern = new HungrySingleton();
    }
    return singletonPattern;
  }
  public void showMessage(){
    System.out.println("Hello word!");
  }
}
