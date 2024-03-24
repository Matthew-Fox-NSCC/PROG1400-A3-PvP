import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class PanelProcessing {
    //region Variables
    protected final int DEFAULT_WIDTH = 200;
    protected final int DEFAULT_HEIGHT = 200;
    protected JFrame frame = new JFrame("Player VS Player App");
    protected JPanel splashPanel = new JPanel();
    protected JButton gotoPlayer;
    protected JButton gotoBattle;
    protected JPanel armoryPanel = new JPanel();
    protected ArmoryScreen armoryScreen = new ArmoryScreen();
    protected JPanel battlePanel = new JPanel();
    protected ImageIcon[] weaponsArray = new ImageIcon[2];
    protected Button buttonSelection;
    protected PlayerCharacter player = ActiveEntities.player;
    protected Equipment weapon = ActiveEntities.equipment;
    //endregion

    /**
     * Calls the initializer method to make the new JFrame.
     */
    //region PanelStart
    public PanelProcessing() {
        initialize();
    }

    /**
     * Initializes the JFrame with all constants.
     */
    private void initialize() {
        frame.setBounds(800, 250, 1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new CardLayout(0, 0));
        loadSplash();
    }
    //endregion

    //region PanelLoading
    /**
     * Adds the splash page to the JFrame.
     */
    public void loadSplash() {
        frame.add(splashPanel);
        splashPanel.setLayout(new BorderLayout());
        splashPanel.setName("Splash");
        fillSplash();
    }

    /**
     * Adds the armory page to the JFrame and removes the previous page.
     */
    public void loadArmory() {
        frame.remove(splashPanel);
        frame.add(armoryScreen.panel);
        addArmoryListeners();
        frame.repaint();
        frame.validate();

        armoryScreen.panel.setLayout(new BorderLayout());
        armoryScreen.panel.setName("Armory");

        fillArmory();
    }

    /**
     * Adds the battle page to the JFrame and removes the previous page.
     */
    public void loadBattle() {
        frame.remove(armoryScreen.panel);
        frame.add(battlePanel);
        frame.repaint();
        frame.validate();

        battlePanel.setName("Battle");

        armoryPanel.setLayout(null);

        fillBattlePanel();
    }
    //endregion

    //region AddListeners
    /**
     * Adds all the relevant listeners to elements on the armory page.
     */
    public void addArmoryListeners() {
        // OK Button.
        armoryScreen.OKButton.addActionListener(e -> loadBattle());

        // Class selection list.
        armoryScreen.classSelectionList.getSelectionModel().addListSelectionListener(e -> {
            player.setClassType(armoryScreen.classSelectionList.getSelectedValue());
            switch (player.getClassType()) {
                case "Wizard":
                    player.setImageURL("/images/wizard.png");
                    armoryScreen.playerPicture.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(PanelProcessing.class.getResource("/images/wizard.png"))).getImage().getScaledInstance(DEFAULT_WIDTH, DEFAULT_HEIGHT, Image.SCALE_SMOOTH)));
                    break;
                case "Knight":
                    player.setImageURL("/images/knight.png");
                    armoryScreen.playerPicture.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(PanelProcessing.class.getResource("/images/knight.png"))).getImage().getScaledInstance(DEFAULT_WIDTH, DEFAULT_HEIGHT, Image.SCALE_SMOOTH)));
                    break;
            }
            updateArmory();
        });

        // Left button.
        armoryScreen.leftButton.addActionListener(e -> {
            armoryScreen.leftButton.setBackground(Color.ORANGE);
            armoryScreen.rightButton.setBackground(Color.WHITE);
            buttonSelection = Button.LEFT;
        });

        // Right button.
        armoryScreen.rightButton.addActionListener(e -> {
            armoryScreen.rightButton.setBackground(Color.ORANGE);
            armoryScreen.leftButton.setBackground(Color.WHITE);
            buttonSelection = Button.RIGHT;
        });

        // Roll button.
        armoryScreen.rollButton.addActionListener(e -> {
            if (buttonSelection == Button.LEFT) {
                player.rollStats();
                armoryScreen.playerStatList.setText("Health: " + player.getHealth_points() + "\n" + "Armor: " + player.getArmor_points() + "\n" + "Strength: " + player.getStrength_points() + "\n" + "Dexterity: " + player.getDexterity_points());
            } else if (buttonSelection == Button.RIGHT) {
                weapon = new Equipment("Mjölnir", 6, 12);
                armoryScreen.weaponStatList.setText("Damage: " + weapon.getStrength());
            }
            updateArmory();
        });
    }
    //endregion

    //region PanelFilling
    /**
     * Fills a given panel with a title, a button, and a listener for the button.
     *
     * @param panel The panel to fill
     * @param titleString The title to use in the panel
     */
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
        gotoButton.setBackground(Color.WHITE);

        // Panel for button.
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(gotoButton);

        // Adding elements.
        panel.add(title, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * Fills the splash page with its elements.
     */
    public void fillSplash() {
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

        // Adding elements.
        splashPanel.add(instructionPanel, BorderLayout.CENTER);

        // Adds title and continue button.
        fillTitleAndContinue(splashPanel, "The Great Underground Empire");
    }

    /**
     * Updates the armory when information changes.
     */
    public void updateArmory() {
        // Player information text area.
        armoryScreen.playerInformation.setLineWrap(true);
        armoryScreen.playerInformation.setText(player.toString());
    }

    /**
     * Fills the armory page with its elements.
     */
    public void fillArmory() {
        // Weapon images.
        weaponsArray[0] = new ImageIcon(new ImageIcon(Objects.requireNonNull(PanelProcessing.class.getResource("/images/axe.png"))).getImage().getScaledInstance(DEFAULT_WIDTH, DEFAULT_HEIGHT, Image.SCALE_SMOOTH));
        weaponsArray[1] = new ImageIcon(new ImageIcon(Objects.requireNonNull(PanelProcessing.class.getResource("/images/sword.png"))).getImage().getScaledInstance(DEFAULT_WIDTH, DEFAULT_HEIGHT, Image.SCALE_SMOOTH));

        // Class selection list.
        armoryScreen.classSelectionList.setSelectedIndex(0);

        // Player picture.
        armoryScreen.playerPicture.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(PanelProcessing.class.getResource("/images/knight.png"))).getImage().getScaledInstance(DEFAULT_WIDTH, DEFAULT_HEIGHT, Image.SCALE_SMOOTH)));

        // Weapon picture.
        armoryScreen.weaponPicture.setIcon(weaponsArray[0]);

        // Center buttons.
        armoryScreen.leftButton.setBackground(Color.WHITE);
        armoryScreen.rightButton.setBackground(Color.WHITE);
        armoryScreen.rollButton.setBackground(Color.WHITE);
    }

    /**
     * Fills the battle page with its elements.
     */
    public void fillBattlePanel() {
        // Player image.
        JLabel playerImage = new JLabel((String) null);
        playerImage.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(PanelProcessing.class.getResource("/images/wizard.png"))).getImage().getScaledInstance(DEFAULT_WIDTH, DEFAULT_HEIGHT, Image.SCALE_SMOOTH)));
        playerImage.setBounds(40, 40, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        battlePanel.add(playerImage);
    }
    //endregion

    //region Enums
    /**
     * Button enum to track which button is pressed in the armory page.
     */
    protected enum Button {
        LEFT, RIGHT,
    }
    //endregion
}
