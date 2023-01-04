import java.sql.*;
import java.util.Scanner;

public class App {
    private static final String DB_URL = "jdbc:mysql://localhost:5003/JAVA_MCA";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            // Create a scanner for user input
            Scanner scanner = new Scanner(System.in);

            // Main loop for user interaction
            while (true) {
                // Print menu
                System.out.println("1. Add a record");
                System.out.println("2. Search for a record");
                System.out.println("3. Modify an existing record");
                System.out.println("4. Call backend procedure");
                System.out.println("5. Quit");
                System.out.print("Enter a number (1-5): ");

                // Read user input
                int choice = scanner.nextInt();

                // Perform action based on user input
                switch (choice) {
                    case 1:
                        addRecord(connection, scanner);
                        break;
                    case 2:
                        searchRecord(connection, scanner);
                        break;
                    case 3:
                        modifyRecord(connection, scanner);
                        break;
                    case 4:
                        callProcedure(connection, scanner);
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addRecord(Connection connection, Scanner scanner) throws SQLException {
        // Read user input
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline character
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student address: ");
        String address = scanner.nextLine();

        // Create PreparedStatement and execute insert
        String sql = "INSERT INTO students (id, name, address) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, address);
            statement.executeUpdate();
        }
    }

    private static void searchRecord(Connection connection, Scanner scanner) throws SQLException {
        // Read user input
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();

        // Create Prepared Statement and execute query
        String sql = "SELECT * FROM students WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                // Print results
                if (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("id"));
                    System.out.println("Name: " + resultSet.getString("name"));
                    System.out.println("Address: " + resultSet.getString("address"));
                } else {
                    System.out.println("Record not found.");
                }
            }
        }
    }

    private static void modifyRecord(Connection connection, Scanner scanner) throws SQLException {
        // Read user input
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline character
        System.out.print("Enter new student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new student address: ");
        String address = scanner.nextLine();

        // Create Prepared Statement and execute update
        String sql = "UPDATE students SET name = ?, address = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, address);
            statement.setInt(3, id);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                System.out.println("Record not found.");
            } else {
                System.out.println("Record updated successfully.");
            }
        }
    }

    private static void callProcedure(Connection connection, Scanner scanner) throws SQLException {
        // Read user input
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();

        // Create Callable Statement and execute procedure
        String sql = "{call get_student_details(?, ?, ?, ?)}";
        try (CallableStatement statement = connection.prepareCall(sql)) {
            statement.setInt(1, id);
            statement.registerOutParameter(2, Types.VARCHAR);
            statement.registerOutParameter(3, Types.VARCHAR);
            statement.registerOutParameter(4, Types.INTEGER);
            statement.execute();

            // Print results
            String name = statement.getString(2);
            String address = statement.getString(3);
            int age = statement.getInt(4);
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Address: " + address);
            System.out.println("Age: " + age);
        }
    }
}
