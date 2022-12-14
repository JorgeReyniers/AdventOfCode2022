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
        for (String command : input.stream().skip(1).collect(Collectors.toList())) {
            if (command.contains("cd")) {
                if (command.contains("..")) {
                    currentDirectory = currentDirectory.getParent();
                } else {
                    String goToDirectory = command.replace("$ cd ","");
                    if (currentDirectory.hasChild(goToDirectory)) {
                        currentDirectory = currentDirectory.goToChild(goToDirectory);
                    } else {
//                        create new directory, add to parent and go to child
                    }
                }
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
//        todo
        return true;
    }

    public MapNode goToChild(String goToDirectory) {
//        todo
        return null;
    }
}
