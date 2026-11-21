package main.lld.structural.proxy;

public class ImageProxy implements Image{
    private String fileName;
    private HighResolutionImage image;

    public ImageProxy(String name){
        fileName = name;
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public void display() throws InterruptedException {
        if(image == null){
            System.out.println("Loading Image: " + fileName);
            Thread.sleep(500);
            image = new HighResolutionImage(fileName);
        }
        image.display();
    }
}
