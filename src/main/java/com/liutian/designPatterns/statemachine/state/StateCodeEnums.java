package com.liutian.designPatterns.statemachine.state;

import com.liutian.designPatterns.statemachine.IEnum;

/**
 * 状态枚举类
 */
public enum StateCodeEnums implements IEnum {
    MOVING("MOVING", "行进中"),
    CLOSED("CLOSED", "到站-关门"),
    OPEN("OPEN", "到站-开门"),
    SUSPENDED("SUSPENDED", "停运的");

    private String code;

    private String displayName;

    StateCodeEnums(String code, String displayName) {
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
