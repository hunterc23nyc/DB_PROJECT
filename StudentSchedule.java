public class StudentSchedule {


   private int studentId = -1;
   private int[] schedule;


   public StudentSchedule(int studentId, int[] schedule ) {
       this.studentId = studentId;
       this.schedule=schedule;
   }


   public int[] getSchedule() {


       return schedule;
   }


   public int getStudentId() {
       return studentId;
   }


   public String toString() {
           return "INSERT INTO student_schedule (student_id, period_1, period_2, period_3, period_4, period_5, period_6, period_7, period_8, period_9, period_10) " +
                   "VALUES (" + studentId+ ", " + schedule[0] + ", " + schedule[1] + ", " + schedule[2] + ", " + schedule[3] + ", " + schedule[4] + ", " +
                   schedule[5] + ", " + schedule[6] + ", " + schedule[7] + ", " + schedule[8]  + ", " + schedule[9] +");";
   }
}

