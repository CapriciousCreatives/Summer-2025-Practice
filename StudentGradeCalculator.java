/* May 15th, 2025
 * First time touching Visual Studio Code and Java in over a year, so this is my 1st practice program to familiarize myself with the tools again. I'll be uploading my review process with programming onto GitHub for bookkeeping.
 * This program organizes students by name and grade utilizing two arrays, one with String for name, one with double for score. It then uses simple operations to calculate a class average.
 * This review was designed by ChatGPT, OpenAI, 2025. The initial code and idea was provided by ChatGPT, and I challenged myself by adding onto it with an if-else-if ladder and then a switch case and a helper method.
 * Within this file, unless marked as original, the code was written by AI and not my own work.
 */
import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int studentCount = input.nextInt();

        String[] names = new String[studentCount];
        double[] scores = new double[studentCount];
        String[] letterGrade = new String[studentCount]; //I added this new variable as practice

        for (int i = 0; i < studentCount; i++) {
            System.out.print("Enter name of student " + (i + 1) + ": ");
            names[i] = input.next();

            System.out.print("Enter score for " + names[i] + ": ");
            scores[i] = input.nextDouble();
            
        //     if (scores[i] >= 90){           //This if-else-if ladder is my own work. (not proud)
        //         letterGrade[i] = "A";
        //     } else if (scores[i] >= 80){
        //         letterGrade[i] = "B";
        //     } else if (scores[i] >= 70){
        //         letterGrade[i] = "C";
        //     } else if (scores[i] >= 60){
        //         letterGrade[i] = "D";
        //     } else {
        //         letterGrade[i] = "F";
        //     }
        // }

            letterGrade[i] = getLetterGrade(scores[i]); //Throws double scrores[i] to getter method and returns with a String letterGrade
        }

        System.out.println("\n--- Grade Report ---");
        for (int i = 0; i < studentCount; i++) {
            System.out.print(names[i] + ": " + scores[i]);
            System.out.println(", Letter Grade: " + letterGrade[i]); //This corresponds to the new variable above
        }

        // Calculate average
        double total = 0;
        for (double score : scores) {
            total += score;
        }
        double average = total / studentCount;
        System.out.println("Class Average: " + average);

        input.close();
    }
    //Practicing with using a getter method
    public static String getLetterGrade(double score) {
        String letterGrade;
            if (score < 0) {
                letterGrade = "???";
            }else if (score >= 90){           //This if-else-if ladder is my own work. (not proud)
                letterGrade = "A";
            } else if (score >= 80){
                letterGrade = "B";
            } else if (score >= 70){
                letterGrade = "C";
            } else if (score >= 60){
                letterGrade = "D";
            } else {
                letterGrade = "F";
            }

        //Now attempting to do the same with a Switch Case; yes, I'm aware how redundant and inefficient this is.
        switch (letterGrade) {
            case "A":
                return "A (Excellent)";
            case "B":
                return "B (Good)";
            case "C":
                return "C (Satisfactory)";
            case "D":
                return "D (Pass w/ No Credit)";
            case "F":
                return "F (Fail)";
            default:
                return "Invalid Score";
        }
    }
}
