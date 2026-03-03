package academic.driver;

/**
 * @author 12S24016 Boy Harendy Simamora
 */

import academic.model.Enrollment;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver3 {

    public static void main(String[] _args) {

          Scanner input = new Scanner(System.in);
        List<Enrollment> enrollmentList = new ArrayList<>();
        
    

        while (input.hasNextLine()) {
            String line = input.nextLine();

            if (line.equals("---")) {
                break; // Stop reading when "---" is encountered
            }

            // Simple validation: ensure the line is not empty and contains '#'
            if (line.isEmpty() || !line.contains("#")) {
                continue; 
            }

            String[] data = line.split("#");

            // Basic check for number of segments (4 for input, grade is default "None")
            if (data.length == 4) {
                String courseCode = data[0];
                String studentId = data[1];
                String academicYear = data[2];
                String semester = data[3];

                Enrollment enrollment = new Enrollment(courseCode, studentId, academicYear, semester);
                enrollmentList.add(enrollment);
            } else {
            }
        }

        if (enrollmentList.isEmpty()) {
        } else {
            for (Enrollment enrollment : enrollmentList) {
                System.out.println(enrollment); // Uses the overridden toString method
            }
        }

        input.close();
    }
}