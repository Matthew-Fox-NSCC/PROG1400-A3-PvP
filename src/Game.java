import guiCode.PanelProcessing;
import guiElements.BattleScreen;
import guiElements.PlayerArmorySelection;
import guiElements.SplashScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Game {

    public void Play() {
// schedule this for the event dispatch thread (edt)
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                PanelProcessing.displayJFrame();
            }
        }); // end inner class The semicolon after means that it is a class.
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
