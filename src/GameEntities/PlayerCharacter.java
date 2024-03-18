package GameEntities;

public class PlayerCharacter extends GameCharacter {
    public String classType;
    private Equipment weapon;
    private Equipment armor;

    public PlayerCharacter(int health_points, int armor_points, int strength_points, int dexterity_points) {
        super(health_points, armor_points, strength_points, dexterity_points);
    }

    public PlayerCharacter(int health_points, int armor_points, int strength_points, int dexterity_points, String imageURL) {
        super(health_points, armor_points, strength_points, dexterity_points, imageURL);
    }

    public void equipWeapon(Equipment weapon) {
        this.weapon = weapon;
    }

    public void equipArmor(Equipment armor) {
        this.armor = armor;
    }
}
