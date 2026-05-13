public class CourseOffering {
   private int offerId;
   private int courseId;
   private int roomId;
   private int period;
   private int teacherId;


   public int getOfferId() {
       return offerId;
   }


   public int getCourseId() {
       return courseId;
   }


   public int getRoomId() {
       return roomId;
   }


   public int getPeriod() {
       return period;
   }


   public int getTeacherId() {
       return teacherId;
   }


   public CourseOffering(int offer, int course, int room, int period, int teacher){
       offerId = offer;
       courseId = course;
       roomId = room;
       this.period = period;
       teacherId = teacher;
   }


   public String toString(){
       return "INSERT INTO course_offering (course_id, room_id, period, teacher_id) VALUES (" + courseId + ", " + roomId +", " + period + ", " + teacherId + ");";
   }


}
