package com.liutian.designPatterns.templatemethod;


public class Main {
    public static void main(String[] args) {
        //生成一个持有'H'的charDisplay类的实例
        AbstractDisplay d1 = new CharDisplay('H');
        //生成一个持有“Hello, World.”的StringDisplay类的实例
        AbstractDisplay d2 = new StringDisplay("Hello, world.");
        //生成一个持有“你好，世界。”的StringDisplay类的实例
        AbstractDisplay d3 = new StringDisplay("你好，世界。");
        d1.display(); //由于d1、d2和d3都是AbstractDisplay类的子类
        d2.display(); //可以调用继承的display方法
        d3.display(); //实际的程序行为取决于CharDisplay类和StringDisplay类的具体实现


    }
}
