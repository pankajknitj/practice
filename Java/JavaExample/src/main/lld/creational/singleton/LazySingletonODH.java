package main.lld.creational.singleton;

public class LazySingletonODH {
    private LazySingletonODH(){}

    //static class, Jvm heavy lift operation to make if thread safe and loaded only once
    // so only one instance would have been created.
    static class SingletonODH{
        private static final LazySingletonODH instance = new LazySingletonODH();
    }

    public LazySingletonODH getInstance(){
        return SingletonODH.instance;
    }
}
