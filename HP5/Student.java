import java.rmi.Remote;
import java.rmi.RemoteException;

interface SchoolInterface extends Remote {
    public void admit(String rollNo, String name) throws RemoteException;

    public Student search(String rollNo) throws RemoteException;
}

class Student implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private String rollNo;
    private String name;

    public Student(String rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }
}