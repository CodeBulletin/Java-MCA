import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        // Read the employee ID from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee ID: ");
        int employeeID = scanner.nextInt();

        // Connect to the server and send the employee ID
        Socket socket = new Socket("localhost", 5000);
        ObjectOutputStream output =
            new ObjectOutputStream(socket.getOutputStream());
        output.writeInt(employeeID);
        output.flush();

        // Receive the employee object from the server
        ObjectInputStream input =
            new ObjectInputStream(socket.getInputStream());
        Employee employee = (Employee) input.readObject();

        // Display the received object's information
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee not found");
        }
    }
}

class Employee implements java.io.Serializable {
    private String employeeName;
    private int employeeID;
    private String department;

    public Employee(String employeeName, int employeeID, String department) {
        this.employeeName = employeeName;
        this.employeeID = employeeID;
        this.department = department;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return 
            "Employee Name: " + employeeName +
            ", Employee ID: " + employeeID + 
            ", Department: " + department;
    }
}