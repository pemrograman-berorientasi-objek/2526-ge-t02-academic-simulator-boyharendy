package academic.driver;

/**
 * @author NIM Nama
 * @author NIM Nama
 */
import academic.model.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver2 {

    public static void main(String[] _args) {

         Scanner input = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();
        

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
                    String id = data[0];
                    String name = data[1];
                    int year = Integer.parseInt(data[2]);
                    String major = data[3];

                    Student student = new Student(id, name, year, major);
                    studentList.add(student);
                } catch (NumberFormatException e) {

                }
            } else {
            }
        }


        if (studentList.isEmpty()) {
        } else {
            for (Student student : studentList) {
                System.out.println(student); // Uses the overridden toString method
            }
        }

        input.close();

    }

}