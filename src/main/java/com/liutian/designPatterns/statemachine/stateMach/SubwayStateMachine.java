package com.liutian.designPatterns.statemachine.stateMach;

import com.liutian.designPatterns.statemachine.action.SubwayTransition;
import com.liutian.designPatterns.statemachine.event.EventCodeEnums;
import com.liutian.designPatterns.statemachine.event.SubwayEvent;
import com.liutian.designPatterns.statemachine.state.StateCodeEnums;
import com.liutian.designPatterns.statemachine.state.SubwayState;

import java.util.ArrayList;
import java.util.List;

public class SubwayStateMachine extends SubwayAbsStateMachine {
    @Override
    public List<SubwayState> declareAllStates() {//定义状态机的状态
        ArrayList<SubwayState> stateList = new ArrayList<>();

        SubwayState movingState = new SubwayState(StateCodeEnums.MOVING);
        SubwayState closedState = new SubwayState(StateCodeEnums.CLOSED);
        SubwayState openState = new SubwayState(StateCodeEnums.OPEN);
        SubwayState suspensionState = new SubwayState(StateCodeEnums.SUSPENDED);

        movingState.addTransition(new BrakeTransition(movingState, closedState));

        closedState.addTransition(new StartupTransition(closedState, movingState));
        closedState.addTransition(new OpenTransition(closedState, openState));

        openState.addTransition(new CloseTransition(openState, closedState));

        suspensionState.addTransition(new StartupTransition(suspensionState, movingState));

        stateList.add(movingState);
        stateList.add(closedState);
        stateList.add(openState);
        stateList.add(suspensionState);

        return stateList;
    }

    /**
     * 定义“刹车”动作
     */
    public class BrakeTransition extends SubwayTransition {

        public BrakeTransition(SubwayState currState, SubwayState nextState) {
            super(EventCodeEnums.BRAKING, currState, nextState);
        }

        @Override
        protected boolean doExecute(SubwayEvent event) {
            System.out.println("执行刹车操作...");
            return true;
        }
    }

    /**
     * 定义“启动”动作
     */
    public class StartupTransition extends SubwayTransition {

        public StartupTransition(SubwayState currState, SubwayState nextState) {
            super(EventCodeEnums.START_UP, currState, nextState);
        }

        @Override
        protected boolean doExecute(SubwayEvent event) {
            System.out.println("执行启动操作...");
            return true;
        }
    }

    /**
     * 关门
     */
    public class CloseTransition extends SubwayTransition {

        public CloseTransition(SubwayState currState, SubwayState nextState) {
            super(EventCodeEnums.CLOSING, currState, nextState);
        }

        @Override
        protected boolean doExecute(SubwayEvent event) {
            System.out.println("执行关门操作");
            return true;
        }
    }

    /**
     * 开门
     */
    public class OpenTransition extends SubwayTransition {

        public OpenTransition(SubwayState currState, SubwayState nextState) {
            super(EventCodeEnums.OPENING, currState, nextState);
        }

        @Override
        protected boolean doExecute(SubwayEvent event) {
            System.out.println("执行开门操作");
            return true;
        }
    }
}
