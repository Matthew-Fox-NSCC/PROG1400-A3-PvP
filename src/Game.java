import GameEntities.ActiveEntities;
import GameEntities.EnemyCharacter;
import GameEntities.PlayerCharacter;

import javax.swing.*;

import static guiCode.PanelProcessing.battlePage;
import static guiCode.PanelProcessing.displayJFrame;

public class Game {

    public PlayerCharacter player = ActiveEntities.player;
    public EnemyCharacter enemy = ActiveEntities.enemy;

    public void Play() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                displayJFrame();
            }
        });
        update();
    }

    public void battle() {
//        double secondsToSleep = 2.0;
//        boolean done = false;
//        while (!done) {
//            done = update();
//            try {
//                Thread.sleep((int) (secondsToSleep * 1000));
//            } catch (InterruptedException e) {
//                System.out.println(e.getMessage());
//            }
//        }
    }

    public void update() {
        double secondsToSleep = 0.5;
        boolean done = false;
        while (true) {
            try {
                Thread.sleep((int) (secondsToSleep * 1000));
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
//            System.out.println(player.toString());
            battlePage.enemyPicture.setIcon(enemy.getImageIcon());
            battlePage.playerPicture.setIcon(player.getImageIcon());
        }
    }
}

