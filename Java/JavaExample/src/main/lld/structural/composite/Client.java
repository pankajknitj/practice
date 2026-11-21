package main.lld.structural.composite;

public class Client {
    public static void main(String[] args) {
        Folder topFolder = new Folder("TopFolder");
        Folder childFolder = new Folder("ChildFolder)");

        File file1 = new File("file1",100);
        File file2 = new File("file2",150);

        childFolder.addFile(file2);

        topFolder.addFile(childFolder);
        topFolder.addFile(file1);

        topFolder.printStructure("");

    }
}
