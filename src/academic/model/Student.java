package academic.model;

/**
 * @author 12S24016
 */

public class Student {

    private String id; // NIM
    private String name;
    private int year; // Angkatan
    private String major; // Program Studi

    public Student(String id, String name, int year, String major) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.major = major;
    }

    // Getters for all fields
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getMajor() {
        return major;
    }

    // toString method for desired output format
    @Override
    public String toString() {
        return id + "|" + name + "|" + year + "|" + major;
    }
}