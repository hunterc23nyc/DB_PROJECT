public class Teacher {
   private int id;
   private String first;
   private String last;
   private int depId;

   public Teacher( int depId, String first, String last){
       this.first=first;
       this.last=last;
       this.depId=depId;
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
