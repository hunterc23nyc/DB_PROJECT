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
}
