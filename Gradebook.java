import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;

public class Gradebook {
   int[] assignments = new int[15];
   int studentId = -1;
   int offering_id = -1;

   public Gradebook (int studentId, int offering_id, int[] assignments) {
       for (int i = 0; i < assignments.length; i++) {
           this.assignments[i] = assignments[i];
       }
       this.studentId = studentId;
       this.offering_id = offering_id;
   }

   public int getStudentId(){
       return studentId;
   }

   public int getoffering_id(){
       return offering_id;
   }

   public String getList(){
       String list = "";
       for (int i = 0; i < 15; i++) {
           list += assignments[i];
           if (i != 14){
               list += ", ";
           }
       }
       return list;
   }

   public String toString(){
       return "INSERT INTO gradebook (studentId, offering_id, minor_1, minor_2, minor_3, minor_4, minor_5, minor_6, minor_7, minor_8, minor_9, minor_10, minor_11, minor_12, major_1, major_2, major_3) " +
               "VALUES (" + getStudentId() + ", " + getoffering_id() + ", " + getList() + ");";
   }
}
