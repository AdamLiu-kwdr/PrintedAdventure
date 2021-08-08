package com.kawasaki.printedadventure.action;

import com.kawasaki.printedadventure.Character.GameEntity;

public class Heal extends Action {
    private int Recover;

    public Heal(GameEntity source, GameEntity target, int recover){
        super(source, target);
        this.Recover = recover;
    }

    public GameEntity Execute(GameEntity target){
        target.setHealth(target.getHealth() + Recover);

        System.out.println(getSourceEntity().getName() + " healed " + Recover + "hp."
        );

        return target;
    }
}
