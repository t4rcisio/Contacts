package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    private JPanel MainPanel;
    private JButton newContactButton;
    private JButton removeContactButton;
    private JTable contactsTable;

    public MainForm(){
        setContentPane(MainPanel); //Painel raiz
        setSize(500,250);
        setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2 - getSize().width/2, dim.height/2 - getSize().height/2);

        setListeners();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }

    private void setListeners(){
        newContactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewClientForm();
                dispose();
            }
        });

        removeContactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
