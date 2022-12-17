// Problem Statement

// Create a class named GradeExam to grade a multiple choice test.
// There are 20 students and 10 questions in the test.
// Each row records a student’s answers to the questions
// Grade the students according to their score in the test.

public class BP4 {
    public static final char getRandomGrade() {
        return (char)((int)(Math.random() * 5) + 'A');
    }

    public static void main(String[] args) {
        char[] keys = new char[] { 
            'D', 'B', 'D', 'C', 'C',
            'D', 'A', 'E', 'A', 'D'
        };
        
        char[][] students_answers = new char[10][];
        for(int i = 0; i < 10; i++) {
            students_answers[i] = new char[10];
            for(int j = 0; j < 10; j++) {
                students_answers[i][j] = getRandomGrade();
            }
        }

        int[] grades = GradeExam.gradeAll(
            students_answers,
            new GradeExam(keys)
        );

        for(int i = 0; i < grades.length; i++) {
            System.out.println("Student " + i + ": " + grades[i]);
        }
    }
}

class GradeExam {
    private char[] keys;

    GradeExam(char[] keys) {
        this.keys = keys;
    }

    public int grade(char[] answer) {
        int total = 0;
        for(int i = 0; i < keys.length; i++) {
            if (keys[i] == answer[i]) total += 1;
        }
        return total;
    }

    public static int[] gradeAll(char[][] answers, GradeExam Key) {
        int[] grade = new int[answers.length];
        for(int i = 0; i < grade.length; i++) {
            grade[i] = Key.grade(answers[i]);
        }
        return grade;
    }
}