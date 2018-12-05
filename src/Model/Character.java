package Model;

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
        if(attacker.attack < this.defense)
            return 0;
        healthPoints -= (attacker.attack - this.defense);
        return attacker.attack - this.defense;
    }

    public Character(int healthPoints, int attack, int defense, int accuracy){
        this.healthPoints = healthPoints;
        this.defense = defense;
        this.attack = attack;
        this.accuracy = accuracy;
    }
}
