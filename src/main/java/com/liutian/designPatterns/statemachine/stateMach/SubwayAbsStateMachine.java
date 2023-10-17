package com.liutian.designPatterns.statemachine.stateMach;

import com.liutian.designPatterns.statemachine.action.SubwayTransition;
import com.liutian.designPatterns.statemachine.event.SubwayEvent;
import com.liutian.designPatterns.statemachine.state.StateCodeEnums;
import com.liutian.designPatterns.statemachine.state.SubwayState;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public abstract class SubwayAbsStateMachine {
    /**
     * 定义所有的状态
     */
    private static List<SubwayState> allStates = null;

    /**
     * 状态机执行事件
     *
     * @param stateCode
     * @param event
     * @return
     */
    public SubwayState execute(StateCodeEnums stateCode, SubwayEvent event) {
        SubwayState startState = this.getState(stateCode);
        for (SubwayTransition transition : startState.getTransitions()) {
            if (event.getEventCode().equals(transition.getEventCode())) {
                return transition.execute(event);
            }
        }
        log.error("StateMachine[{}] Can not find transition for stateId[{}] event[{}]",
                this.getClass().getSimpleName(), stateCode, event.getEventCode());
        return null;
    }

    public SubwayState getState(StateCodeEnums stateCode) {
        if (allStates == null) {
            log.info("StateMachine declareAllStates");
            allStates = this.declareAllStates();
        }

        for (SubwayState state : allStates) {
            if (state.getStateCode().equals(stateCode)) {
                return state;
            }
        }
        return null;
    }

    /**
     * 由具体的状态机定义所有状态
     *
     * @return
     */
    public abstract List<SubwayState> declareAllStates();
}
