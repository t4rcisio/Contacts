package UI;

import Business.ClientBusiness;
import Entity.ClientEntity;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainForm extends JFrame {
    private JPanel MainPanel;
    private JButton newContactButton;
    private JButton removeContactButton;
    private JTable contactsTable;
    private JLabel ContactCounter;
    private JLabel ErrorRemove;

    private ClientBusiness mClientBusiness;

    public MainForm(){
        setContentPane(MainPanel); //Painel raiz
        setSize(500,250);
        setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2 - getSize().width/2, dim.height/2 - getSize().height/2);
        mClientBusiness = new ClientBusiness();
        setListeners();
        loadContacts();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }

    private void loadContacts(){
       List<ClientEntity> list =  mClientBusiness.getList();
       String [] columnNames = {"Name","Phone", "CPF"};
       DefaultTableModel table = new DefaultTableModel(new Object[0][0][0], columnNames);

       for(ClientEntity client : list){
           Object[] row = new Object[3];
           row[0] = client.getName();
           row[1] = client.getPhone();
           row[2] = client.getCpf();
           table.addRow(row);
       }
       contactsTable.clearSelection();
       contactsTable.setModel(table);
       ContactCounter.setText(mClientBusiness.getDescription());
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

                try {Object cpf = contactsTable.getValueAt(contactsTable.getSelectedRow(), 2);
                    if(!cpf.toString().isEmpty()) {
                        mClientBusiness.remove(cpf.toString());
                        loadContacts();
                        ErrorRemove.setText("");
                    }
                } catch (Exception p){
                    ErrorRemove.setForeground(Color.RED);
                    ErrorRemove.setText("Select a valid contact!");
                }


            }
        });
    }

}
