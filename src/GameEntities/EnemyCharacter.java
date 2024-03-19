package GameEntities;

public class EnemyCharacter extends GameCharacter {
    public EnemyCharacter(int health_points, int armor_points, int strength_points, int dexterity_points) {
        super(health_points, armor_points, strength_points, dexterity_points);
    }

    public EnemyCharacter(int health_points, int armor_points, int strength_points, int dexterity_points, String imageURL) {
        super(health_points, armor_points, strength_points, dexterity_points, imageURL);
    }

    public EnemyCharacter() {
        super();
        this.health_points = 10;
        this.armor_points = 10;
        this.strength_points = 10;
        this.dexterity_points = 10;
        this.imageURL = "pictures/enemies/aboleth.jpg";
    }
}
