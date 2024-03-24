import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
    protected BattleScreen battleScreen = new BattleScreen();
    protected ImageIcon[] weaponsArray = new ImageIcon[2];
    protected Button buttonSelection;
    protected PlayerCharacter player = ActiveEntities.player;
    protected EnemyCharacter enemy = ActiveEntities.enemy;
    //endregion

    //region PanelStart
    /**
     * Calls the initializer method to make the new JFrame.
     */
    public PanelProcessing() {
        initialize();
    }

    /**
     * Initializes the JFrame with all constants.
     */
    private void initialize() {
        frame.setBounds(800, 250, 1000, 800);
//        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new CardLayout(0, 0));
        loadSplash();
    }
    //endregion

    //region GameMethods
    public void battle() {
        boolean done = false;
        int secondsToSleep = 1;
        while (!done) {
            // Maximum dexterity is 20.
            final int MAXIMUM_DEXTERITY = 20;
            int playerAttackChance = 100 / (player.getDexterity_points() * (100 / MAXIMUM_DEXTERITY));
            int enemyAttackChance = 100 / (enemy.getDexterity_points() * (100 / MAXIMUM_DEXTERITY));

            Random random = new Random();

            if (random.nextInt(MAXIMUM_DEXTERITY) <= playerAttackChance) {
                int playerAttack = player.attack();
                enemy.defend(playerAttack);
                battleScreen.playByPlay.append("\n" + player.getClassType() + " attacks " + "Aboleth" + " for " + Integer.toString(playerAttack) + " damage");
            }
            if (random.nextInt(MAXIMUM_DEXTERITY) <= enemyAttackChance) {
                int enemyAttack = enemy.attack();
                player.defend(enemyAttack);
                battleScreen.playByPlay.append("\n" + "Aboleth" + " attacks " + player.getClassType() + " for " + Integer.toString(enemyAttack) + " damage");
            } else {
                int playerAttack = player.attack();
                enemy.defend(playerAttack);
                battleScreen.playByPlay.append("\n" + player.getClassType() + " attacks " + "Aboleth" + " for " + Integer.toString(playerAttack) + " damage");
            }

            if (player.getHealth_points() <= 0) {
                done = true;
                battleScreen.playByPlay.append("\n" + player.getClassType() + " has died");
            }
            if (enemy.getHealth_points() <= 0) {
                done = true;
                battleScreen.playByPlay.append("\n" + "Aboleth" + " has died");
            }

            try {
                TimeUnit.SECONDS.sleep(secondsToSleep);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
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
        frame.add(battleScreen.panel);
        addBattleListeners();
        frame.repaint();
        frame.validate();

        battleScreen.panel.setName("Battle");

//        armoryPanel.setLayout(null);

        fillBattle();
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
                    // Player image change.
                    player.setImageURL("/images/wizard.png");

                    // Weapon selection list change.
                    DefaultListModel<String> weaponWizardList = new DefaultListModel<>();
                    weaponWizardList.addElement("Staff");
                    weaponWizardList.addElement("Wand");
                    weaponWizardList.addElement("Grimoire");
                    armoryScreen.weaponSelectionList.setModel(weaponWizardList);

                    break;
                case "Knight":
                    // Player image change.
                    player.setImageURL("/images/knight.png");

                    // Weapon selection list change.
                    DefaultListModel<String> weaponKnightList = new DefaultListModel<>();
                    weaponKnightList.addElement("Longsword");
                    weaponKnightList.addElement("Axe");
                    weaponKnightList.addElement("Greatsword");
                    armoryScreen.weaponSelectionList.setModel(weaponKnightList);

                    break;
            }
            armoryScreen.playerPicture.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(PanelProcessing.class.getResource(player.getImageURL()))).getImage().getScaledInstance(DEFAULT_WIDTH, DEFAULT_HEIGHT, Image.SCALE_SMOOTH)));
            updateArmory();
        });

        // Weapon selection list.
        armoryScreen.weaponSelectionList.getSelectionModel().addListSelectionListener(e -> {
            player.getWeapon().setName(armoryScreen.weaponSelectionList.getSelectedValue().toString());
            switch (player.getWeapon().getName()) {
                case "Longsword":
                    player.getWeapon().setImageURL("images/knight-longsword.png");
                    break;
                case "Axe":
                    player.getWeapon().setImageURL("images/knight-axe.png");
                    break;
                case "Greatsword":
                    player.getWeapon().setImageURL("images/knight-greatsword.png");
                    break;
                case "Staff":
                    player.getWeapon().setImageURL("images/wizard-staff.jpg");
                    break;
                case "Wand":
                    player.getWeapon().setImageURL("images/wizard-wand.jpg");
                    break;
                case "Grimoire":
                    player.getWeapon().setImageURL("images/wizard-grimoire.jpg");
                    break;
            }
            armoryScreen.weaponPicture.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(PanelProcessing.class.getResource(player.getWeapon().getImageURL()))).getImage().getScaledInstance(DEFAULT_WIDTH, DEFAULT_HEIGHT, Image.SCALE_SMOOTH)));
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
                player.getWeapon().calculate(6, 12);
                armoryScreen.weaponStatList.setText("Damage: " + player.getWeapon().getStrength());
            }
            updateArmory();
        });
    }

    public void addBattleListeners() {
        battleScreen.FIGHTButton.addActionListener(e -> {
            battle();
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
    public void fillBattle() {
//        // Player image.
//        JLabel playerImage = new JLabel((String) null);
//        playerImage.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(PanelProcessing.class.getResource("/images/wizard.png"))).getImage().getScaledInstance(DEFAULT_WIDTH, DEFAULT_HEIGHT, Image.SCALE_SMOOTH)));
//        playerImage.setBounds(40, 40, DEFAULT_WIDTH, DEFAULT_HEIGHT);
//        battlePanel.add(playerImage);

        battleScreen.playerPicture.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(PanelProcessing.class.getResource(player.getImageURL()))).getImage().getScaledInstance(DEFAULT_WIDTH, DEFAULT_HEIGHT, Image.SCALE_SMOOTH)));

        enemy.setImageURL("images/aboleth.png");

        battleScreen.enemyPicture.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(PanelProcessing.class.getResource(enemy.getImageURL()))).getImage().getScaledInstance(DEFAULT_WIDTH, DEFAULT_HEIGHT, Image.SCALE_SMOOTH)));

        battleScreen.playerLabel.setText(player.getClassType());
        battleScreen.enemyLabel.setText("Aboleth");

        battleScreen.FIGHTButton.setBackground(Color.WHITE);
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
