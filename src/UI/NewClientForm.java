package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewClientForm extends JFrame {


    private JPanel MainPanel;
    private JLabel Name;
    private JButton cancelButton;
    private JButton salveButton;
    private JLabel Phone;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JTextField phone;
    private JTextField mail;
    private JLabel Birthday;
    private JLabel Gender;
    private JLabel Mail;
    private JTextField Addres;
    private JTextField CPF;
    private JTextField textName;

    public NewClientForm(){
    setContentPane(MainPanel);
    setSize(600,250);
    setVisible(true);

    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    setLocation(dim.width/2 - getSize().width/2, dim.height/2 - getSize().height/2);

    setListeners();

    }

    private void setListeners(){
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainForm();
                dispose();
            }
        });

        salveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainForm();
                dispose();
            }
        });
    }

}
