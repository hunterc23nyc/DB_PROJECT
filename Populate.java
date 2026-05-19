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

        // Tracking sets to completely block double-bookings
        Set<String> filledTeacherSlots = new HashSet<>();
        Set<String> filledRoomSlots = new HashSet<>();

        // Counter array to make sure no course ID is scheduled more than 5 times
        int[] courseSectionCounts = new int[93]; // Indexes 1 to 92

        // Step 1: Pre-populate all 92 required courses to guarantee they all get used
        ArrayList<Integer> coursePool = new ArrayList<>();
        for (int i = 1; i <= 92; i++) {
            coursePool.add(i);
        }

        // Shuffle the pool so the insertion order is completely random
        Collections.shuffle(coursePool);

        int nextOfferingId = 1;
        Random randomEngine = new Random();

        // Step 2: Loop through every single required course
        for (int courseID : coursePool) {

            // Loop until this specific course successfully gets scheduled 5 times
            while (courseSectionCounts[courseID] < 5) {

                // Generate random targets within your specific boundary constraints
                int period = randomEngine.nextInt(10) + 1;     // 1 to 10
                int roomID = randomEngine.nextInt(roomInfo.size()) + 1;    // 1 to total room
                int teacherID = randomEngine.nextInt(teacherInfo.size()) + 1; // 1 to total teacher

                // Create unique string signatures for the time slots
                String teacherTimeSlotKey = period + "-" + teacherID;
                String roomTimeSlotKey = period + "-" + roomID;

                // Step 3: Strict Conflict Validation
                // Only proceed if BOTH the teacher and room are completely free during this period
                if (!filledTeacherSlots.contains(teacherTimeSlotKey) && !filledRoomSlots.contains(roomTimeSlotKey)) {

                    // Claim the slots immediately so no future loop can steal them
                    filledTeacherSlots.add(teacherTimeSlotKey);
                    filledRoomSlots.add(roomTimeSlotKey);

                    // Increment the section counter for this course
                    courseSectionCounts[courseID]++;

                    // Build and save the clean offering
                    CourseOffering cleanOffering = new CourseOffering(nextOfferingId, courseID, roomID, period, teacherID);
                    offer.add(cleanOffering);

                    nextOfferingId++;
                }
            }
        }

        offer.sort(Comparator.comparing(CourseOffering::getPeriod));


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



        ArrayList<Gradebook> Gradebook_info = new ArrayList<Gradebook>();
        for (StudentSchedule s : StudentSchedule_info) {
            for(int i : s.getSchedule()) {
               Gradebook_info.add( new Gradebook(s.getstudentId(), i, randomList() ) );
            }
        }    


//        printInput(departmentInfo);
//        printInput(studentInfo);
//        printInput(roomInfo);
//        printInput(courseInfo);
//        printInput(teacherInfo);
//        printInput(offer);
//        printInput(studentInfo);
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
