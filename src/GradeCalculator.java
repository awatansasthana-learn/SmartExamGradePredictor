public class GradeCalculator {

    public static String calculateGrade(double marks) {

        if (marks >= 90) {
            return "A+";
        } else if (marks >= 80) {
            return "A";
        } else if (marks >= 70) {
            return "B+";
        } else if (marks >= 60) {
            return "B";
        } else if (marks >= 50) {
            return "C";
        } else if (marks >= 40) {
            return "D";
        } else {
            return "F";
        }
    }

    public static int getGradePoint(String grade) {

        switch (grade) {

            case "A+":
                return 10;

            case "A":
                return 9;

            case "B+":
                return 8;

            case "B":
                return 7;

            case "C":
                return 6;

            case "D":
                return 5;

            default:
                return 0;
        }
    }
}