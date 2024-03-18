import guiCode.PanelProcessing;

import javax.swing.*;

public class Game {

    public void Play() {
// schedule this for the event dispatch thread (edt)
        SwingUtilities.invokeLater(PanelProcessing::displayJFrame); // end inner class The semicolon after means that it is a class.
    } // end main

    public void battle() {
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
