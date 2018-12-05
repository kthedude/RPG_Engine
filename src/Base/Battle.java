package Base;

import java.util.Random;

public class Battle {

    Character player, enemy;

    Random random = new Random();

    private void attack(Character attacker, Character defender){
        if(random.nextDouble() < attacker.getAccuracy()){
            defender.takeDamage(attacker);
        }
    }

    public void playerAttack(){
        this.attack(player, enemy);
    }

    public void enemyAttack(){
        this.attack(enemy, player);
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
