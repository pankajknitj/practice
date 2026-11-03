package main.lld.creational.singleton;

public class EagerSingleton {
    //initialized at class load time
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton(){}

    public EagerSingleton getInstance(){
        return instance;
    }
}
