public class Teacher {
   private int id;
   private String first;
   private String last;
   private int depId;
   private static int count = 1;


   public Teacher( int depId, String first, String last){
       this.first=first;
       this.last=last;
       this.id=count;
       this.depId=depId;
       count++;
   }


   public String getFirst() {
       return first;
   }


   public int getId() {
       return id;
   }


   public int getDepId() {
       return depId;
   }


   public String getLast() {
       return last;
   }


   public String toString() {
       return "INSERT INTO teacher (teacher_first, teacher_last, department_id) VALUES ('" + first + "', '" + last + "', " + depId + ");";
   }
}
