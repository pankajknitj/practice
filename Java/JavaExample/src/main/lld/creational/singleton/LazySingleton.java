package main.lld.creational.singleton;

public class LazySingleton {
    static private volatile LazySingleton instance;

    //objects can be created only inside this class.
    private LazySingleton(){}

    //Double check locking for thread safety
    public static LazySingleton getInstance(){
        if(instance == null){
            synchronized (LazySingleton.class){
                if(instance == null){
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
