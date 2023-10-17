package com.liutian.designPatterns.statemachine;

import com.liutian.designPatterns.statemachine.event.EventCodeEnums;
import com.liutian.designPatterns.statemachine.event.SubwayEvent;
import com.liutian.designPatterns.statemachine.state.StateCodeEnums;
import com.liutian.designPatterns.statemachine.state.SubwayState;
import com.liutian.designPatterns.statemachine.stateMach.SubwayStateMachine;

public class TestSubwayStateMachine {
    public static void main(String[] args) {
        SubwayStateMachine sm = new SubwayStateMachine();
        SubwayState execute = sm.execute(StateCodeEnums.MOVING, new SubwayEvent(EventCodeEnums.BRAKING));
    }
}
