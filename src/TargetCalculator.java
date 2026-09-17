public class TargetCalculator {

    public static double getRequiredMarks(
            double internal,
            double midTerm,
            String targetGrade) {

        double targetMarks;

        switch (targetGrade.toUpperCase()) {

            case "A+":
                targetMarks = 90;
                break;

            case "A":
                targetMarks = 80;
                break;

            case "B+":
                targetMarks = 70;
                break;

            case "B":
                targetMarks = 60;
                break;

            case "C":
                targetMarks = 50;
                break;

            case "D":
                targetMarks = 40;
                break;

            default:
                return -1;
        }

        double required = targetMarks - internal - midTerm;

        if (required < 0) {
            return 0;
        }

        return required;
    }

    public static void displayTargetCalculation(
            double internal,
            double midTerm,
            String targetGrade) {

        double required = getRequiredMarks(
                internal,
                midTerm,
                targetGrade
        );

        if (required == -1) {
            System.out.println("Invalid grade.");
            return;
        }

        System.out.println("\n========== TARGET CALCULATOR ==========");

        System.out.printf(
                "Current Internal : %.2f / 40%n",
                internal
        );

        System.out.printf(
                "Current Mid-Term : %.2f / 30%n",
                midTerm
        );

        System.out.println(
                "Target Grade     : " + targetGrade
        );

        if (required <= 30) {

            System.out.printf(
                    "Required End-Sem : %.2f / 30%n",
                    required
            );

        } else {

            System.out.println(
                    "Target grade is not achievable with the current marks."
            );
        }

        System.out.println("=======================================");
    }
}