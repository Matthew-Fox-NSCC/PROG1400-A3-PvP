package guiCode;

import guiElements.BattleScreen;
import guiElements.PlayerArmorySelection;
import guiElements.SplashScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelProcessing {
    static JFrame frame = new JFrame("PVP Game"); // You can leave it here or not.
    static SplashScreen splashPage = new SplashScreen(); // Represents each the container
    static PlayerArmorySelection armoryPage = new PlayerArmorySelection();
    static BattleScreen battlePage = new BattleScreen();

    //region displayFrame
    public static void displayJFrame() { // method that it is gonna be called
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 600));
        frame.pack();
        frame.setVisible(true);
        addListeners();
        displayPanelSplash();
    }
    //endregion

    //region displayPanels

    private static void displayPanelSplash()//one for each page
    {
        frame.add(splashPage.panel);
        frame.repaint();
        frame.validate(); // is necessary
    }

    private static void displayPanelArmory()//one for each page
    {
        frame.remove(splashPage.panel); // Takes away the previous panel.
        frame.add(armoryPage.panel);
        frame.repaint();
        frame.validate(); // is necessary
    }

    private static void displayPanelBattle()//one for each page
    {
        frame.remove(armoryPage.panel); // Takes away the previous panel.
        frame.add(battlePage.panel);
        frame.repaint();
        frame.validate(); // is necessary

        // TODO move enemy icon to enemy class
//        ImageIcon enemyIcon = new ImageIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("pictures/enemies/aboleth.jpg"))).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
//        battlePage.enemyPicture.setIcon(enemyIcon);

        frame.repaint();
        frame.validate(); // is necessary
    }
    //endregion

    //region elementListeners
    public static void addListeners() {
        addSplashListeners();
        addArmoryListeners();
        addBattleListeners();
    }

    private static void addSplashListeners() {
        splashPage.OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayPanelArmory();
            }
        });
    }

    private static void addArmoryListeners() {
        armoryPage.OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayPanelBattle();
            }
        });
    }

    private static void addBattleListeners() {
//        splashPage.OKButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                displayPanelArmory();
//            }
//        });
    }
    //endregion
}
