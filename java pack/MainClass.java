
    import com.gla.college.faculty.Faculty;
    import com.gla.college.student.Student;


    public class MainClass {
        public static void main(String[] args) {

            // Create Student object
            Student s1 = new Student("Aman", 101);
            s1.displayStudent();

            System.out.println();

            // Create Faculty object
            Faculty f1 = new Faculty("Dr. Sharma", "Mathematics");
            f1.displayFaculty();
        }
    }

