public class Department {
   public int getId() {
       return id;
   }

   public String getName() {
       return name;
   }
	
   private String name;
   private int id;

   public Department(String name){
       this.name = name;
       this.id =id;
   }

   public String toString(){
       return "INSERT INTO department (department_name) VALUES ('" + name + "');";
   }
}
