package com.liutian.designPatterns.mediator;

public interface Colleague {
    void setMediator(Mediator mediator);

    void setColleagueEnabled(boolean enabled);
}
