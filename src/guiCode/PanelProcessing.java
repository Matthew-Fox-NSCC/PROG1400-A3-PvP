package guiCode;

import GameEntities.EnemyCharacter;
import GameEntities.PlayerCharacter;
import guiElements.BattleScreen;
import guiElements.PlayerArmorySelection;
import guiElements.SplashScreen;
import GameEntities.ActiveEntities;
import javax.swing.*;
import java.awt.*;

public class PanelProcessing {
    static JFrame frame = new JFrame("PVP Game");
    static SplashScreen splashPage = new SplashScreen();
    static PlayerArmorySelection armoryPage = new PlayerArmorySelection();
    static BattleScreen battlePage = new BattleScreen();

    static PlayerCharacter player = ActiveEntities.player;
    public EnemyCharacter enemy = ActiveEntities.enemy;

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

    public static void fillArmoryPanel() {
        armoryPage.playerInformation.setLineWrap(true);
        armoryPage.playerInformation.setText(player.toString());
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

        armoryPage.classSelectionList.getSelectionModel().addListSelectionListener(e -> {
            player.setClassType(armoryPage.classSelectionList.getSelectedValue().toString());
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
