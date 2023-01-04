import java.util.Scanner;


public class DP3 {
    public static void main(String[] args) {
        StudentRegistrationCheck.run();
    }
}

class StudentRegistrationCheck {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        int age = 0;
        int marks = 0;
        try {
            System.out.print("Enter student age: ");
            age = sc.nextInt();
            System.out.print("Enter student marks: ");
            marks = sc.nextInt();
            if (age < 12 || marks < 200) {
                throw new EligibilityException(
                    "Student is not eligible for registration"
                );
            }
            System.out.println("Student is eligible for registration");
        } catch (EligibilityException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
}

class EligibilityException extends Exception {
    public EligibilityException(String message) {
        super(message);
    }
}
