package GameEntities;

public class PlayerCharacter extends GameCharacter {
    private String classType;
    private Equipment weapon;
    private Equipment armor;

    public PlayerCharacter(int health_points, int armor_points, int strength_points, int dexterity_points) {
        super(health_points, armor_points, strength_points, dexterity_points);
    }

    public PlayerCharacter(int health_points, int armor_points, int strength_points, int dexterity_points, String imageURL) {
        super(health_points, armor_points, strength_points, dexterity_points, imageURL);
    }

    public PlayerCharacter() {
        super();
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
        return "PlayerCharacter{" +
                "classType='" + classType + '\'' +
                ", weapon=" + weapon +
                ", armor=" + armor +
                ", health_points=" + health_points +
                ", armor_points=" + armor_points +
                ", strength_points=" + strength_points +
                ", dexterity_points=" + dexterity_points +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
