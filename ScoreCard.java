import java.util.InputMismatchException;
import java.util.Scanner;

public class ScoreCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input 
        System.out.println("Enter full name:");
        String fullName = sc.nextLine();

        System.out.println("Enter grade (class):");
        int studentGrade = 0;
        while (true) {
            try {
                studentGrade = sc.nextInt();
                if (studentGrade <= 0) {
                    System.out.println("Please enter a valid grade.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value for the grade.");
                sc.next(); // Clear invalid input
            }
        }

        System.out.println("Enter English Marks (0-100):");
        byte englishMarks = getValidMarks(sc);

        System.out.println("Enter Maths Marks (0-100):");
        byte mathsMarks = getValidMarks(sc);

        System.out.println("Enter Science Marks (0-100):");
        byte scienceMarks = getValidMarks(sc);

        // Calculation and Output section
        int totalMarks = englishMarks + mathsMarks + scienceMarks;
        float averageMarks = totalMarks / 3.0f;

        System.out.printf("Average Marks: %.2f\n", averageMarks);

        if (averageMarks > 65) {
            System.out.println("Pass with First Grade A");
        } else if (averageMarks > 45) {
            System.out.println("Pass with Second Grade B");
        } else if (averageMarks >= 35) {
            System.out.println("Pass with Third Grade C");
        } else {
            System.out.println("You have failed");
        }

        sc.close();
    }

    private static byte getValidMarks(Scanner sc) {
        byte marks = 0;
        while (true) {
            try {
                marks = sc.nextByte();
                if (marks < 0 || marks > 100) {
                    System.out.println("Please enter marks between 0 and 100.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numeric values for marks.");
                sc.next(); // Clear invalid input
            }
        }
        return marks;
    }
}
