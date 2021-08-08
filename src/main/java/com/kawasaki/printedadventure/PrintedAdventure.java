package com.kawasaki.printedadventure;

import com.kawasaki.printedadventure.Character.Enemy;
import com.kawasaki.printedadventure.Character.GameEntity;
import com.kawasaki.printedadventure.Character.Player;
import com.kawasaki.printedadventure.game.Game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PrintedAdventure {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Printed Adventure!");

        System.out.println("Enter your player's name:");
        Scanner reader = new Scanner(System.in);
        String name = reader.nextLine();



        ArrayList<GameEntity> characters = new ArrayList<GameEntity>();
        characters.add(GeneratePlayer(name));
        characters.add(GenerateEnemy());
        Game.initGame(characters);

        System.out.println("\n Battle Start! \n");

        while (Game.getDeadCharacters().size() == 0){
            Game.printStatus();

            if (Game.isPlayerRound()){
                var roundAction = Game.getPlayers().stream().findFirst().orElse(null).Action();
                Game.Run(roundAction);
            }  else {
                var roundAction = Game.getEnemies().stream().findFirst().orElse(null).Action();
                Game.Run(roundAction);
            }
        }

        Game.removeDeadCharacters();

        if (Game.getEnemies().size() == 0){
            System.out.println( "\n All enemy defeated, Player wins!");
        } else {
            System.out.println( "\n Player dead, game over.");
        }
    }


    public static Player GeneratePlayer(String name){
        var newPlayer = new Player(name,20,null);
        return newPlayer;
    }

    public static Enemy GenerateEnemy(){
        var newEnemy = new Enemy("Enemy1",10,null);
        return newEnemy;
    }
}

