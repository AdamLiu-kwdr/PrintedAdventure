package com.kawasaki.printedadventure.item;

import com.kawasaki.printedadventure.action.Action;

abstract public class Item {
    abstract public Action Use(Character target);
    abstract public String getName();
}
