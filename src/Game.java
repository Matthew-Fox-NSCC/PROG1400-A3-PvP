import GameEntities.ActiveEntities;
import GameEntities.EnemyCharacter;
import GameEntities.PlayerCharacter;
import guiCode.PanelProcessing;

import javax.swing.*;

public class Game {

    public PlayerCharacter player = ActiveEntities.player;
    public EnemyCharacter enemy = ActiveEntities.enemy;

    public void Play() {
        SwingUtilities.invokeLater(PanelProcessing::displayJFrame);
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

    public boolean update() {
        return false;
    }
}

