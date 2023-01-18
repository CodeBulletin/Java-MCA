import java.rmi.Naming;

public class Client {
    public static void main(String[] args) {
        try {
            SchoolInterface school = (SchoolInterface) Naming.lookup("rmi://localhost:5000/SchoolService");
            school.admit("1", "John Doe");
            school.admit("2", "Jane Doe");
            Student student = school.search("1");
            System.out.println("Name: " + student.getName());
        } catch (Exception e) {
            System.out.println("School Client failed: " + e);
        }
    }
}
