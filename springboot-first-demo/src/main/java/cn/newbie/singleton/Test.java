package cn.newbie.singleton;

public class Test {
  public static void main(String[] args){
    SingletonPattern singletonPattern = SingletonPattern.getInstance();
    SingletonPattern singletonPattern1 = SingletonPattern.getInstance();
    singletonPattern1.showMessage();
  }
}
