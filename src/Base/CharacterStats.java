package Base;

public class CharacterStats {
    private int healthPoints, attack, defense, accuracy;

    public CharacterStats(){
        healthPoints = 1;
        attack = 1;
        defense = 1;
        accuracy = 50;
    }
    public CharacterStats(CharacterStats other){
        this.healthPoints = other.healthPoints;
        this.attack = other.attack;
        this.defense = other.defense;
        this.accuracy = other.accuracy;
    }
    public CharacterStats(int healthPoints, int attack, int defense, int accuracy){
        this.healthPoints = healthPoints;
        this.attack = attack;
        this.defense = defense;
        this.accuracy = accuracy;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }
}
