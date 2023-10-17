package com.liutian.designPatterns.flyweight;

import java.util.HashMap;

public class BigCharFactory {
    private static BigCharFactory singleton = new BigCharFactory();
    /**
     * 管理已经生成BigChar的实例
     */
    private HashMap pool = new HashMap();

    private BigCharFactory() {
    }

    public static BigCharFactory getInstance() {
        return singleton;
    }

    /**
     * 生成(共享)BigChar类的实例
     */
    public synchronized BigChar getBigChar(char charname) {
        BigChar bc = (BigChar) pool.get(charname);
        if (bc == null) {
            bc = new BigChar(charname);
            pool.put("" + charname, bc);
        }
        return bc;
    }
}
