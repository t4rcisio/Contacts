package UI;

import Business.ClientBusiness;
import Business.WindowBusiness;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewClientForm extends JFrame {


    private JPanel MainPanel;
    private JLabel nameLabel;
    private JButton cancelButton;
    private JButton salveButton;
    private JLabel phoneLabel;
    private JTextField Birthday;
    private JComboBox Gender;
    private JTextField Phone;
    private JTextField Mail;
    private JLabel birthdayLabel;
    private JLabel genderLabel;
    private JLabel mailLabel;
    private JTextField Addr;
    private JTextField CPF;
    private JTextField Name;
    private JLabel cpfLabel;
    private JLabel addressLabel;

    private  ClientBusiness mClientBusiness;
    private WindowBusiness mWindowBusness;

    public NewClientForm(){
    setContentPane(MainPanel);
    setSize(600,250);
    setVisible(true);
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    setLocation(dim.width/2 - getSize().width/2, dim.height/2 - getSize().height/2);
    mClientBusiness = new ClientBusiness();
    mWindowBusness = new WindowBusiness();
    setListeners();


    mWindowBusness.chekTextField(CPF,Name,Addr,Phone,Mail,Birthday);

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

                mClientBusiness.save(Name.getText(), Phone.getText(), Birthday.getText(), Mail.getText(), CPF.getText(), Addr.getText());

            }
        });
    }

}
