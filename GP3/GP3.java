import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GP3 {
    public static void main(String[] args) {
        JFrame frame = new EmployeeForm();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setVisible(true);
    }
}

class EmployeeForm extends JFrame {

    private JLabel nameLabel, dojLabel, addressLabel;
    private JTextField nameField, dojField, addressField;
    private JButton displayButton, cancelButton;

    public EmployeeForm() {
        super("Employee Form");

        setLayout(new FlowLayout());

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(4, 2, 10, 20));

        nameLabel = new JLabel("Name:");
        panel.add(nameLabel);

        nameField = new JTextField(10);
        panel.add(nameField);

        dojLabel = new JLabel("Date of Joining:");
        panel.add(dojLabel);

        dojField = new JTextField(10);
        panel.add(dojField);

        addressLabel = new JLabel("Address:");
        panel.add(addressLabel);

        addressField = new JTextField(10);
        panel.add(addressField);

        displayButton = new JButton("Display");
        panel.add(displayButton);
        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String doj = dojField.getText();
                String address = addressField.getText();

                JFrame displayFrame = new JFrame();
                displayFrame.setLayout(new GridLayout(3, 2));
                displayFrame.add(new JLabel("Name:"));
                displayFrame.add(new JLabel(name));
                displayFrame.add(new JLabel("Date of Joining:"));
                displayFrame.add(new JLabel(doj));
                displayFrame.add(new JLabel("Address:"));
                displayFrame.add(new JLabel(address));
                displayFrame.setSize(300, 150);
                displayFrame.setVisible(true);
            }
        });

        cancelButton = new JButton("Cancel");
        panel.add(cancelButton);
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nameField.setText("");
                dojField.setText("");
                addressField.setText("");
            }
        });

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(panel);
    }
}