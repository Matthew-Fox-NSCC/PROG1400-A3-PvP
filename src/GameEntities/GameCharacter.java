package GameEntities;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public abstract class GameCharacter {

    protected int health_points;
    protected int armor_points;
    protected int strength_points;
    protected int dexterity_points;
    protected String imageURL;

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

    public GameCharacter() {}

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

    public ImageIcon getImageIcon() {
        return new ImageIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource(imageURL))).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
    }

    public ImageIcon getImageIcon(int width, int height) {
        return new ImageIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource(imageURL))).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    public void attack() {
    }

    public void defend() {
    }

    public void die() {
    }

    @Override
    public String toString() {
        return "GameCharacter{" +
                "health_points=" + health_points +
                ", armor_points=" + armor_points +
                ", strength_points=" + strength_points +
                ", dexterity_points=" + dexterity_points +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
