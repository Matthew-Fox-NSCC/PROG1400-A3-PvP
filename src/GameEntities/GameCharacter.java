package GameEntities;

public abstract class GameCharacter {

    private int health_points;
    private int armor_points;
    private int strength_points;
    private int dexterity_points;
    private String imageURL;

    public GameCharacter(int health_points, int armor_points, int strength_points, int dexterity_points) {
        this.health_points = health_points;
        this.armor_points = armor_points;
        this.strength_points = strength_points;
        this.dexterity_points = dexterity_points;
    }

    public GameCharacter(int health_points, int armor_points, int strength_points, int dexterity_points, String imageURL) {
        this.health_points = health_points;
        this.armor_points = armor_points;
        this.strength_points = strength_points;
        this.dexterity_points = dexterity_points;
        this.imageURL = imageURL;
    }

    public void attack() {
    }

    public void defend() {
    }

    public void die() {
    }
}
