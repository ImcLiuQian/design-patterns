package com.liutian.designPatterns.statemachine.action;

import com.liutian.designPatterns.statemachine.event.EventCodeEnums;
import com.liutian.designPatterns.statemachine.event.SubwayEvent;
import com.liutian.designPatterns.statemachine.state.SubwayState;
import lombok.Getter;

/**
 * 动作
 */
public abstract class SubwayTransition {
    /**
     * 触发事件
     */
    @Getter
    private EventCodeEnums eventCode;

    /**
     * 触发当前状态
     */
    @Getter
    private SubwayState currState;

    /**
     * 触发后状态
     */
    @Getter
    private SubwayState nextState;

    public SubwayTransition(EventCodeEnums eventCode, SubwayState currState, SubwayState nextState) {
        super();
        this.eventCode = eventCode;
        this.currState = currState;
        this.nextState = nextState;
    }

    /**
     * 执行动作
     *
     * @param event
     * @return
     */
    public SubwayState execute(SubwayEvent event) {
        System.out.println(String.format("当前是：%s状态，执行：%s操作后，流转成：\"%s\"状态。", currState, eventCode, nextState));
        if (this.doExecute(event)) {
            return this.nextState;
        } else {
            return null;
        }
    }

    /**
     * 执行动作的具体业务
     *
     * @param event
     * @return
     */
    protected abstract boolean doExecute(SubwayEvent event);
}
