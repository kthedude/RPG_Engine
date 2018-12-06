package Base;

public abstract class Character {
    private int healthPoints, attack, defense, accuracy;

    public int getHealthPoints(){
        return healthPoints;
    }

    public int getAttack(){
        return attack;
    }

    public int getDefense(){
        return defense;
    }

    public double getAccuracy(){
        return (double)accuracy / 100.0;
    }

    public int takeDamage(Character attacker){
        int damage = attacker.attack - this.defense;
        if(damage < 1) {
            return 0;
        }else if(damage > this.healthPoints){
            damage = this.healthPoints;
            this.healthPoints = 0;
            return damage;
        }else {
            healthPoints -= damage;
            return damage;
        }
    }

    public Character(int healthPoints, int attack, int defense, int accuracy){
        this.healthPoints = healthPoints;
        this.defense = defense;
        this.attack = attack;
        this.accuracy = accuracy;
    }
}
