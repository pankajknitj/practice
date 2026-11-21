package main.lld.structural.composite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Folder implements FileSystemItem{
    private String name;
    private List<FileSystemItem> files = new ArrayList<>();

    public Folder(String name){
        this.name = name;
    }
    @Override
    public double getSize() {
        return files.stream()
                .map(FileSystemItem::getSize)
                .collect(Collectors.summingDouble(Double::doubleValue));
    }

    @Override
    public void printStructure(String indent) {
        System.out.println(indent + "+ " + name);
        files.forEach(file -> file.printStructure(indent + " "));
    }

    @Override
    public void delete() {
        System.out.println("Deleted: " + name);
        files.forEach(FileSystemItem::delete);
    }

    public void addFile(FileSystemItem file){
        files.add(file);
    }
}
