import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.*;


public class Populate {


   public static void main(String[] args) throws FileNotFoundException{
//        PrintStream fileStream = new PrintStream("src/insert");
//        System.setOut(fileStream);


       ArrayList<String> rawTeacher = getFileData("src/teacher");
       ArrayList<Teacher> teacherInfo = new ArrayList<Teacher>();
       for (String tea: rawTeacher) {
           String[] words = tea.split("\\s+", 3);
           teacherInfo.add((new Teacher(Integer.parseInt(words[0]), words[1], words[2])));
       }


       ArrayList<String> rawCourse = getFileData("src/Courses.txt");
       ArrayList<Course> courseInfo = new ArrayList<Course>();
       for (String cou: rawCourse) {
           String[] words = cou.split("\\|");
           courseInfo.add( new Course(words[0], words[1]));
       }


       ArrayList<String> rawDepartment = getFileData("src/department");
       ArrayList<Department> departmentInfo = new ArrayList<Department>();
       for (String dep: rawDepartment) {
           departmentInfo.add(new Department(dep));
       }


       ArrayList<String> rawStudent = getFileData("src/student");
       ArrayList<Student> studentInfo = new ArrayList<Student>();
       for (String stu : rawStudent) {
           String[] words = stu.split("\\s+");
           studentInfo.add(new Student(words[0], words[1]));
       }


       ArrayList<String> rawRoom = getFileData("src/room");
       ArrayList<Room> roomInfo = new ArrayList<Room>();
       for (String roo : rawRoom) {
           roomInfo.add(new Room(roo));
       }






       ArrayList<CourseOffering> offer = new ArrayList<>();


       Random rand = new Random();
       int courseSize = courseInfo.size();
       int[] courseCount = new int[courseSize];
       HashSet<Integer> usedCourses = new HashSet<>();
       int id = 1;




       while (usedCourses.size() < courseSize) {


           int courseID = rand.nextInt(courseSize-1) + 1;




           if (courseCount[courseID] >= 5) {
               continue;
           }




           boolean valid = false;




           while (!valid) {




               int period = rand.nextInt(10) + 1;
               int roomID = rand.nextInt(roomInfo.size()) + 1;
               int teacherID = rand.nextInt(teacherInfo.size()) + 1;




               valid = true;




               for (CourseOffering co : offer) {




                   if (co.getPeriod() == period) {




                       if (co.getRoomId() == roomID) {
                           valid = false;
                           break;
                       }




                       if (co.getTeacherId() == teacherID) {
                           valid = false;
                           break;
                       }
                   }
               }




               if (valid) {




                   CourseOffering newOffer =
                           new CourseOffering(id, courseID, roomID, period, teacherID);




                   offer.add(newOffer);




                   courseCount[courseID]++;
                   usedCourses.add(courseID);




                   id++;
               }
           }
       }


//        offer.sort(Comparator.comparing(CourseOffering::getPeriod));




       ArrayList<StudentSchedule> studentScheduleInfo = new ArrayList<StudentSchedule>();
       for (Student s : studentInfo) {
           int[] schedule = new int[10];
           for (int i = 0; i <10; i++) {
               while (schedule[i]==0) {
                   int random = (int) (Math.random() * offer.size()) + 1;
                   if (offer.get(random - 1).getPeriod() == i+1) {
                       schedule[i] = random;
                   }
               }
           }
       studentScheduleInfo.add(new StudentSchedule(s.getStudent_id(), schedule ));
       }






       ArrayList<Gradebook> gradebookInfo = new ArrayList<Gradebook>();
       for (StudentSchedule s : studentScheduleInfo) {
           for(int i : s.getSchedule()) {
               gradebookInfo.add( new Gradebook(s.getStudentId(), i, randomList() ) );
           }
       }


//        printInput(departmentInfo);
//        printInput(studentInfo);
//        printInput(roomInfo);
//        printInput(courseInfo);
//        printInput(teacherInfo);
       printInput(offer);
//        printInput(studentScheduleInfo);
//        printInput(gradebookInfo);
   }


   public static ArrayList<String> getFileData(String fileName) {
       ArrayList<String> fileData = new ArrayList<String>();
       try {
           File f = new File(fileName);
           Scanner s = new Scanner(f);
           while (s.hasNextLine()) {
               String line = s.nextLine();
               if (!line.equals(""))
                   fileData.add(line);
           }
           return fileData;
       } catch (FileNotFoundException e) {
           return fileData;
       }
   }


   public static void printInput(ArrayList<?> list) {
       for (Object item : list) {
           System.out.println(item);
       }
   }


   public static int[] randomList() {
       int[] numbers = new int[15];
       for (int i = 0; i < 15; i++) {
           numbers[i] = (int) (Math.random() * (26)) + 75;
       }
       return numbers;
   }
}



