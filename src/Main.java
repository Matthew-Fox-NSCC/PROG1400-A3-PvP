import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Application app = new Application();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });
    }
}
