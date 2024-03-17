/*
 * Created by JFormDesigner on Mon Mar 04 09:41:20 AST 2024
 */

package guiElements;

import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Matthew
 */
public class PlayerArmorySelection extends JFrame {
    public PlayerArmorySelection() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Matthew
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        scrollPane2 = new JScrollPane();
        list2 = new JList();
        scrollPane3 = new JScrollPane();
        list3 = new JList();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        scrollPane4 = new JScrollPane();
        textArea1 = new JTextArea();
        scrollPane5 = new JScrollPane();
        textArea2 = new JTextArea();
        button4 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Stats");

        //---- label2 ----
        label2.setText("Class Selection");

        //---- label3 ----
        label3.setText("Weapon");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(list1);
        }

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(list2);
        }

        //======== scrollPane3 ========
        {
            scrollPane3.setViewportView(list3);
        }

        //---- button1 ----
        button1.setText("ROLL");

        //---- button2 ----
        button2.setText("\u27f6");

        //---- button3 ----
        button3.setText("\u27f5");

        //======== scrollPane4 ========
        {
            scrollPane4.setViewportView(textArea1);
        }

        //======== scrollPane5 ========
        {
            scrollPane5.setViewportView(textArea2);
        }

        //---- button4 ----
        button4.setText("OK");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(78, 78, 78)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(label1, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(113, 113, 113)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label2)
                                        .addComponent(button2)
                                        .addComponent(button4)
                                        .addComponent(button3)
                                        .addComponent(button1))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(31, 31, 31)
                                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                    .addGap(18, 18, 18))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(scrollPane4, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label3)
                        .addComponent(scrollPane5, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                        .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
                    .addGap(77, 77, 77))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(label2)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label3))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)
                            .addComponent(button2)
                            .addGap(18, 18, 18)
                            .addComponent(button1)
                            .addGap(18, 18, 18)
                            .addComponent(button3)))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(scrollPane4, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                        .addComponent(scrollPane5, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                    .addComponent(button4)
                    .addGap(67, 67, 67))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Matthew
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JScrollPane scrollPane1;
    private JList list1;
    private JScrollPane scrollPane2;
    private JList list2;
    private JScrollPane scrollPane3;
    private JList list3;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JScrollPane scrollPane4;
    private JTextArea textArea1;
    private JScrollPane scrollPane5;
    private JTextArea textArea2;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
