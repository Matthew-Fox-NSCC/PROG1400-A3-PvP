import javax.swing.*;
import java.awt.*;
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
        frame.add(splashPanel);
        splashPanel.setLayout(new BorderLayout());
        splashPanel.setName("Splash");
        fillSplash();
    }

    public void loadArmory() {
        frame.remove(splashPanel);
        frame.add(armoryPanel);
        frame.repaint();
        frame.validate();
//        frame.getContentPane().remove(splashPanel);
//        frame.getContentPane().add(armoryPanel);

        armoryPanel.setLayout(new BorderLayout());
        armoryPanel.setName("Armory");

        fillArmory();
    }

    public void loadBattle() {
        frame.remove(armoryPanel);
        frame.add(battlePanel);
        frame.repaint();
        frame.validate();

        battlePanel.setName("Battle");

        armoryPanel.setLayout(null);

        fillBattlePanel();
    }
    //endregion

    //region PanelFilling
    public void fillTitleAndContinue(JPanel panel, String titleString) {
        // The title label.
        JLabel title = new JLabel(titleString);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);

        // Continue button.
        JButton gotoButton = new JButton();
        if (panel.getName().equals("Splash")) {
            gotoButton = new JButton("Go to Armory");
            gotoButton.addActionListener(e -> loadArmory());
        } else if (panel.getName().equals("Armory")) {
            gotoButton = new JButton("Go to Battle");
            gotoButton.addActionListener(e -> loadBattle());
        }

        gotoButton.setMinimumSize(new Dimension(150, 50));
        gotoButton.setPreferredSize(new Dimension(150, 50));

        // Panel for button.
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(gotoButton);

        // Adding elements.
        panel.add(title, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);
    }

    public void fillSplash() {
//        // Instructions text area.
//        JTextArea instructions = new JTextArea();
//        instructions.setText("Game Instructions:\n- Instruction 1\n- Instruction 2\n- Instruction 3");
//        instructions.setFont(new Font("Arial", Font.PLAIN, 18));
//        instructions.setAlignmentX(Component.CENTER_ALIGNMENT);
//        instructions.setAlignmentY(Component.CENTER_ALIGNMENT);
//        instructions.setEditable(false);
//        instructions.setLineWrap(true);
//        instructions.setWrapStyleWord(true);
//
//        // Panel for instruction area.
//        JPanel instructionPanel = new JPanel();
//        instructionPanel.setLayout(new BoxLayout(instructionPanel, BoxLayout.Y_AXIS));
//        instructionPanel.add(Box.createVerticalGlue());
//        instructionPanel.add(instructions);
//        instructionPanel.add(Box.createVerticalGlue());
//        instructionPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
//        instructionPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
//
//        // Adding elements.
//        splashPanel.add(instructionPanel, BorderLayout.CENTER);

        fillTitleAndContinue(splashPanel, "The Great Underground Empire");
    }

    public void fillArmory() {
        //region GPTCode
//        // The Armory title label.
//        JLabel title = new JLabel("Armory");
//        title.setFont(new Font("Arial", Font.BOLD, 20));
//        title.setHorizontalAlignment(SwingConstants.CENTER);
//        title.setVerticalAlignment(SwingConstants.CENTER);
//
//        armoryPanel.add(title, BorderLayout.NORTH);
//
//        // Character class selection list.
//        String[] characterClasses = {"Warrior", "Wizard"};
//        JComboBox<String> classList = new JComboBox<>(characterClasses);
//
//        // Character stats text area.
//        JTextArea characterStatsArea = new JTextArea();
//        characterStatsArea.setEditable(false);
//
//        // Weapon selection list.
//        String[] weapons = {"Sword", "Staff"};
//        JList<String> weaponList = new JList<>(weapons);
//
//        // Weapon stats text area.
//        JTextArea weaponStatsArea = new JTextArea();
//        weaponStatsArea.setEditable(false);
//
//        // Weapon image.
//        ImageIcon weaponImage = new ImageIcon(new ImageIcon(Objects.requireNonNull(PanelProcessing.class.getResource("/images/sword.png"))).getImage().getScaledInstance(DEFAULT_WIDTH, DEFAULT_HEIGHT, Image.SCALE_SMOOTH));
//        JLabel weaponImageLabel = new JLabel(weaponImage);
//        weaponImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
//
//        // Buttons
//        JButton leftArrowButton = new JButton("←");
//        JButton rightArrowButton = new JButton("→");
//        JButton rollButton = new JButton("Roll");
//        JTextArea statsTextArea = new JTextArea();
//        statsTextArea.setEditable(false);
//
//        // Continue Button
//        JButton continueButton = new JButton("Continue");
//
//        continueButton.addActionListener(e -> loadBattle());
//
//        continueButton.setMinimumSize(new Dimension(150, 50));
//        continueButton.setPreferredSize(new Dimension(150, 50));

        // Layout information.
//        JPanel topPanel = new JPanel(new BorderLayout());
//        topPanel.add(title, BorderLayout.CENTER);
//        armoryPanel.add(topPanel, BorderLayout.NORTH);
//        armoryPanel.add(title, BorderLayout.NORTH);

//        JPanel centerPanel = new JPanel(new BorderLayout());
//        JPanel characterPanel = new JPanel(new BorderLayout());
//        characterPanel.add(new JScrollPane(characterStatsArea), BorderLayout.CENTER);
//        centerPanel.add(characterPanel, BorderLayout.WEST);
//        centerPanel.add(classList, BorderLayout.CENTER);
//        JPanel weaponPanel = new JPanel(new BorderLayout());
//        weaponPanel.add(new JScrollPane(weaponStatsArea), BorderLayout.CENTER);
//        weaponPanel.add(weaponImageLabel, BorderLayout.SOUTH);
//        centerPanel.add(weaponPanel, BorderLayout.EAST);
//        armoryPanel.add(centerPanel, BorderLayout.CENTER);
//
//        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//        bottomPanel.add(leftArrowButton);
//        bottomPanel.add(rollButton);
//        bottomPanel.add(rightArrowButton);
//        bottomPanel.add(new JScrollPane(statsTextArea));
//        armoryPanel.add(bottomPanel, BorderLayout.SOUTH);
//
//        armoryPanel.add(continueButton, BorderLayout.SOUTH);
        //endregion

        //region DavidsCode
//        weaponsArray[0] = new ImageIcon(new ImageIcon(Objects.requireNonNull(PanelProcessing.class.getResource("/images/axe.png"))).getImage().getScaledInstance(DEFAULT_WIDTH, DEFAULT_HEIGHT, Image.SCALE_SMOOTH));
//        weaponsArray[1] = new ImageIcon(new ImageIcon(Objects.requireNonNull(PanelProcessing.class.getResource("/images/sword.png"))).getImage().getScaledInstance(DEFAULT_WIDTH, DEFAULT_HEIGHT, Image.SCALE_SMOOTH));
//
//        JLabel weaponImage = new JLabel((String) null);
//        weaponImage.setIcon(weaponsArray[0]);
//        weaponImage.setBounds(176, 70, DEFAULT_WIDTH, DEFAULT_HEIGHT);
//        gotoBattle = new JButton("goto battle");
//        gotoBattle.setBounds(0, 0, 100, 20);
//
//        gotoBattle.addActionListener(e -> loadBattle());
//
//
//        armoryPanel.add(weaponImage);
//        armoryPanel.add(gotoBattle, BorderLayout.NORTH);
//
//        JList weaponList = getjList(weaponImage);
//        armoryPanel.add(weaponList);
        //endregion

        fillTitleAndContinue(armoryPanel, "Armory");
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
