package com.kawasaki.printedadventure.Character;

import com.kawasaki.printedadventure.action.Action;
import com.kawasaki.printedadventure.action.Attack;
import com.kawasaki.printedadventure.game.Game;
import com.kawasaki.printedadventure.item.*;
import java.util.ArrayList;

public class Player extends GameEntity {

    public Player(String name, int health,ArrayList<Item> inventory){
        super(name, health,inventory);
    }

    public Action Action(){
        return new Attack(this, Game.getEnemies().stream().findFirst().orElse(null),3);
    }

    public void setItems(ArrayList<Item> items) {
        Items = items;
    }
}
