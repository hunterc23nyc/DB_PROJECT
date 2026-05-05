public class StudentSchedule {

   private int studentId = -1;
   private int period1 = -1;
   private int period2 = -1;
   private int period3 = -1;
   private int period4 = -1;
   private int period5 = -1;
   private int period6 = -1;
   private int period7 = -1;
   private int period8 = -1;
   private int period9 = -1;
   private int period10 = -1;

   public StudentSchedule(int studentId, int period1, int period2, int period3, int period4,
                          int period5, int period6, int period7, int period8, int period9, int period10) {
       this.studentId = studentId;
       this.period1 = period1;
       this.period2 = period2;
       this.period3 = period3;
       this.period4 = period4;
       this.period5 = period5;
       this.period6 = period6;
       this.period7 = period7;
       this.period8 = period8;
       this.period9 = period9;
       this.period10 = period10;
   }

   public int[] getSchedule() {
       int[] list = {studentId, period1,  period2,  period3,  period4,
               period5, period6, period7, period8, period9, period10};
       return list;
   }

  public String toString() {
       return "INSERT INTO student_schedule (studentId, period_1, period_2, period_3, period_4, period_5, period_6, period_7, period_8, period_9, period_10) " +
               "VALUES (" + studentId + ", " + period1 + ", " + period2 + ", " + period3 + ", " + period4 + ", " + period5 + ", " +
               period6 + ", " + period7 + ", " + period8 + ", " + period9  + ", " + period10 +");";
  }
}

