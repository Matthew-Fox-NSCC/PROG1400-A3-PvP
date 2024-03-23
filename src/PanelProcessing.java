import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class PanelProcessing {
    //region Variables
    protected final int DEFAULT_WIDTH = 500;
    protected final int DEFAULT_HEIGHT = 500;
    protected JFrame frame = new JFrame("Player VS Player App");
    protected SplashScreen splashScreen = new SplashScreen();
    protected ArmoryScreen armoryScreen = new ArmoryScreen();
    protected BattleScreen battleScreen = new BattleScreen();
    protected ImageIcon[] weaponsArray = new ImageIcon[2];
    //endregion

    //region PanelStart
    public PanelProcessing() {
        initialize();
    }

    private void initialize() {
        frame.setBounds(800, 250, 800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new CardLayout(0, 0));
        loadSplash();
    }
    //endregion

    //region PanelLoading
    public void loadSplash() {
        frame.add(splashScreen.panel);
        addSplashListeners();
//        splashScreen.setLayout(new BorderLayout());
//        splashScreen.setName("Splash");
//        fillSplash();
    }

    public void addSplashListeners() {
        splashScreen.OKButton.addActionListener(e -> loadArmory());
    }

    public void loadArmory() {
        frame.remove(splashScreen.panel);
        frame.add(armoryScreen.panel);
        addArmoryListeners();
        frame.repaint();
        frame.validate();

//        armoryScreen.setLayout(new BorderLayout());
//        armoryScreen.setName("Armory");

//        fillArmory();
    }

    public void addArmoryListeners() {
        armoryScreen.OKButton.addActionListener(e -> loadBattle());
    }

    public void fillArmoryElements() {
        weaponsArray[0] = new ImageIcon(new ImageIcon(Objects.requireNonNull(PanelProcessing.class.getResource("/images/axe.png"))).getImage().getScaledInstance(DEFAULT_WIDTH, DEFAULT_HEIGHT, Image.SCALE_SMOOTH));
        weaponsArray[1] = new ImageIcon(new ImageIcon(Objects.requireNonNull(PanelProcessing.class.getResource("/images/sword.png"))).getImage().getScaledInstance(DEFAULT_WIDTH, DEFAULT_HEIGHT, Image.SCALE_SMOOTH));

        armoryScreen.weaponPicture.setIcon(weaponsArray[0]);

//        JLabel weaponImage = new JLabel((String) null);
//        weaponImage.setIcon(weaponsArray[0]);

//        armoryScreen.weaponImagePanel.setLayout(new FlowLayout());
//        armoryScreen.weaponImagePanel.add(weaponImage, BorderLayout.CENTER);
    }

    public void loadBattle() {
        frame.remove(armoryScreen.panel);
        frame.add(battleScreen.panel);
        frame.repaint();
        frame.validate();

//        battleScreen.setName("Battle");
//        armoryScreen.setLayout(new BorderLayout());

//        fillBattlePanel();
    }
    //endregion
}
