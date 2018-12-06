package Base;

public abstract class Character {
    private CharacterStats baseStats;

    public int getHealthPoints(){
        return baseStats.getHealthPoints();
    }

    public int getAttack(){
        return baseStats.getAttack();
    }

    public int getDefense(){
        return baseStats.getDefense();
    }

    public double getAccuracy(){
        return (double)baseStats.getAccuracy() / 100.0;
    }

    public int takeDamage(Character attacker){
        int damage = attacker.getAttack() - this.getDefense();
        if(damage < 1) {
            return 0;
        }else if(damage > this.getHealthPoints()){
            damage = this.getHealthPoints();
            this.baseStats.setHealthPoints(0);
            return damage;
        }else {
            this.baseStats.setHealthPoints(this.baseStats.getHealthPoints() - damage);
            return damage;
        }
    }

    public Character(int healthPoints, int attack, int defense, int accuracy){
        baseStats = new CharacterStats(healthPoints, attack, defense, accuracy);
    }
}
