package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

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
        String currentDirectory = "";
        for (String command : input) {
            if (command.contains("cd")) {
                TreeMap<Integer, String> employees = new TreeMap<>();
            }
        }
        return 0;
    }
}

class RootDirectory {
    private List<MapNode> childen;

    public RootDirectory(List<MapNode> childen) {
        this.childen = childen;
    }

    public List<MapNode> getChilden() {
        return childen;
    }

    public void setChilden(List<MapNode> childen) {
        this.childen = childen;
    }
}

class MapNode {
    private List<MapNode> children;
    private MapNode parent;
    private int totalSize;

    MapNode(List<MapNode> children, MapNode parent, int totalSize) {
        this.children = children;
        this.parent = parent;
        this.totalSize = totalSize;
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
}
