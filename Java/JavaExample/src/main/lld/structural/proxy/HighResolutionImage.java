package main.lld.structural.proxy;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HighResolutionImage implements Image{
    private String fileName;

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + fileName);
    }
}
