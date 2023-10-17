package com.liutian.designPatterns.factorymethod.main;

import com.liutian.designPatterns.factorymethod.framework.Product;
import com.liutian.designPatterns.factorymethod.idcard.IDCardFactory;

public class Main {
    public static void main(String[] args) {
        IDCardFactory factory = new IDCardFactory();
        Product card1 = factory.create("小明");
        Product card2 = factory.create("小红");
        Product card3 = factory.create("小刚");
        card1.use();
        card2.use();
        card3.use();
    }
}
