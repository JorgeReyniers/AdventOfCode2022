package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.DaySeven.bestSizeToDelete;
import static org.example.DaySeven.minimumSizeToDelete;

public class DaySeven implements Day {
    public static int bestSizeToDelete = 0;
    public static int minimumSizeToDelete = 0;
    @Override
    public int execute(ArrayList<String> input) {
        Directory currentDirectory = new Directory(null, "/");
        for (String command : input.stream().skip(1).collect(Collectors.toList())) {
            if (command.contains("$ cd")) {
                if (command.contains("..")) {
                    currentDirectory = currentDirectory.getParent();
                } else {
                    String goToDirectory = command.replace("$ cd ", "");
                    if (!currentDirectory.hasChild(goToDirectory)) {
                        Directory newChild = new Directory(currentDirectory, goToDirectory);
                        currentDirectory.addChild(newChild);
                    }
                    currentDirectory = currentDirectory.goToChild(goToDirectory);
                }
            } else if (!command.contains("dir") && !command.contains("$ ls")) {
                int size = Integer.parseInt(command.split(" ")[0]);
                AddSizeToDirectoryAndParents(currentDirectory, size);
            }
        }
        Directory rootDirectory = returnToRootDirectory(currentDirectory);
        minimumSizeToDelete = 30000000 - (70000000 - rootDirectory.getTotalSize());
        System.out.println(rootDirectory);
        return bestSizeToDelete;
    }

    private static void AddSizeToDirectoryAndParents(Directory currentDirectory, int size) {
        Directory directoryToAddSize = currentDirectory;
        while(directoryToAddSize.getParent() != null) {
            directoryToAddSize.increaseSize(size);
            directoryToAddSize = directoryToAddSize.getParent();
        }
        directoryToAddSize.increaseSize(size);
    }

    private Directory returnToRootDirectory(Directory currentDirectory) {
        while (currentDirectory.getParent() != null) {
            currentDirectory = currentDirectory.getParent();
        }
        return currentDirectory;
    }
}

class Directory {
    private List<Directory> children;
    private Directory parent;
    private String name;

    private int totalSize;

    Directory(Directory parent, String name) {
        this.children = new ArrayList<>();
        this.parent = parent;
        this.name = name;
    }
    public Directory getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

    public boolean hasChild(String goToDirectory) {
        return this.children.stream().anyMatch(child -> child.getName() == goToDirectory);
    }

    public Directory goToChild(String goToDirectory) {
        return this.children.stream().filter(child -> child.getName() == goToDirectory).findFirst().get();
    }

    public void addChild(Directory newChild) {
        this.children.add(newChild);
    }

    public void increaseSize(int size) {
        this.totalSize += size;
    }

    public int getTotalSize() {
        return totalSize;
    }

    @Override
    public String toString() {
        if (this.totalSize >= minimumSizeToDelete && (this.totalSize < bestSizeToDelete || bestSizeToDelete == 0)) {
            bestSizeToDelete = this.totalSize;
        }
        return "" + children;
    }
}
