package Model;

import java.util.Random;

public class Battle extends Model{

    Character player, enemy;

    Random random = new Random();

    private int attack(Character attacker, Character defender){
        if(random.nextDouble() < attacker.getAccuracy()){
            return defender.takeDamage(attacker);
        }else{ //Missed
            return 0;
        }
    }

    public int playerAttack(){
        return this.attack(player, enemy);
    }

    public int enemyAttack(){
        return this.attack(enemy, player);
    }

    public Battle(Character player, Character enemy){
        this.player = player;
        this.enemy = enemy;
    }

    public int getPlayerHealth(){
        return player.getHealthPoints();
    }

    public int getEnemyHealth(){
        return enemy.getHealthPoints();
    }
}
