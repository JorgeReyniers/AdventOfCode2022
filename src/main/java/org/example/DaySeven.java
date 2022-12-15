package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DaySeven implements Day {
    @Override
    public int execute(ArrayList<String> input) {
//        options: cd, ls
//        options after ls: dir, number, cd
//        $ cd /
//        $ ls
//        dir a
//        14848514 b.txt
//        8504156 c.dat
//        dir d
        MapNode currentDirectory = new MapNode(null, "/");
        for (String command : input.stream().skip(1).filter(command -> !command.contains("ls")).collect(Collectors.toList())) {
            if (command.contains("cd")) {
                if (command.contains("..")) {
                    currentDirectory = currentDirectory.getParent();
                } else {
                    String goToDirectory = command.replace("$ cd ", "");
                    if (!currentDirectory.hasChild(goToDirectory)) {
//                        create new directory, add to parent and go to child
                        MapNode newChild = new MapNode(currentDirectory, goToDirectory);
                        currentDirectory.addChild(newChild);
                    }
                    currentDirectory = currentDirectory.goToChild(goToDirectory);
                }
            } else if (!command.contains("dir")) {
//                Add size of file in currentDirectory
            }
        }
        return 0;
    }
}

class MapNode {
    private List<MapNode> children;
    private MapNode parent;
    private String name;
    private int totalSize;

    MapNode(MapNode parent, String name) {
        this.children = new ArrayList<>();
        this.parent = parent;
        this.name = name;
    }

    public List<MapNode> getChildren() {
        return children;
    }

    public void setChildren(List<MapNode> children) {
        this.children = children;
    }

    public MapNode getParent() {
        return parent;
    }

    public void setParent(MapNode parent) {
        this.parent = parent;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean hasChild(String goToDirectory) {
        return this.children.stream().anyMatch(child -> child.getName() == goToDirectory);
    }

    public MapNode goToChild(String goToDirectory) {
        return this.children.stream().filter(child -> child.getName() == goToDirectory).findFirst().get();
    }

    public void addChild(MapNode newChild) {
        this.children.add(newChild);
    }
}
