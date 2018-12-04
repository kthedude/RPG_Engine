package UI;

import Base.Battle;
import Base.Characters.Fighter;
import Base.Characters.Goblin;

public class Main {
    public static void main(String[] args){
        Battle test = new Battle(new Fighter(), new Goblin());
        print("Your health: " + test.getPlayerHealth());
        print("Enemy health: " + test.getEnemyHealth());
        print("You attack");
        test.playerAttack();
        print("Enemy health: " + test.getEnemyHealth());
        print("Enemy attacks");
        test.enemyAttack();
        print("Your health: " + test.getPlayerHealth());
    }

    private static void print(String string){
        System.out.println(string);
    }
}
