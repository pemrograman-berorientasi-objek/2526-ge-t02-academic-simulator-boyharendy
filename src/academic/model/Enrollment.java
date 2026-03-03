/**
 * @author NIM Nama
 * @author NIM Nama
 */
package academic.model;
public class Enrollment {
    private String courseCode;
    private String studentId;
    private String academicYear;
    private String semester; // Tetap disimpan, tapi tidak ditampilkan di toString()
    private String grade; // Default ke "None" jika tidak ada nilai

    public Enrollment(String courseCode, String studentId, String academicYear, String semester) {
        this.courseCode = courseCode;
        this.studentId = studentId;
        this.academicYear = academicYear;
        this.semester = semester;
        this.grade = "None"; // Default grade as per output example
    }

    // Constructor with grade, if needed for future modifications
    public Enrollment(String courseCode, String studentId, String academicYear, String semester, String grade) {
        this.courseCode = courseCode;
        this.studentId = studentId;
        this.academicYear = academicYear;
        this.semester = semester;
        this.grade = grade;
    }

    // Getters for all fields
    public String getCourseCode() {
        return courseCode;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public String getSemester() {
        return semester;
    }

    public String getGrade() {
        return grade;
    }

    // Setter for grade, if grade can be updated later
    public void setGrade(String grade) {
        this.grade = grade;
    }

    // toString method for desired output format (modifikasi untuk mengabaikan semester)
    @Override
    public String toString() {
        // Output format requires courseCode|studentId|academicYear|None (grade)
        // The 'semester' from input is not included in the output string representation.
        return courseCode + "|" + studentId + "|" + academicYear + "|" + grade;
    }
}