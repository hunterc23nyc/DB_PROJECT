public class Student {
   private String studentFirst="";
   private String studentLast="";


   public Student(String studentFirst, String studentLast) {
       this.studentFirst = studentFirst;
       this.studentLast = studentLast;
   }
  
   public String toString() {
       return "INSERT INTO student (student_first, student_last) VALUES ('" + studentFirst + "', '" + studentLast + "');";
   }
}
