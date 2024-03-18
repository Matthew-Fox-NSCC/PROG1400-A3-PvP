package GameEntities;

import java.util.Random;

public class Equipment {
    private int minimum;
    private int maximum;
    private String name;

    public Equipment(String name, int minimum, int maximum) {
        this.name = name;
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public int calc() {
        Random random = new Random();
        return random.nextInt(minimum, maximum);
    }
}
