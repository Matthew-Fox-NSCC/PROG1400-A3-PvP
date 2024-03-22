import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class WeaponsApp {

    protected JFrame frame = new JFrame("Player VS Player App");
    protected JPanel splashPanel = new JPanel();
    protected JPanel armoryPanel = new JPanel();
    protected ImageIcon[] weaponsArray = new ImageIcon[2];

    protected BusinessClass businessClass = new BusinessClass();//stub demo of com with BC for demo purpose

    public WeaponsApp() {
        initialize();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    WeaponsApp window = new WeaponsApp();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });
    }//end main

    private void initialize() {
        frame.setBounds(800, 250, 800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new CardLayout(0, 0));
        loadSplash();
    }// end initialize

    public void loadSplash() {

        frame.getContentPane().add(splashPanel);
        splashPanel.setLayout(null);
        JLabel weaponImage = new JLabel((String) null);
//        Icon added to panel after icon added.
        weaponImage.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(WeaponsApp.class.getResource("/images/axe.png"))).getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH)));
        weaponImage.setBounds(120, -50, 500, 500);
        splashPanel.add(weaponImage);
        JButton gotoPlayer = new JButton("goto player");
        gotoPlayer.setBounds(0, 0, 100, 20);

        gotoPlayer.addActionListener(new ActionListener() {    //add an event and take action
            public void actionPerformed(ActionEvent e) {
                System.out.println(businessClass.getDex()); //stub demo of com with BC for demo purpose
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

        weaponsArray[0] = new ImageIcon(new ImageIcon(Objects.requireNonNull(WeaponsApp.class.getResource("/images/axe.png"))).getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH));
        weaponsArray[1] = new ImageIcon(new ImageIcon(Objects.requireNonNull(WeaponsApp.class.getResource("/images/sword.png"))).getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH));

        JLabel weaponImage = new JLabel((String) null);
        weaponImage.setIcon(new ImageIcon(Objects.requireNonNull(WeaponsApp.class.getResource("/images/axe.png"))));
        weaponImage.setBounds(176, 70, 500, 500);
        armoryPanel.add(weaponImage);

        JList weaponList = getjList(weaponImage);
        armoryPanel.add(weaponList);

    }//end load armory

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

}//end class
