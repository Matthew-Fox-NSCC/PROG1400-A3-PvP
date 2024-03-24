import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import java.util.Random;

public class Equipment {
    //region Variables
    private int minimum;
    private int maximum;
    private int strength;
    private String name;
    private String imageURL;
    //endregion

    //region Constructors
    public Equipment(String name, int minimum, int maximum) {
        this.name = name;
        this.minimum = minimum;
        this.maximum = maximum;
        this.strength = this.calc();
    }

    public Equipment(String name, int minimum, int maximum, String imageURL) {
        this.name = name;
        this.minimum = minimum;
        this.maximum = maximum;
        this.imageURL = imageURL;
        this.strength = this.calc();
    }

    public Equipment() {}
    //endregion

    //region Getters
    public int getMinimum() {
        return minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public int getStrength() {
        return strength;
    }

    public String getName() {
        return name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public ImageIcon getImageIcon() {
        return new ImageIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource(imageURL))).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
    }

    public ImageIcon getImageIcon(int width, int height) {
        return new ImageIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource(imageURL))).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }
    //endregion

    //region Setters
    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
    //endregion

    //region GameMethods
    private int calc() {
        Random random = new Random();
        return random.nextInt(minimum, maximum);
    }
    //endregion

    //region toString
    @Override
    public String toString() {
        return "Equipment{" +
                "name='" + name + '\'' +
                '}';
    }
    //endregion
}
