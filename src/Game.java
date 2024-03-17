import guiElements.BattleScreen2;
import guiElements.PlayerArmorySelection2;
import guiElements.SplashScreen2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    static JFrame frame = new JFrame("PVP Game"); // You can leave it here or not.
    static SplashScreen2 splashPage = new SplashScreen2(); // Represents each the container
    static PlayerArmorySelection2 armoryPage = new PlayerArmorySelection2();
    static BattleScreen2 battlePage = new BattleScreen2();

    static void displayPanelSplash()//one for each page
    {
        frame.add(splashPage.panel);
        frame.repaint();
        frame.validate(); // is necessary
    }

    static void displayPanelArmory()//one for each page
    {
        frame.remove(splashPage.panel); // Takes away the previous panel.
        frame.add(armoryPage.panel);
        frame.repaint();
        frame.validate(); // is necessary
    }

    static void displayPanelBattle()//one for each page
    {
        frame.remove(armoryPage.panel); // Takes away the previous panel.
        frame.add(battlePage.panel);
        frame.repaint();
        frame.validate(); // is necessary
    }

    public void addListeners() {
        addSplashListeners();
        addArmoryListeners();
        addBattleListeners();
    }

    public void addSplashListeners() {
        splashPage.OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayPanelArmory();
            }
        });
    }

    public void addArmoryListeners() {
        armoryPage.OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayPanelBattle();
            }
        });
    }

    public void addBattleListeners() {
//        splashPage.OKButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                displayPanelArmory();
//            }
//        });
    }

    static void displayJFrame() { // method that it is gonna be called
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 600));
        frame.pack();
        frame.setVisible(true);
        displayPanelSplash();
    }

    public void Play() {
// schedule this for the event dispatch thread (edt)
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                displayJFrame();
                addListeners();
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
