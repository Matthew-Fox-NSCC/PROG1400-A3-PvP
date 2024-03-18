import guiCode.PanelProcessing;

import javax.swing.*;

public class Game {

    public void Play() {
        SwingUtilities.invokeLater(PanelProcessing::displayJFrame);

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

    public void battle() {
    }

    public boolean update() {
        return false;
    }
}
