import javax.swing.JFrame;

public class App {
    public static void main(String[] args) {
        ContactManager manager = new ContactManager();
        manager.setTitle("Contact Manager");
        manager.setSize(800, 600);
        manager.setLocationRelativeTo(null);
        manager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        manager.setVisible(true);
    }
}
