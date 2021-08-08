package com.kawasaki.printedadventure.action;

import com.kawasaki.printedadventure.Character.*;

abstract public class Action {
    private GameEntity targetEntity;

    private GameEntity sourceEntity;

    public Action(GameEntity source,GameEntity target){
        this.targetEntity = target;
        this.sourceEntity = source;
    }

    public GameEntity getTargetEntity() {

        return targetEntity;
    }

    public GameEntity getSourceEntity() {
        return sourceEntity;
    }

    public abstract GameEntity Execute(GameEntity target);
}
