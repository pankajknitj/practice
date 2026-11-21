package main.lld.structural.composite;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class File implements FileSystemItem{
    private String name;
    private int size;

    @Override
    public double getSize() {
        return this.size;
    }

    @Override
    public void printStructure(String indent) {
        System.out.println(indent + "- " + name + " " + size + "KB");
    }

    @Override
    public void delete() {
        System.out.println("Deleted: " + name);
    }
}
