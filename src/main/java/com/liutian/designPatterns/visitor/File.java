package com.liutian.designPatterns.visitor;

public class File extends Entry {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
        this.fullPath = "/" + name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
    }

    @Override
    public String getFullPath() {
        return fullPath;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
