package com.kawasaki.printedadventure.Character;

import com.kawasaki.printedadventure.action.Action;
import com.kawasaki.printedadventure.item.Item;

import java.util.ArrayList;

abstract public class GameEntity {

    public GameEntity(String name, int health, ArrayList<Item> inventory){
        this.health = health;
        this.Items = inventory;
        this.setName(name);
    }

    private int health;

    private String Name;

    protected ArrayList<Item> Items;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public abstract Action Action();
}
