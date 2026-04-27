import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Populate {

        public static void main(String[] args) {
            ArrayList<String> studentdata = getFileData("src/student");
            ArrayList<Student> Studentfile = new ArrayList<Student>();
            for (String stu : studentdata) {
                String[] words = stu.split("\\s+");
                Studentfile.add( new Student(words[0], words[1]) );

            }

            for ( Student s : Studentfile) {
                System.out.println(s);
            }
    }



public static ArrayList<String> getFileData(String fileName) {
    ArrayList<String> fileData = new ArrayList<String>();
    try {
        File f = new File(fileName);
        Scanner s = new Scanner(f);
        while (s.hasNextLine()) {
            String line = s.nextLine();
            if (!line.equals(""))
                fileData.add(line);
        }
        return fileData;
    }
    catch (FileNotFoundException e) {
        return fileData;
    }
}
}
