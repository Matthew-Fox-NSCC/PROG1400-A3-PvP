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

    public int getHealth_points() {
        return health_points;
    }

    public void setHealth_points(int health_points) {
        this.health_points = health_points;
    }

    public int getArmor_points() {
        return armor_points;
    }

    public void setArmor_points(int armor_points) {
        this.armor_points = armor_points;
    }

    public int getStrength_points() {
        return strength_points;
    }

    public void setStrength_points(int strength_points) {
        this.strength_points = strength_points;
    }

    public int getDexterity_points() {
        return dexterity_points;
    }

    public void setDexterity_points(int dexterity_points) {
        this.dexterity_points = dexterity_points;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void attack() {
    }

    public void defend() {
    }

    public void die() {
    }
}
