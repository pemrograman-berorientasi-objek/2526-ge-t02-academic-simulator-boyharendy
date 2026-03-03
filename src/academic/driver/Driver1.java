/**
 * @author 12S24016 Boy Harendy Simamora
 */

package academic.driver;

import academic.model.Course;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Driver1 {

    public static void main(String[] _args) {

             Scanner input = new Scanner(System.in);
        List<Course> courseList = new ArrayList<>();
        

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

            // Basic check for number of segments
            if (data.length == 4) {
                try {
                    String code = data[0];
                    String name = data[1];
                    int credits = Integer.parseInt(data[2]);
                    String grade = data[3];

                    Course course = new Course(code, name, credits, grade);
                    courseList.add(course);
                } catch (NumberFormatException e) {
                }
            } else {
            }
        }

        if (courseList.isEmpty()) {

        } else {
            for (Course course : courseList) {
                System.out.println(course); // Uses the overridden toString method
            }
        }

        input.close();
    }
}