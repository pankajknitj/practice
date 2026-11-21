package main.lld.structural.composite;

public interface FileSystemItem {
    double getSize();
    void printStructure(String indent);
    void delete();
}
