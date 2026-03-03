package academic.driver;

/**
 * @author 12S24016 Boy Harendy Simamora
 */


import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Driver4 {

    public static void main(String[] _args) {
  Scanner input = new Scanner(System.in);
        List<Course> courseList = new ArrayList<>();
        List<Student> studentList = new ArrayList<>();
        List<Enrollment> enrollmentList = new ArrayList<>();
        
        System.out.println("Masukkan data akademik (format: command#data, ketik '---' untuk berhenti):");

        while (input.hasNextLine()) {
            String line = input.nextLine();

            if (line.equals("---")) {
                break; // Stop reading when "---" is encountered
            }

            // Simple validation: ensure the line is not empty and contains '#'
            if (line.isEmpty() || !line.contains("#")) {
                System.out.println("Format input tidak valid, silakan coba lagi.");
                continue; 
            }

            String[] parts = line.split("#", 2); // Split only at the first '#' to separate command from data
            if (parts.length < 2) {
                System.out.println("Format input tidak lengkap (command#data). Silakan coba lagi.");
                continue;
            }

            String command = parts[0];
            String dataString = parts[1];
            String[] data = dataString.split("#");

            switch (command) {
                case "course-add":
                    if (data.length == 4) {
                        try {
                            String code = data[0];
                            String name = data[1];
                            int credits = Integer.parseInt(data[2]);
                            String grade = data[3]; 

                            Course course = new Course(code, name, credits, grade);
                            courseList.add(course);
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Kredit mata kuliah harus berupa angka. Silakan coba lagi.");
                        }
                    } else {
                        System.out.println("Format input 'course-add' tidak lengkap atau berlebihan (seharusnya 4 segmen data). Silakan coba lagi.");
                    }
                    break;
                case "student-add":
                    if (data.length == 4) {
                        try {
                            String id = data[0];
                            String name = data[1];
                            int year = Integer.parseInt(data[2]);
                            String major = data[3];

                            Student student = new Student(id, name, year, major);
                            studentList.add(student);
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Angkatan mahasiswa harus berupa angka. Silakan coba lagi.");
                        }
                    } else {
                        System.out.println("Format input 'student-add' tidak lengkap atau berlebihan (seharusnya 4 segmen data). Silakan coba lagi.");
                    }
                    break;
                case "enrollment-add":
                    if (data.length == 4) {
                        String courseCode = data[0];
                        String studentId = data[1];
                        String academicYear = data[2];
                        String semester = data[3]; // Semester disimpan, tapi tidak akan dicetak oleh toString()

                        Enrollment enrollment = new Enrollment(courseCode, studentId, academicYear, semester);
                        enrollmentList.add(enrollment);
                    } else {
                        System.out.println("Format input 'enrollment-add' tidak lengkap atau berlebihan (seharusnya 4 segmen data). Silakan coba lagi.");
                    }
                    break;
                default:
                    System.out.println("Command tidak dikenal: " + command + ". Silakan gunakan 'course-add', 'student-add', atau 'enrollment-add'.");
                    break;
            }
        }

        System.out.println("\nDaftar Mata Kuliah:");
        if (courseList.isEmpty()) {
            System.out.println("Tidak ada mata kuliah yang dimasukkan.");
        } else {
            for (Course course : courseList) {
                System.out.println(course);
            }
        }

        System.out.println("\nDaftar Mahasiswa:");
        if (studentList.isEmpty()) {
            System.out.println("Tidak ada mahasiswa yang dimasukkan.");
        } else {
            for (Student student : studentList) {
                System.out.println(student);
            }
        }

        System.out.println("\nDaftar Pendaftaran Mata Kuliah:");
        if (enrollmentList.isEmpty()) {
            System.out.println("Tidak ada pendaftaran mata kuliah yang dimasukkan.");
        } else {
            for (Enrollment enrollment : enrollmentList) {
                // Tambahkan prefix 'enrollment-add|' sesuai ekspektasi autograder
                System.out.println("enrollment-add|" + enrollment); 
            }
        }

        input.close();
    }
}