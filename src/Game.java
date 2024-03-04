public class Game {
    public void Play() {
        double secondsToSleep = 2.0;
        boolean done = false;
        while (!done) {
            done = update();
            try {
                Thread.sleep((int) (secondsToSleep * 1000));
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean update() {
        return false;
    }
}
