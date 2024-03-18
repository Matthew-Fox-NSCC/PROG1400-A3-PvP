package guiCode;

import guiElements.BattleScreen;
import guiElements.PlayerArmorySelection;
import guiElements.SplashScreen;

import javax.swing.*;
import java.awt.*;

public class PanelProcessing {
    static JFrame frame = new JFrame("PVP Game");
    static SplashScreen splashPage = new SplashScreen();
    static PlayerArmorySelection armoryPage = new PlayerArmorySelection();
    static BattleScreen battlePage = new BattleScreen();

    //region displayFrame
    public static void displayJFrame() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 600));
        frame.pack();
        frame.setVisible(true);

        addListeners();
        fillElements();
        displayPanelSplash();
    }
    //endregion

    //region displayPanels

    private static void displayPanelSplash() {
        frame.add(splashPage.panel);
        frame.repaint();
        frame.validate();
    }

    private static void displayPanelArmory() {
        frame.remove(splashPage.panel);
        frame.add(armoryPage.panel);
        frame.repaint();
        frame.validate();
    }

    private static void displayPanelBattle() {
        frame.remove(armoryPage.panel);
        frame.add(battlePage.panel);
        frame.repaint();
        frame.validate();

        // TODO move enemy icon to enemy class
//        ImageIcon enemyIcon = new ImageIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("pictures/enemies/aboleth.jpg"))).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
//        battlePage.enemyPicture.setIcon(enemyIcon);

        frame.repaint();
        frame.validate(); // is necessary
    }
    //endregion

    //region elementFilling
    public static void fillElements() {
        fillSplashPanel();
    }

    public static void fillSplashPanel() {
        // TODO Add a description of the game
        splashPage.splashText.setText("PVP GAME");
    }
    //endregion

    //region elementListeners
    public static void addListeners() {
        addSplashListeners();
        addArmoryListeners();
        addBattleListeners();
    }

    private static void addSplashListeners() {
        splashPage.OKButton.addActionListener(e -> displayPanelArmory());
    }

    private static void addArmoryListeners() {
        armoryPage.OKButton.addActionListener(e -> displayPanelBattle());
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
