import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Application {

    protected JFrame frame = new JFrame("Player VS Player App");
    protected JPanel splashPanel = new JPanel();
    protected JPanel armoryPanel = new JPanel();
    protected ImageIcon[] weaponsArray = new ImageIcon[2];

    protected BusinessClass businessClass = new BusinessClass();

    public Application() {
        initialize();
    }

    private void initialize() {
        frame.setBounds(800, 250, 800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new CardLayout(0, 0));
        loadSplash();
    }

    public void loadSplash() {

        frame.getContentPane().add(splashPanel);
        splashPanel.setLayout(null);
        JLabel weaponImage = new JLabel((String) null);
//        Icon added to panel after icon added.
        weaponImage.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(Application.class.getResource("/images/axe.png"))).getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH)));
        weaponImage.setBounds(120, -50, 500, 500);
        splashPanel.add(weaponImage);
        JButton gotoPlayer = new JButton("goto player");
        gotoPlayer.setBounds(0, 0, 100, 20);

        gotoPlayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadArmory();
            }
        });
//        Button added to panel after listener.
        splashPanel.add(gotoPlayer);
    }

    public void loadArmory() {

        frame.remove(splashPanel);
        frame.add(armoryPanel);
        frame.repaint();
        frame.validate();

        armoryPanel.setLayout(null);

        weaponsArray[0] = new ImageIcon(new ImageIcon(Objects.requireNonNull(Application.class.getResource("/images/axe.png"))).getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH));
        weaponsArray[1] = new ImageIcon(new ImageIcon(Objects.requireNonNull(Application.class.getResource("/images/sword.png"))).getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH));

        JLabel weaponImage = new JLabel((String) null);
        weaponImage.setIcon(new ImageIcon(Objects.requireNonNull(Application.class.getResource("/images/axe.png"))));
        weaponImage.setBounds(176, 70, 500, 500);
        armoryPanel.add(weaponImage);

        JList weaponList = getjList(weaponImage);
        armoryPanel.add(weaponList);

    }

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

}
