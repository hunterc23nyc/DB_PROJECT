public class Student {
   private String studentFirst="";
   private String studentLast="";
   private int studentId;
   private static int count = 1;


   public Student(String studentFirst, String studentLast) {
       this.studentFirst = studentFirst;
       this.studentLast = studentLast;
       this.studentId = count;
       count++;
   }


   public int getstudentId() {
       return studentId;
   }


   public String toString() {
       return "INSERT INTO student (student_first, student_last) VALUES ('" + studentFirst + "', '" + studentLast + "');";
   }
}
