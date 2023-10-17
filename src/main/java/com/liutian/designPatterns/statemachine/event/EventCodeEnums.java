package com.liutian.designPatterns.statemachine.event;

import com.liutian.designPatterns.statemachine.IEnum;

/**
 * 事件类型
 */
public enum EventCodeEnums implements IEnum {

    START_UP("START_UP", "启动"),
    CLOSING("CLOSING", "关门"),
    OPENING("OPENING", "开门"),
    BRAKING("BRAKING", "刹车");

    private String code;
    private String displayName;

    EventCodeEnums(String code, String displayName) {
        this.code = code;
        this.displayName = displayName;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
