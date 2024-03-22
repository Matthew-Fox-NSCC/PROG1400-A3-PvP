import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    WeaponsApp window = new WeaponsApp();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });
    }
}
