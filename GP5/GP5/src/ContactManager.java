import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

import ConnectionCreator.ConnectionCreator;

public class ContactManager extends JFrame {
    private JTable contactTable;
    private JTextField nameField, numberField, searchField;
    private JButton addButton, updateButton, deleteButton, searchButton;
    private JPanel panel;

    private Connection connection;
    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;
    private PreparedStatement deleteStatement;
    private PreparedStatement searchStatement;

    public ContactManager() {
        // Connect to the database
        connectToDB();

        // Create a table model to hold the contact data
        ContactTableModel model = new ContactTableModel(connection);

        // Create the table and add it to the frame
        contactTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(contactTable);
        add(scrollPane, BorderLayout.CENTER);

        panel = new JPanel();
        panel.setMaximumSize(panel.getPreferredSize());
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Create text fields for name and number and search field
        JLabel nameText = new JLabel();
        nameText.setText("Name");
        panel.add(nameText);
        nameField = new JTextField(15);
        panel.add(nameField);

        JLabel numberText = new JLabel();
        numberText.setText("Number");
        panel.add(numberText);
        numberField = new JTextField(15);
        panel.add(numberField);
        addButton = new JButton("Add");
        panel.add(addButton);

        updateButton = new JButton("Update");
        panel.add(updateButton);

        JLabel searchText = new JLabel();
        searchText.setText("Search");
        panel.add(searchText);
        searchField = new JTextField(15);
        panel.add(searchField);
        searchButton = new JButton("Search");
        panel.add(searchButton);

        deleteButton = new JButton("Delete");

        panel.add(deleteButton);

        add(panel, BorderLayout.EAST);

        // Add action listeners to the buttons
        addButton.addActionListener(new AddButtonListener());
        updateButton.addActionListener(new UpdateButtonListener());
        deleteButton.addActionListener(new DeleteButtonListener());
        searchButton.addActionListener(new SearchButtonListener());

    }

    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String number = numberField.getText();
            try {
                insertStatement.setString(1, name);
                insertStatement.setString(2, number);
                insertStatement.executeUpdate();
                ((ContactTableModel) contactTable.getModel()).update();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private class UpdateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = contactTable.getSelectedRow();
            if (selectedRow != -1) {
                String name = nameField.getText();
                String number = numberField.getText();
                int id = (int) contactTable.getValueAt(selectedRow, 0);
                try {
                    updateStatement.setString(1, name);
                    updateStatement.setString(2, number);
                    updateStatement.setInt(3, id);
                    updateStatement.executeUpdate();
                    ((ContactTableModel) contactTable.getModel()).update();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = contactTable.getSelectedRow();
            if (selectedRow != -1) {
                String id = (String) contactTable.getValueAt(selectedRow, 1);
                try {
                    deleteStatement.setString(1, id);
                    deleteStatement.executeUpdate();
                    ((ContactTableModel) contactTable.getModel()).update();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private class SearchButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String search = searchField.getText();
            try {
                searchStatement.setString(1, search);
                ResultSet rs = searchStatement.executeQuery();
                ((ContactTableModel) contactTable.getModel()).updateData(rs);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void connectToDB() {
        try {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            connection = ConnectionCreator.create("jdbc:oracle:thin:@localhost:9000/XEPDB1")
                    .setUsername("system")
                    .setPassword("1234")
                    .connect()
                    .getConnection();
            // Create prepared statements for inserting, updating, deleting, and searching
            // for a contact
            insertStatement = connection.prepareStatement("INSERT INTO Contacts (name, mobile_number) VALUES (?, ?)");
            updateStatement = connection
                    .prepareStatement("UPDATE Contacts SET name = ?, mobile_number = ? WHERE id = ?");
            deleteStatement = connection.prepareStatement("DELETE FROM Contacts WHERE mobile_number = ?");
            searchStatement = connection.prepareStatement("SELECT * FROM Contacts WHERE name LIKE ?",
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
