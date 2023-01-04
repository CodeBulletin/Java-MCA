import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        // Create an array of employee objects
        Employee[] employees = {
            new Employee("John Smith", 12345, "IT"),
            new Employee("Jane Doe", 54321, "HR"),
            new Employee("Bob Johnson", 23456, "Sales")
        };

        // Create a server socket and wait for client connections
        ServerSocket serverSocket = new ServerSocket(5000);
        while (true) {
            Socket socket = serverSocket.accept();
            ObjectInputStream input =
                new ObjectInputStream(socket.getInputStream());
            int employeeID = input.readInt();
            Employee employee = null;
            for (Employee e : employees) {
                if (e.getEmployeeID() == employeeID) {
                    employee = e;
                    break;
                }
            }
            ObjectOutputStream output =
                new ObjectOutputStream(socket.getOutputStream());
            output.writeObject(employee);
            output.flush();
            socket.close();
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