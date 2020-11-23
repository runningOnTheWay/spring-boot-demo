package cn.newbie.designPatterns.singleton;


public class Test {
  public static void main(String[] args){
    HungrySingleton singletonPattern = HungrySingleton.getInstance();
    HungrySingleton singletonPattern1 = HungrySingleton.getInstance();
    singletonPattern1.showMessage();


  }
}
