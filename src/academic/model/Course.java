package academic.model;

public class Course {
    private String code;
    private String name;
    private int credits;
    private String grade; // Assuming grade is part of the course data as per input example

    public Course(String code, String name, int credits, String grade) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.grade = grade;
    }

    // Getters for all fields
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public String getGrade() {
        return grade;
    }

    // toString method for desired output format
    @Override
    public String toString() {
        return code + "|" + name + "|" + credits + "|" + grade;
    }
}