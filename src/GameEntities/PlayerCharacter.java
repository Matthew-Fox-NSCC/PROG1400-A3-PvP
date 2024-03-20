package GameEntities;

public class PlayerCharacter extends GameCharacter {
    private String classType;
    private Equipment weapon = new Equipment();
    private Equipment armor = new Equipment();

    public PlayerCharacter(int health_points, int armor_points, int strength_points, int dexterity_points) {
        super(health_points, armor_points, strength_points, dexterity_points);
    }

    public PlayerCharacter(int health_points, int armor_points, int strength_points, int dexterity_points, String imageURL) {
        super(health_points, armor_points, strength_points, dexterity_points, imageURL);
    }

    public PlayerCharacter() {
        super();
    }

    /**
     * Gets the attack value.
     * @param enemy The enemy to attack
     * @return The player attack value
     */
    public int attack(EnemyCharacter enemy) {
        // I think the total damage should be character attack - enemy defense.
        // Strength is base attack and dexterity modifies the hit rate
        // Points are scaled out of 10
        // Equipment weapon adds bonus attack damage
        return this.strength_points + weapon.calc() - enemy.armor_points;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public Equipment getWeapon() {
        return weapon;
    }

    public void setWeapon(Equipment weapon) {
        this.weapon = weapon;
    }

    public Equipment getArmor() {
        return armor;
    }

    public void setArmor(Equipment armor) {
        this.armor = armor;
    }

    public void equipWeapon(Equipment weapon) {
        this.weapon = weapon;
    }

    public void equipArmor(Equipment armor) {
        this.armor = armor;
    }

    @Override
    public String toString() {
        return "class = " + classType + '\n' +
                "weapon = " + weapon + '\n' +
                "armor = " + armor + '\n' +
                "health = " + health_points + '\n' +
                "armor_points = " + armor_points + '\n' +
                "strength = " + strength_points + '\n' +
                "dexterity = " + dexterity_points + '\n' +
                "imageURL = " + imageURL;
    }
}
