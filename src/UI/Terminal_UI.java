package UI;

import Base.Battle;
import Base.Characters.Fighter;
import Base.Characters.Goblin;

import java.util.Scanner;

public class Terminal_UI {
    Battle testBattle;
    Scanner scanner;

    public Terminal_UI(){
        testBattle = new Battle(new Fighter(), new Goblin());
        scanner = new Scanner(System.in);
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
        println("");
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
            default :   println("Invalid input. Try again.");
                        return getBattleChoice();
        }
    }

    private void startBattle(){
        while(true){
            reportPlayerStats();
            reportEnemyStats();
            Choice action = getActionChoice();
            if(action == Choice.RUN) {
                println("You ran away!");
                return;
            }else if(action == Choice.ATTACK){
                int damage = testBattle.playerAttack();
                println("You did " + damage + " damage");
            }else if(action == Choice.NOTHING){
                println("You did nothing");
            }
            if(!continueBattle()){
                return;
            }
            println("The goblin attacked!");
            int damage = testBattle.enemyAttack();
            println("The goblin did " + damage + " damage");
            if(!continueBattle()){
                return;
            }
        }
    }

    private boolean continueBattle(){
        if(testBattle.getEnemyHealth() < 1){
            println("You killed the goblin!");
            return false;
        }else if(testBattle.getPlayerHealth() < 1){
            println("You died");
            return false;
        }else{
            return true;
        }
    }

    private void reportPlayerStats(){
        println("-----------------------------------------");
        println("Player Stats");
        println("HP: " + testBattle.getPlayerHealth());
        println(("Attack: " + testBattle.getPlayerAttack()));
        println("Defense: " + testBattle.getPlayerDefense());
        println("-----------------------------------------");
    }

    private void reportEnemyStats(){
        println("-----------------------------------------");
        println("Enemy Stats");
        println("HP: " + testBattle.getEnemyHealth());
        println("-----------------------------------------");
    }
}
