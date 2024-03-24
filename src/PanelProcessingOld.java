import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Objects;

public class PanelProcessingOld {
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
    protected enum Button {
        LEFT,
        RIGHT,
    }

    protected Button buttonSelection;
    //endregion

    //region PanelStart
    public PanelProcessingOld() {
        initialize();
    }

    private void initialize() {
        frame.setBounds(800, 250, 1000, 800);
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
        frame.add(armoryScreen.panel);
        addArmoryListeners();
        frame.repaint();
        frame.validate();

        armoryScreen.panel.setLayout(new BorderLayout());
        armoryScreen.panel.setName("Armory");

        fillArmory();
    }

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
        gotoButton.setBackground(Color.WHITE);

        // Panel for button.
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(gotoButton);

        // Adding elements.
        panel.add(title, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);
    }

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

        fillTitleAndContinue(splashPanel, "The Great Underground Empire");
    }

    public void addArmoryListeners() {
        armoryScreen.OKButton.addActionListener(e -> loadBattle());

        armoryScreen.classSelectionList.getSelectionModel().addListSelectionListener(e -> {
            ActiveEntities.player.setClassType(armoryScreen.classSelectionList.getSelectedValue().toString());
            switch (ActiveEntities.player.getClassType()) {
                case "Wizard":
                    ActiveEntities.player.setImageURL("/images/wizard.png");
                    armoryScreen.playerPicture.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(PanelProcessing.class.getResource("/images/wizard.png"))).getImage().getScaledInstance(DEFAULT_WIDTH, DEFAULT_HEIGHT, Image.SCALE_SMOOTH)));
                    break;
                case "Knight":
                    ActiveEntities.player.setImageURL("/images/knight.png");
                    armoryScreen.playerPicture.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(PanelProcessing.class.getResource("/images/knight.png"))).getImage().getScaledInstance(DEFAULT_WIDTH, DEFAULT_HEIGHT, Image.SCALE_SMOOTH)));
                    break;
            }
            fillArmoryPanel();
        });

        armoryScreen.leftButton.addActionListener(e -> {
            armoryScreen.leftButton.setBackground(Color.ORANGE);
            armoryScreen.rightButton.setBackground(Color.WHITE);
            buttonSelection = Button.LEFT;
        });

        armoryScreen.rightButton.addActionListener(e -> {
            armoryScreen.rightButton.setBackground(Color.ORANGE);
            armoryScreen.leftButton.setBackground(Color.WHITE);
            buttonSelection = Button.RIGHT;
        });
    }

    public void fillArmoryPanel() {
        armoryScreen.playerInformation.setLineWrap(true);
        armoryScreen.playerInformation.setText(ActiveEntities.player.toString());
    }

    public void fillArmory() {
        weaponsArray[0] = new ImageIcon(
                new ImageIcon(
                        Objects.requireNonNull(
                                PanelProcessing.class.getResource("/images/axe.png"))).getImage()
                        .getScaledInstance(DEFAULT_WIDTH, DEFAULT_HEIGHT, Image.SCALE_SMOOTH)
        );
        weaponsArray[1] = new ImageIcon(
                new ImageIcon(
                        Objects.requireNonNull(
                                PanelProcessing.class.getResource("/images/sword.png"))).getImage()
                        .getScaledInstance(DEFAULT_WIDTH, DEFAULT_HEIGHT, Image.SCALE_SMOOTH)
        );

        armoryScreen.classSelectionList.setSelectedIndex(0);
        armoryScreen.playerPicture.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(PanelProcessing.class.getResource("/images/knight.png"))).getImage().getScaledInstance(DEFAULT_WIDTH, DEFAULT_HEIGHT, Image.SCALE_SMOOTH)));

        armoryScreen.weaponPicture.setIcon(weaponsArray[0]);

        armoryScreen.leftButton.setBackground(Color.WHITE);
        armoryScreen.rightButton.setBackground(Color.WHITE);
        armoryScreen.rollButton.setBackground(Color.WHITE);
    }

    public void fillBattlePanel() {
        JLabel playerImage = new JLabel((String) null);
        playerImage.setIcon(new ImageIcon(
                new ImageIcon(
                        Objects.requireNonNull(
                                PanelProcessingOld.class.getResource("/images/wizard.png"))).getImage()
                        .getScaledInstance(DEFAULT_WIDTH, DEFAULT_HEIGHT, Image.SCALE_SMOOTH)
        ));
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
