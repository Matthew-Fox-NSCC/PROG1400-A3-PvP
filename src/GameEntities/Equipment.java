package GameEntities;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import java.util.Random;

public class Equipment {
    private int minimum;
    private int maximum;
    private String name;
    private String imageURL;

    public Equipment(String name, int minimum, int maximum) {
        this.name = name;
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public Equipment(String name, int minimum, int maximum, String imageURL) {
        this.name = name;
        this.minimum = minimum;
        this.maximum = maximum;
        this.imageURL = imageURL;
    }

    public ImageIcon getImageIcon() {
        return new ImageIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource(imageURL))).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
    }

    public ImageIcon getImageIcon(int width, int height) {
        return new ImageIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource(imageURL))).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    public int calc() {
        Random random = new Random();
        return random.nextInt(minimum, maximum);
    }
}
