package com.kawasaki.printedadventure.action;
import com.kawasaki.printedadventure.Character.*;

import javax.swing.text.html.parser.Entity;

public class Attack extends Action{
    private int Damage;

    public Attack(GameEntity source, GameEntity target, int damage){
        super(source, target);
        this.Damage =damage;
    }

    public GameEntity Execute(GameEntity target){
        target.setHealth(target.getHealth() - Damage);

        System.out.println(getSourceEntity().getName() + " Attacked " +
                getTargetEntity().getName() + ", caused " + Damage + " damage."
        );

        return target;
    }
}
