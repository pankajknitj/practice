package main.lld.structural.proxy;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Image proxyImage = new ImageProxy("image1.png");

        proxyImage.display();
    }
}
