package View;

import Model.Battle;
import Model.Characters.Fighter;
import Model.Characters.Goblin;

import java.util.Random;
import java.util.Scanner;

public class Terminal_UI extends View {
    Battle testBattle;
    Scanner scanner;
    static final double RUN_CHANCE = 0.75;
    Random random;

    public Terminal_UI(){
        testBattle = new Battle(new Fighter(), new Goblin());
        scanner = new Scanner(System.in);
        random = new Random();
    }

    public void start(){
        println("You encountered a Goblin!");
        println("What do you want to do?");
        Choice choice = getBattleChoice();
        if(choice == Choice.ATTACK){
            println("You attack the Goblin!");
            startBattle();
        }else{
            println("You ran away!");
            return;
        }
    }

    private void println(String s){
        System.out.println(s);
    }

    private void print(String s){
        System.out.print(s);
    }

    private enum Choice {
        ATTACK, RUN, NOTHING
    }

    private Choice getBattleChoice(){
        println("A. Attack");
        println("B. Run");
        print("Enter the letter of your choice: ");
        String input = scanner.nextLine();
        input = input.toUpperCase();
        if(input.charAt(0) == 'A'){
            return Choice.ATTACK;
        }else if(input.charAt(0) == 'B'){
            return Choice.RUN;
        }else{
            println("Incorrect input. Try again.");
            return getBattleChoice();
        }
    }

    private Choice getActionChoice(){
        println("What do you do?");
        println("A. Attack");
        println("B. Run");
        println("C. Do Nothing");
        print("Enter the letter of your choice: ");
        String input = scanner.nextLine();
        input = input.toUpperCase();
        char choice = input.charAt(0);
        switch (choice) {
            case 'A':   return Choice.ATTACK;
            case 'B':   return Choice.RUN;
            case 'C':   return Choice.NOTHING;
            default:    println("Invalid input. Try again.");
                        return getBattleChoice();
        }
    }



    private void startBattle(){
        Choice choice = getActionChoice();
        while(continueBattle()){
            handlePlayerChoice(choice);
            handleEnemy();
            choice = getActionChoice();
        }
    }

    private void handlePlayerChoice(Choice choice){
        if(choice == Choice.ATTACK){
            println("Enemy HP: " + testBattle.getEnemyHealth());
            println("You attack!");
            println("You did " + testBattle.playerAttack() + " damage");
            println("Enemy HP: " + testBattle.getEnemyHealth());
        }else if(choice == Choice.RUN){
            println("You tried to run away!");
            if(random.nextDouble() < RUN_CHANCE){
                //println();
            }
        }
    }

    private void handleEnemy(){
        println("The Goblin attacked you!");
        println("Your health: " + testBattle.getPlayerHealth());
        println("It did " + testBattle.enemyAttack() + " damage");
        println("Your health: " + testBattle.getPlayerHealth());
    }

    private boolean continueBattle(){
        if(testBattle.getPlayerHealth() < 1){
            println("You died!");
            return false;
        }else if(testBattle.getEnemyHealth() < 1){
            println("Enemy died!");
            return false;
        }else{
            return true;
        }
    }
}
