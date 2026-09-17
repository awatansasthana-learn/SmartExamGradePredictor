import java.util.ArrayList;

public class PerformanceAnalyzer {

    public static void generateReport(Student student) {

        ArrayList<Subject> subjects = student.getSubjects();

        if (subjects.isEmpty()) {
            System.out.println("No subjects added.");
            return;
        }

        double totalMarks = 0;
        double highest = -1;
        double lowest = 101;

        String highestSubject = "";
        String lowestSubject = "";

        System.out.println("\n==============================================");
        System.out.println("           PERFORMANCE REPORT");
        System.out.println("==============================================");

        System.out.println("Student Name : " + student.getName());
        System.out.println("Roll Number  : " + student.getRollNumber());

        System.out.println("----------------------------------------------");

        System.out.printf("%-20s %-10s %-10s%n",
                "Subject", "Marks", "Grade");

        System.out.println("----------------------------------------------");

        for (Subject subject : subjects) {

            double marks = subject.getTotalMarks();

            String grade = GradeCalculator.calculateGrade(marks);

            totalMarks += marks;

            if (marks > highest) {
                highest = marks;
                highestSubject = subject.getName();
            }

            if (marks < lowest) {
                lowest = marks;
                lowestSubject = subject.getName();
            }

            System.out.printf("%-20s %-10.2f %-10s%n",
                    subject.getName(),
                    marks,
                    grade);
        }

        double average = totalMarks / subjects.size();

        String overallGrade =
                GradeCalculator.calculateGrade(average);

        System.out.println("----------------------------------------------");

        System.out.printf("Average Marks : %.2f%n", average);
        System.out.println("Overall Grade : " + overallGrade);

        System.out.printf("Highest       : %.2f (%s)%n",
                highest, highestSubject);

        System.out.printf("Lowest        : %.2f (%s)%n",
                lowest, lowestSubject);

        System.out.println("==============================================");
    }
}