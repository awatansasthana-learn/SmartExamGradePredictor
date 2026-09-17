import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    public static void saveReport(Student student) {

        String fileName = "GradeReport_" + student.getRollNumber() + ".txt";

        try {
            FileWriter writer = new FileWriter(fileName);

            writer.write("====================================\n");
            writer.write("       EXAM GRADE REPORT\n");
            writer.write("====================================\n");

            writer.write("Student Name: " + student.getName() + "\n");
            writer.write("Roll Number: " + student.getRollNumber() + "\n\n");

            for (Subject subject : student.getSubjects()) {

                double marks = subject.getTotalMarks();
                String grade = GradeCalculator.calculateGrade(marks);

                writer.write(
                    subject.getName() + " : " + marks + " : " + grade + "\n"
                );
            }

            writer.write("\n====================================\n");

            writer.close();

            System.out.println(
                "\nReport saved successfully as " + fileName
            );

        } catch (IOException e) {

            System.out.println("Error while saving report.");
        }
    }
}