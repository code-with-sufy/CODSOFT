import java.util.Scanner;
public class gradecalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int Subjects = sc.nextInt();

        int totalMarks = 0;

        for (int i = 1; i <= Subjects; i++) {
            System.out.print("Enter marks obtained in subject " + i + ": ");
            int marks = sc.nextInt();

            totalMarks += marks;
        }

        double avgPer = (double) totalMarks / Subjects;
        char grade = calculateGrade(avgPer);

        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", avgPer);
        System.out.println("Grade: " + grade);

        sc.close();
    }

    public static char calculateGrade(double avgPer) {
        if (avgPer >= 90) {
            return 'A';
        } else if (avgPer >= 75) {
            return 'B';
        } else if (avgPer >= 60) {
            return 'C';
        } else if (avgPer >= 45) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
