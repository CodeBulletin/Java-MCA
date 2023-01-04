import java.util.Arrays;
import java.util.Comparator;

public class CP8 {
    public static void main(String[] args) {
        Student[] students = {
            new Student(1, "John", "Doe"),
            new Student(3, "Bob", "Smith"),
            new Student(2, "Jane", "Doe"),
            new Student(4, "Alice", "Smith")
        };
        
        // sort students by roll number using Comparable interface
        Arrays.sort(students);
        System.out.println("Student " + Arrays.toString(students));
        
        // sort students by first name using Comparator interface
        Arrays.sort(students, Student.FirstNameComparator);
        System.out.println("Student " + Arrays.toString(students));
    }
}

 class Student implements Comparable<Student> {
    private int rollNumber;
    private String firstName;
    private String lastName;
    
    public Student(int rollNumber, String firstName, String lastName) {
        this.rollNumber = rollNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public int getRollNumber() {
        return rollNumber;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    @Override
    public int compareTo(Student other) {
        return Integer.compare(rollNumber, other.rollNumber);
    }
    
    public static Comparator<Student> FirstNameComparator = 
        new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.firstName.compareTo(s2.firstName);
            }
        };
    public String toString() {
        return String.format(
            "Student[\n\trollNumber=%d,\n\tfirstName=%s,\n\tlastName=%s\n]",
            rollNumber, firstName, lastName
        );
    }
}