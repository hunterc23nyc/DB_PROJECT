public class Department {


   private String name;
   private int id;
   private static int counter = 1;


   public Department(String name){
       this.name = name;
       this.id =counter;
       counter++;
   }
  
   public int getId() {
       return id;
   }
  
   public String getName() {
       return name;
   }
  
   public String toString(){
       return "INSERT INTO department (department_name) VALUES ('" + name + "');";
   }
}
