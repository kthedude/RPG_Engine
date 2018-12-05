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
        Choice choice = getChoice();
        if(choice == Choice.ATTACK){
            println("You attack the Goblin!");
            
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
        ATTACK, RUN
    }

    private Choice getChoice(){
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
            return getChoice();
        }
    }
}
