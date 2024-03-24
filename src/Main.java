import java.awt.*;

/**
 * The main class of the PvP game.
 */
public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new Application();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
    }
}
