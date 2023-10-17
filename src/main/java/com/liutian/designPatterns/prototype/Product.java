package com.liutian.designPatterns.prototype;

public interface Product extends Cloneable {
    void use(String s);

    Product createClone();
}
