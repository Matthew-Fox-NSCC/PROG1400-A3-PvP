import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class PanelProcessing {
    //region Variables
    protected final int DEFAULT_WIDTH = 500;
    protected final int DEFAULT_HEIGHT = 500;
    protected JFrame frame = new JFrame("Player VS Player App");
    protected JPanel splashPanel = new JPanel();
    protected JButton gotoPlayer;
    protected JButton gotoBattle;
    protected JPanel armoryPanel = new JPanel();
    protected JPanel battlePanel = new JPanel();
    protected ImageIcon[] weaponsArray = new ImageIcon[2];

    protected BusinessClass businessClass = new BusinessClass();
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
        frame.getContentPane().add(splashPanel);
        splashPanel.setLayout(null);
        fillSplash();
    }

    public void loadArmory() {
        frame.remove(splashPanel);
        frame.add(armoryPanel);
        frame.repaint();
        frame.validate();

        armoryPanel.setLayout(null);

        fillArmoryPanel();
    }

    public void loadBattle() {
        frame.remove(armoryPanel);
        frame.add(battlePanel);
        frame.repaint();
        frame.validate();

        armoryPanel.setLayout(null);

        fillBattlePanel();
    }
    //endregion

    //region PanelFilling
    public void fillSplash() {
        JLabel weaponImage = new JLabel((String) null);
//        Icon added to panel after icon added.
        weaponImage.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(PanelProcessing.class.getResource("/images/axe.png"))).getImage().getScaledInstance(DEFAULT_WIDTH, DEFAULT_HEIGHT, Image.SCALE_SMOOTH)));
        weaponImage.setBounds(120, -50, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        splashPanel.add(weaponImage);
        gotoPlayer = new JButton("goto player");
        gotoPlayer.setBounds(0, 0, 100, 20);

        addSplashListeners();

//        Button added to panel after listener.
        splashPanel.add(gotoPlayer);
    }

    public void fillArmoryPanel() {
        weaponsArray[0] = new ImageIcon(new ImageIcon(Objects.requireNonNull(PanelProcessing.class.getResource("/images/axe.png"))).getImage().getScaledInstance(DEFAULT_WIDTH, DEFAULT_HEIGHT, Image.SCALE_SMOOTH));
        weaponsArray[1] = new ImageIcon(new ImageIcon(Objects.requireNonNull(PanelProcessing.class.getResource("/images/sword.png"))).getImage().getScaledInstance(DEFAULT_WIDTH, DEFAULT_HEIGHT, Image.SCALE_SMOOTH));

        JLabel weaponImage = new JLabel((String) null);
        weaponImage.setIcon(weaponsArray[0]);
        weaponImage.setBounds(176, 70, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        armoryPanel.add(weaponImage);
        gotoBattle = new JButton("goto battle");
        gotoBattle.setBounds(0, 0, 100, 20);

        addArmoryListeners();

        armoryPanel.add(gotoBattle);

        JList weaponList = getjList(weaponImage);
        armoryPanel.add(weaponList);
    }

    public void fillBattlePanel() {
        JLabel playerImage = new JLabel((String) null);
        playerImage.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(PanelProcessing.class.getResource("images/wizard.png"))).getImage().getScaledInstance(DEFAULT_WIDTH, DEFAULT_HEIGHT, Image.SCALE_SMOOTH)));
        playerImage.setBounds(40, 40, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        battlePanel.add(playerImage);
    }
    //endregion

    //region AddListeners
    public void addSplashListeners() {
        gotoPlayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadArmory();
            }
        });
    }

    public void addArmoryListeners() {
        gotoBattle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadBattle();
            }
        });
    }
    //endregion

    //region CustomElements
    private JList getjList(JLabel weaponImage) {
        JList list = new JList();
        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                weaponImage.setIcon(weaponsArray[list.getSelectedIndex()]);
            }
        });
        list.setModel(new AbstractListModel() {
            final String[] values = new String[]{"Axe", "Sword"};

            public int getSize() {
                return values.length;
            }

            public Object getElementAt(int index) {
                return values[index];
            }
        });
        list.setBounds(77, 70, 89, 115);
        return list;
    }
    //endregion
}
