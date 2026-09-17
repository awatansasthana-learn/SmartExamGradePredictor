public class Subject {

    private String name;
    private double internalMarks;
    private double midTermMarks;
    private double endSemesterMarks;

    public Subject(String name, double internalMarks,
                   double midTermMarks, double endSemesterMarks) {

        this.name = name;
        this.internalMarks = internalMarks;
        this.midTermMarks = midTermMarks;
        this.endSemesterMarks = endSemesterMarks;
    }

    public String getName() {
        return name;
    }

    public double getInternalMarks() {
        return internalMarks;
    }

    public double getMidTermMarks() {
        return midTermMarks;
    }

    public double getEndSemesterMarks() {
        return endSemesterMarks;
    }

    public double getTotalMarks() {
        return internalMarks + midTermMarks + endSemesterMarks;
    }

    public double getPercentage() {
        return getTotalMarks();
    }
}