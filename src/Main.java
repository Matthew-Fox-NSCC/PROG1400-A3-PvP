public class Main {
    public static void main(String[] args) {
        try {
            Game game = new Game();
            game.Play();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
