import java.util.Random;

public class PlayerCharacter extends GameCharacter {
    //region Variables
    private String classType;
    private Equipment weapon = new Equipment();
    private Equipment armor = new Equipment();
    //endregion

    //region Constructors
    public PlayerCharacter(int health_points, int armor_points, int strength_points, int dexterity_points) {
        super(health_points, armor_points, strength_points, dexterity_points);
    }

    public PlayerCharacter(int health_points, int armor_points, int strength_points, int dexterity_points, String imageURL) {
        super(health_points, armor_points, strength_points, dexterity_points, imageURL);
    }

    public PlayerCharacter() {
        super();
    }
    //endregion

    //region Getters&Setters
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
    //endregion

    //region AggregationMethods
    public void equipWeapon(Equipment weapon) {
        this.weapon = weapon;
    }

    public void equipArmor(Equipment armor) {
        this.armor = armor;
    }
    //endregion

    //region CharacterMethods

    /**
     * Gets the attack value.
     *
     * @return The player attack value
     */
    @Override
    public int attack() {
        // I think the total damage should be character attack - enemy defense.
        // Strength is base attack and dexterity modifies the hit rate
        // Points are scaled out of 10
        // Equipment weapon adds bonus attack damage
        return this.strength_points + weapon.getStrength();
    }

    @Override
    public void defend(int damage) {
        int finalDamage = damage - this.armor_points - this.getArmor().getStrength();
        this.health_points -= finalDamage;
    }

    @Override
    public void die() {
    }

    @Override
    public void rollStats() {
        Random random = new Random();

        switch (this.classType) {
            case "Knight":
                health_points = random.nextInt(6, 12);
                armor_points = random.nextInt(6, 12);
                strength_points = random.nextInt(6, 12);
                dexterity_points = random.nextInt(6, 12);
                break;
            case "Wizard":
                health_points = random.nextInt(3, 12);
                armor_points = random.nextInt(2, 12);
                strength_points = random.nextInt(10, 12);
                dexterity_points = random.nextInt(8, 12);
                break;
        }
    }

    //endregion

    //region toString
    @Override
    public String toString() {
        return "class = " + classType + '\n' + "weapon = " + weapon + '\n' + "armor = " + armor + '\n' + "health = " + health_points + '\n' + "armor_points = " + armor_points + '\n' + "strength = " + strength_points + '\n' + "dexterity = " + dexterity_points + '\n' + "imageURL = " + imageURL;
    }
    //endregion
}
