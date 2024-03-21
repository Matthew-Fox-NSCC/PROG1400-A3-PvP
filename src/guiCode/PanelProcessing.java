package guiCode;

import GameEntities.ActiveEntities;
import GameEntities.EnemyCharacter;
import GameEntities.PlayerCharacter;
import guiElements.BattleScreen;
import guiElements.PlayerArmorySelection;
import guiElements.SplashScreen;

import javax.swing.*;
import java.awt.*;

public class PanelProcessing {
    public static BattleScreen battlePage = new BattleScreen();
    static JFrame frame = new JFrame("PVP Game");
    static SplashScreen splashPage = new SplashScreen();
    static PlayerArmorySelection armoryPage = new PlayerArmorySelection();
    static PlayerCharacter player = ActiveEntities.player;
    static EnemyCharacter enemy = ActiveEntities.enemy;


    //region displayFrame
    public static void displayJFrame() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1000, 800));
        frame.setMinimumSize(new Dimension(800, 600));
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
//        ImageIcon enemyIcon = new ImageIcon(new javax.swing.ImageIcon("pictures/enemies/aboleth.jpg").getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
//        battlePage.enemyPicture.setIcon(enemyIcon);

//        enemy.setImageURL("pictures/enemies/aboleth.png");
//        battlePage.enemyPicture.setIcon(enemy.getImageIcon());

//        battlePage.enemyPicture.setIcon(new ImageIcon(PanelProcessing.class.getResource("pictures/enemies/aboleth.jpg")));
//        battlePage.enemyPicture.setIcon(new ImageIcon(PanelProcessing.class.getResource("pictures/enemies/aboleth.png")));

//        ImageIcon x = new ImageIcon(PanelProcessing.class.getResource("images2/axe.png"));

        frame.repaint();
        frame.validate();
    }
    //endregion

    //region elementFilling
    public static void fillElements() {
        fillSplashPanel();
        fillArmoryPanel();
        fillBattlePanel();
    }

    public static void fillSplashPanel() {
        // TODO Add a description of the game
        splashPage.splashText.setText("PVP GAME");
    }

    public static void fillArmoryPanel() {
        armoryPage.playerInformation.setLineWrap(true);
        armoryPage.playerInformation.setText(player.toString());
    }

    public static void fillBattlePanel() {
//        battlePage.playerPicture.setIcon(player.getImageIcon());
//        enemy.setImageURL("I:\\FoxCloud\\Life\\NSCCProgramming\\PROG-1400\\Assignments\\Assignment3\\PROG1400-A3-PvP\\src\\pictures\\enemies\\aboleth.png");
//        battlePage.enemyPicture.setIcon(enemy.getImageIcon());
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
        armoryPage.OKButton.addActionListener(e -> {
            displayPanelBattle();
            fillBattlePanel();
        });

        armoryPage.classSelectionList.getSelectionModel().addListSelectionListener(e -> {
            player.setClassType(armoryPage.classSelectionList.getSelectedValue().toString());
            switch (player.getClassType()) {
                case "Wizard":
                    player.setImageURL("pictures/players/wizard.png");
                    break;
                case "Knight":
                    player.setImageURL("pictures/players/knight.jpg");
                    break;
            }
            fillArmoryPanel();
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
