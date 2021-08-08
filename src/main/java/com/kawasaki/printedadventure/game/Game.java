package com.kawasaki.printedadventure.game;

import com.kawasaki.printedadventure.Character.Enemy;
import com.kawasaki.printedadventure.Character.GameEntity;
import com.kawasaki.printedadventure.Character.Player;
import com.kawasaki.printedadventure.action.Action;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Game {
    private static ArrayList<GameEntity> gameCharacters;

    private static boolean PlayerRound = true;

    public static void Run(Action action){
        var oldState = gameCharacters.stream()
                .filter(c -> c.getName() == action.getTargetEntity().getName())
                .findFirst()
                .orElse(null);
        var newState = action.Execute(oldState);
        gameCharacters.set(gameCharacters.indexOf(oldState),newState);
        PlayerRound = !PlayerRound;
    }

    public static void initGame(ArrayList<GameEntity> characters){
        System.out.println("\n Starting game");
        gameCharacters = characters;
        gameCharacters.forEach(c -> System.out.println(c.getName() + " joined the game!"));
    }

    public static ArrayList<GameEntity> getPlayers(){
        var players = gameCharacters.stream().filter(c -> c instanceof Player).collect(Collectors.toList());
        return (ArrayList<GameEntity>) players;
    }

    public static ArrayList<GameEntity> getEnemies(){
        var players = gameCharacters.stream().filter(c -> c instanceof Enemy).collect(Collectors.toList());
        return (ArrayList<GameEntity>) players;
    }

    public static ArrayList<GameEntity> getDeadCharacters(){
        var dead = gameCharacters.stream().filter(c -> c.getHealth() <= 0).collect(Collectors.toList());
        return (ArrayList<GameEntity>) dead;
    }

    public static void removeDeadCharacters() {
        var dead = gameCharacters.stream().filter(c -> c.getHealth() <= 0).collect(Collectors.toList());
        if (dead.size() > 0){
            dead.forEach(d -> gameCharacters.remove(d));
        }
    }

    public static boolean isPlayerRound() {
        return PlayerRound;
    }

    public static void printStatus(){
        System.out.print("Players on the field:");
        getPlayers().forEach(c -> System.out.print("[ "+ c.getName()+", HP:"+c.getHealth()+" ] "));
        System.out.print("Enemies on the field:");
        getEnemies().forEach(c -> System.out.println("[ "+ c.getName()+", HP:"+c.getHealth()+" ]"));
    }
}
