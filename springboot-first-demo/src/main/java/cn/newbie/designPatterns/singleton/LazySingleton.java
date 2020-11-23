package cn.newbie.designPatterns.singleton;

public class LazySingleton {

    private static volatile LazySingleton singleton = null;

    public LazySingleton() {

    }

    public static synchronized LazySingleton getInstance(){
        if (singleton == null) {
            singleton = new LazySingleton();
        }

        return singleton;
    }
}
