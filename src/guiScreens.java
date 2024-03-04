import guiElements.BattleScreen;
import guiElements.PlayerArmorySelection;
import guiElements.SplashScreen;

import javax.swing.*;

public class guiScreens {
        public void SplashScreenFrame() {
            SplashScreen frame = new SplashScreen();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.setSize(600, 600);
        }

        public void PlayerScreenFrame() {
            PlayerArmorySelection frame = new PlayerArmorySelection();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.setSize(600, 600);
        }

        public void BattleScreenFrame() {
            BattleScreen frame = new BattleScreen();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.setSize(600, 600);
        }
}
