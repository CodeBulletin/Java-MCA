import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static void main(String[] args) {
        try {
            School school = new School();
            Registry registry = LocateRegistry.createRegistry(5000);
            registry.rebind("SchoolService", school);
            
            System.out.println("School Server is ready.");
        } catch (Exception e) {
            System.out.println("School Server failed: " + e);
        }
    }
}

class School extends UnicastRemoteObject implements SchoolInterface {
    private static final long serialVersionUID = 1L;
    private List<Student> students;

    public School() throws RemoteException {
        students = new ArrayList<Student>();
    }

    public void admit(String rollNo, String name) throws RemoteException {
        Student student = new Student(rollNo, name);
        students.add(student);
    }

    public Student search(String rollNo) throws RemoteException {
        for (Student student : students) {
            if (student.getRollNo().equals(rollNo)) {
                return student;
            }
        }
        throw new RemoteException("Invalid roll number");
    }
}

