package com.liutian.designPatterns.statemachine.state;

import com.liutian.designPatterns.statemachine.action.SubwayTransition;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class SubwayState {
    /**
     * 状态编码
     */
    @Getter
    private StateCodeEnums stateCode;

    /**
     * 当前状态下可允许执行的动作
     */
    @Getter
    private List<SubwayTransition> transitions = new ArrayList<>();

    public SubwayState(StateCodeEnums stateCode, SubwayTransition... transitions) {
        this.stateCode = stateCode;
        for (SubwayTransition transition : transitions) {
            this.transitions.add(transition);
        }
    }

    // 添加动作
    public void addTransition(SubwayTransition transition) {
        transitions.add(transition);
    }

    @Override
    public String toString() {
        return stateCode.getDisplayName();
    }
}
