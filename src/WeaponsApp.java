import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class WeaponsApp {

    protected JFrame frame = new JFrame("Player VS Player App");
    protected JPanel splashPanel = new JPanel();
    protected JPanel armoryPanel = new JPanel();
    protected ImageIcon[] weaponsArray = new ImageIcon[2];

    protected BusinessClass bc = new BusinessClass();//stub demo of com with BC for demo purpose

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    WeaponsApp window = new WeaponsApp();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }//end main

    public WeaponsApp() {
        initialize();
    }

      private void initialize() {
          frame.setBounds(100, 100, 450, 300);
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.getContentPane().setLayout(new CardLayout(0, 0));
          loadSplash();
      }// end initialize

    public void loadSplash(){

        frame.getContentPane().add(splashPanel);
        splashPanel.setLayout(null);
        JLabel lblSplash = new JLabel((String) null);
        lblSplash.setIcon(new ImageIcon(WeaponsApp.class.getResource("/images/axe.png")));
        lblSplash.setBounds(120, -50, 300, 300);
        splashPanel.add(lblSplash);
        JButton btnToPlayer = new JButton("goto player");
        btnToPlayer.setBounds(0,0,100,20);

        btnToPlayer.addActionListener(new ActionListener(){    //add an event and take action
            public void actionPerformed(ActionEvent e){
                System.out.println(bc.getDex()); //stub demo of com with BC for demo purpose
                loadArmory();
            }
        });
        splashPanel.add(btnToPlayer);
    }
    public void loadArmory(){

        frame.remove(splashPanel);
        frame.add(armoryPanel);
        frame.repaint();
        frame.validate();

        armoryPanel .setLayout(null);

        weaponsArray[0]= new ImageIcon(WeaponsApp.class.getResource("/images/axe.png"));
        weaponsArray[1]= new ImageIcon(WeaponsApp.class.getResource("/images/sword.png"));

        JLabel lblWeapon = new JLabel((String) null);
        lblWeapon.setIcon(new ImageIcon(WeaponsApp.class.getResource("/images/axe.png")));
        lblWeapon.setBounds(176, 70, 100, 108);
        armoryPanel.add(lblWeapon);

        JList list = new JList();
        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                lblWeapon.setIcon(weaponsArray[list.getSelectedIndex()]);
            }
        });
        list.setModel(new AbstractListModel() {
            String[] values = new String[] {"Axe", "Sword"};
            public int getSize() {
                return values.length;
            }
            public Object getElementAt(int index) {
                return values[index];
            }
        });
        list.setBounds(77, 70, 89, 115);
        armoryPanel.add(list);

    }//end load armory

}//end class
