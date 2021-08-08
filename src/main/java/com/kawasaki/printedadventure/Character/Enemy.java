package com.kawasaki.printedadventure.Character;

import com.kawasaki.printedadventure.action.Action;
import com.kawasaki.printedadventure.action.Attack;
import com.kawasaki.printedadventure.game.Game;
import com.kawasaki.printedadventure.item.Item;

import java.util.ArrayList;

public class Enemy extends GameEntity {

    public Enemy(String name, int health,ArrayList<Item> inventory){
        super(name, health,inventory);
    }

    public Action Action(){
        return new Attack(this, Game.getPlayers().stream().findFirst().orElse(null),2);
    }
}
