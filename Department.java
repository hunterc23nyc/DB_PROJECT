public class Student {
    private String student_first="";

    private String student_last="";

    public Student(String student_first, String student_last) {
        this.student_first = student_first;
        this.student_last = student_last;
    }


    public String toString() {
        return "INSERT INTO student (student_first, student_last) VALUES ('" + student_first + "', '" + student_last + "');";
    }
}
