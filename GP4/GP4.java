import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GP4 {
    public static void main(String[] args) {
        MessageBox messageBox = new MessageBox("Please enter a message:");
        while(messageBox.isVisible()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (messageBox.wasOkPressed()) {
            JFrame frame = new JFrame();
            frame.setSize(100, 100);
            String message = messageBox.getInput();
            frame.add(new JLabel("You entered: " + message));
            frame.setVisible(true);
        } else {
            System.out.println("Cancel button pressed.");
        }
    }
}

class MessageBox extends Frame {
    private boolean okPressed;
    private TextField inputField;

    public MessageBox(String message) {
        this.okPressed = false;
        setLayout(new FlowLayout());
        add(new Label(message));
        inputField = new TextField(20);
        add(inputField);
        Button okButton = new Button("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                okPressed = true;
                setVisible(false);
                dispose();
            }
        });
        add(okButton);
        Button cancelButton = new Button("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
            }
        });
        add(cancelButton);
        pack();
        setVisible(true);
    }

    public boolean wasOkPressed() {
        return okPressed;
    }

    public String getInput() {
        if (okPressed) {
            return inputField.getText();
        } else {
            return null;
        }
    }
}
