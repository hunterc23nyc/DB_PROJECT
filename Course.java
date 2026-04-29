import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Course {
    String courseName;
    String courseType;

    public Course(String courseName, String courseType) {
        this.courseName = courseName;
        this.courseType = courseType;
    }
    public String getCourseName(){
        return courseName;
    }
    public String getCourseType() {
        return courseType;
    }
    public String toString() {
        return "INSERT INTO course (course_name, course_type) VALUES ('" + courseName + "', '" + courseType + "');";
    }

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Course> courses = new ArrayList<Course>();
        try (Scanner scanner = new Scanner(new File("src/Courses.txt"))) {
            while (scanner.hasNextLine()) {
                String courseLine = scanner.nextLine();
                String[] parts = courseLine.split("\\|");
                courses.add(new Course(parts[0],parts[1]));
            }
        }
        for (int i = courses.size() - 1; i >= 0; i--) {
            System.out.println(courses.get(i).toString());
        }
    }
}
