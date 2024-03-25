import java.util.Random;

public class EnemyCharacter extends GameCharacter {
    //region Constructors
    public EnemyCharacter(int health_points, int armor_points, int strength_points, int dexterity_points) {
        super(health_points, armor_points, strength_points, dexterity_points);
    }

    public EnemyCharacter(int health_points, int armor_points, int strength_points, int dexterity_points, String imageURL) {
        super(health_points, armor_points, strength_points, dexterity_points, imageURL);
    }

    public EnemyCharacter() {
        super();
        rollStats();
        this.imageURL = "pictures/enemies/aboleth.jpg";
    }
    //endregion

    //region CharacterMethods
    /**
     * Gets the attack value.
     * @return The enemy attack value
     */
    @Override
    public int attack() {
        // I think the total damage should be character attack - enemy defense.
        // Strength is base attack and dexterity modifies the hit rate
        // Points are scaled out of 10
        // Equipment weapon adds bonus attack damage
        return this.strength_points;
    }

    @Override
    public void defend(int damage) {
        int finalDamage = damage - this.armor_points;
        this.health_points -= finalDamage;
    }

    @Override
    public void die() {
    }

    @Override
    public void rollStats() {
        Random random = new Random();

        health_points = random.nextInt(60, 100);
        armor_points = random.nextInt(20, 35);
        strength_points = random.nextInt(15, 40);
        dexterity_points = random.nextInt(18, 32);
    }
    //endregion
}
