import java.io.*;

public class HP3 {
    public static void main(String[] args) {
        try {
            Student[] students = {
                    new Student("Alice", 20, 85.5),
                    new Student("Bob", 22, 75.0),
                    new Student("Charlie", 18, 95.0)
            };

            FileOutputStream fileOut = new FileOutputStream("students.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            for (Student student : students) {
                out.writeObject(student);
            }

            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fileIn = new FileInputStream("students.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            Student student;
            while ((student = (Student) in.readObject()) != null) {
                System.out.println(student);
            }
            in.close();
            fileIn.close();
        } catch (EOFException e) {
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Student implements Serializable {
    // Declare a SerialVersionUID field
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private transient double grade;

    // Constructor
    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String toString() {
        return "name: " + name + ", " +
                "age: " + age + ", " +
                "grade: " + grade;
    }
}
