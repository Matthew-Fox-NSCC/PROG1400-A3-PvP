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

    //region Getters
    public String getClassType() {
        return classType;
    }

    public Equipment getWeapon() {
        return weapon;
    }

    public Equipment getArmor() {
        return armor;
    }
    //endregion

    //region Setters
    public void setClassType(String classType) {
        this.classType = classType;
    }

    public void setWeapon(Equipment weapon) {
        this.weapon = weapon;
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
     * @return The player attack value
     */
    @Override
    public int attack() {
        // I think the total damage should be character attack - enemy defense.
        // Strength is base attack and dexterity modifies the hit rate
        // Points are scaled out of 10
        // Equipment weapon adds bonus attack damage
        return this.strength_points + weapon.calc();
    }

    @Override
    public void defend(int damage) {
        int finalDamage = damage  - this.armor_points - this.getArmor().calc();
        this.health_points -= finalDamage;
    }

    @Override
    public void die() {
    }
    //endregion

    //region toString
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
    //endregion
}
