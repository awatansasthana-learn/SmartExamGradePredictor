import java.util.ArrayList;

public class Student {

    private String name;
    private String rollNumber;

    private ArrayList<Subject> subjects;

    public Student(String name, String rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
        subjects = new ArrayList<>();
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public String getName() {
        return name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }
}