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
        splashPanel.setLayout(new BorderLayout());
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
        // The Splash title label.
        JLabel title = new JLabel("The Great Underground Empire");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);

        // Instructions text area.
        JTextArea instructions = new JTextArea();
        instructions.setText("Game Instructions:\n- Instruction 1\n- Instruction 2\n- Instruction 3");
        instructions.setFont(new Font("Arial", Font.PLAIN, 18));
        instructions.setAlignmentX(Component.CENTER_ALIGNMENT);
        instructions.setAlignmentY(Component.CENTER_ALIGNMENT);
        instructions.setEditable(false);
        instructions.setLineWrap(true);
        instructions.setWrapStyleWord(true);

        // Panel for instruction area.
        JPanel instructionPanel = new JPanel();
        instructionPanel.setLayout(new BoxLayout(instructionPanel, BoxLayout.Y_AXIS));
        instructionPanel.add(Box.createVerticalGlue());
        instructionPanel.add(instructions);
        instructionPanel.add(Box.createVerticalGlue());
        instructionPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        instructionPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

        // Continue button.
        JButton gotoPlayer = new JButton("Go to Player");

        gotoPlayer.addActionListener(e -> loadArmory());

        gotoPlayer.setMinimumSize(new Dimension(150, 50));
        gotoPlayer.setPreferredSize(new Dimension(150, 50));

        // Panel for button.
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(gotoPlayer);

        // Adding elements.
        splashPanel.add(title, BorderLayout.NORTH);
        splashPanel.add(instructionPanel, BorderLayout.CENTER);
        splashPanel.add(buttonPanel, BorderLayout.SOUTH);
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

        gotoBattle.addActionListener(e -> loadBattle());

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

    //region CustomElements
    private JList<String> getjList(JLabel weaponImage) {
        JList<String> list = new JList<>();
        list.addListSelectionListener(e -> weaponImage.setIcon(weaponsArray[list.getSelectedIndex()]));
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
