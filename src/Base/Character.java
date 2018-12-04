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

    public void takeDamage(Character attacker){
        if(attacker.attack < this.defense)
            return;
        healthPoints -= (attacker.attack - this.defense);
        return;
    }

    public Character(int healthPoints, int attack, int defense, int accuracy){
        this.healthPoints = healthPoints;
        this.defense = defense;
        this.attack = attack;
        this.accuracy = accuracy;
    }
}
