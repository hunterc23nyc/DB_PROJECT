public class Room {
   private String room = "";


   public Room(String room) {
       this.room = room;
   }
  
   public String toString() {
       return "INSERT INTO room (room_name) VALUES ('" + room + "');";
   }
}
