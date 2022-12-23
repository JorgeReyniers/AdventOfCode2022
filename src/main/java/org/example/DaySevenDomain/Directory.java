package org.example.DaySevenDomain;

import java.util.ArrayList;
import java.util.List;

import static org.example.DaySeven.bestSizeToDelete;
import static org.example.DaySeven.minimumSizeToDelete;

public class Directory {
    private List<Directory> children;
    private Directory parent;
    private String name;

    private int totalSize;

    public Directory(Directory parent, String name) {
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