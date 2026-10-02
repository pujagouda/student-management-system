import java.util.ArrayList;
import java.util.Iterator;

public class StudentService {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void viewAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }

    }

    public void searchStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                System.out.println("Student Found:");
                System.out.println(student);
                return;
            }

        }
        System.out.println("Student not found");
    }

    public Student findStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void deleteStudent(int id) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getId() == id) {
                iterator.remove();
                System.out.println("Student deleted successfully");
                return;
            }
        }

        System.out.println("student not found ");
    }

    public void sortByMarks() {
        students.sort((s1, s2) -> Double.compare(s2.getMarks(), s1.getMarks()));
        System.out.println("Student sorted by marks");
        viewAllStudents();
    }

    public void findTopStudent() {
        Student topStudent = students.stream().max((s1, s2) -> Double.compare(s1.getMarks(), s2.getMarks()))
                .orElse(null);
        if (topStudent != null) {
            System.out.println("Top Student:");
            System.out.println(topStudent);

        } else {
            System.out.println("No students available");
        }
    }

    public boolean studentIdExists(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                System.out.println("Student is already exists");
                return true;
            }

        }
        return false;
    }
}









