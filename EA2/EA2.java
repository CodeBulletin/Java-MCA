import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class EA2 {
    private static Map<Integer, Student> students = new TreeMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Menu:\n" + 
                "1. Add student\n" + 
                "2. Retrieve student\n" + 
                "3. Update student\n" + 
                "4. Remove student\n" + 
                "5. Sort and copy students\n" + 
                "6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    retrieveStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    removeStudent();
                    break;
                case 5:
                    sortAndCopyStudents();
                    break;
                case 6:
                    isRunning = false;
                    break;
            }
        }
        sc.close();
    }

    private static void addStudent() {
        System.out.print("Enter student id: ");
        int id = sc.nextInt();
        System.out.print("Enter student name: ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.print("Enter student course: ");
        String course = sc.nextLine();
        students.put(id, new Student(id, name, course));
        System.out.println("Student added successfully.");
    }

    private static void retrieveStudent() {
        System.out.print("Enter student id: ");
        int id = sc.nextInt();
        Student student = students.get(id);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void updateStudent() {
        System.out.print("Enter student id: ");
        int id = sc.nextInt();
        Student student = students.get(id);
        if (student != null) {
            System.out.print("Enter new student name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Enter new student course: ");
            String course = sc.nextLine();
            students.put(id, new Student(id, name, course));
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }
    
    private static void removeStudent() {
        System.out.print("Enter student id: ");
        int id = sc.nextInt();
        Student student = students.remove(id);
        if (student != null) {
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }
    
    private static void sortAndCopyStudents() {
        Map<Integer, Student> sortedStudents = new TreeMap<>(students);
        System.out.println("Sorted and copied students:");
        for (Student student : sortedStudents.values()) {
            System.out.println(student);
        }
    }    
}       

class Student {
    private int stuId;
    private String stuName;
    private String stuCourse;

    public Student(int stuId, String stuName, String stuCourse) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuCourse = stuCourse;
    }

    public int getStuId() {
        return stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public String getStuCourse() {
        return stuCourse;
    }

    @Override
    public String toString() {
        return 
            "Student [stuId=" +
            stuId + ", stuName=" +
            stuName + ", stuCourse=" +
            stuCourse + "]";
    }
}
