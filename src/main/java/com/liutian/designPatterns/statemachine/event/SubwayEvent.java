package com.liutian.designPatterns.statemachine.event;


import lombok.Getter;
import lombok.Setter;

import java.util.Map;

public class SubwayEvent {
    /**
     * 事件标识（编码）
     */
    @Getter
    private EventCodeEnums eventCode;

    /**
     * 附属的业务参数
     */
    @Getter
    @Setter
    private Map<Object, Object> attributes = null;

    public SubwayEvent(EventCodeEnums eventCode) {
        this.eventCode = eventCode;
    }

    public SubwayEvent(EventCodeEnums eventCode, Map<Object, Object> attributes) {
        this.eventCode = eventCode;
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return eventCode.getCode();
    }
}
