public class GradePredictor {

    public static double calculatePredictedTotal(
            double internal,
            double midTerm,
            double expectedEndSemester) {

        return internal + midTerm + expectedEndSemester;
    }

    public static String predictGrade(
            double internal,
            double midTerm,
            double expectedEndSemester) {

        double total = calculatePredictedTotal(
                internal,
                midTerm,
                expectedEndSemester
        );

        return GradeCalculator.calculateGrade(total);
    }

    public static void displayPrediction(
            double internal,
            double midTerm,
            double expectedEndSemester) {

        double total = calculatePredictedTotal(
                internal,
                midTerm,
                expectedEndSemester
        );

        String grade = GradeCalculator.calculateGrade(total);

        System.out.println("\n========== GRADE PREDICTION ==========");

        System.out.printf(
                "Internal Marks       : %.2f / 40%n",
                internal
        );

        System.out.printf(
                "Mid-Term Marks       : %.2f / 30%n",
                midTerm
        );

        System.out.printf(
                "Expected End-Sem     : %.2f / 30%n",
                expectedEndSemester
        );

        System.out.printf(
                "Predicted Total      : %.2f / 100%n",
                total
        );

        System.out.println(
                "Predicted Grade      : " + grade
        );

        System.out.println("=======================================");
    }
}