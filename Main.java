import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
        StudentService service=new StudentService();

       Scanner sc=new Scanner(System.in);
     int choice;
       do{
           System.out.println("============================");
           System.out.println(" STUDENT MANAGEMENT SYSTEM ");
           System.out.println("=============================");
           System.out.println("1.Add Student");
           System.out.println("2.View All Student");
           System.out.println("3.Search Student");
           System.out.println("4.Update Student");
           System.out.println("5.Delete Student");
           System.out.println("6.Sort by Marks");
           System.out.println("7.Find Top Student");
           System.out.println("8.Exit");
           System.out.println("Enter your choice:");
           choice= sc.nextInt();

           switch (choice){
               case 1:

                   System.out.println("Enter your ID: ");
                   int id=sc.nextInt();
                   if (service.studentIdExists(id)){
                       break;
                   }
                   sc.nextLine();
                   System.out.println("Enter your Name: ");
                   String name=sc.nextLine();
                   int age;
                   while (true){
                       System.out.println("Enter your Age: ");
                       age=sc.nextInt();

                       if(age>=15 && age<=100){
                           break;
                       }
                       System.out.println("Age is must between 15 and 100");
                   }
                   sc.nextLine();

                   System.out.println("Enter your Course: ");
                   String course=sc.nextLine();
                   double marks;
                   while (true){
                       System.out.println("Enter your Marks: ");
                        marks=sc.nextDouble();
                       if(marks>0 && marks<=100){
                           break;
                       }
                       System.out.println("Marks must between 0 to 100");
                   }

                   Student student=new Student(id,name,age,course,marks);
                   service.addStudent(student);
                   System.out.println("student added successfully");

                   break;
               case 2:
                   service.viewAllStudents();
                   break;
               case 3:
                   System.out.println("Enter Student ID to search: ");
                   int searchId=sc.nextInt();
                   service.searchStudent(searchId);
                   break;
               case 4:
                   System.out.println("Enter Student ID to update:");
                   int updateId=sc.nextInt();
                   sc.nextLine();
                   Student studentToUpdate=service.findStudent(updateId);
                   if(studentToUpdate!=null) {
                       System.out.println("Enter New Name: ");
                       String newName = sc.nextLine();
                       System.out.println("Enter New Age:");
                       int newAge = sc.nextInt();
                       sc.nextLine();
                       while (newAge< 15||newAge>100){
                           System.out.println("Age must be between 15 and 100");
                           System.out.println("Enter New Age:");
                           newAge=sc.nextInt();
                           sc.nextLine();
                       }
                       System.out.println("Enter new Course:");
                       String newCourse = sc.nextLine();
                       System.out.println("Enter new Mark:");
                      double newMark = sc.nextDouble();

                      while (newMark <0||newMark> 100){
                          System.out.println("Mark Must be Between 0 to 100");
                          System.out.println("Enter your new mark");
                          newMark=sc.nextDouble();
                      }

                       studentToUpdate.setName(newName);
                       studentToUpdate.setAge(newAge);

                       studentToUpdate.setCourse(newCourse);
                       studentToUpdate.setMarks(newMark);
                       System.out.println("Student Updated Successfully");
                   }
                   else {
                       System.out.println("Student not found");
                   }
                       break;
               case 5:
                   System.out.println("Enter Student ID to delete");
                   int deleteId=sc.nextInt();
                   service.deleteStudent(deleteId);
                   break;
               case 6:
                   service.sortByMarks();
                   break;
               case 7:
                   service.findTopStudent();
                   break;
               case 8:
                   System.out.println("Thank You For Using System!");
                   break;
               default:
                   System.out.println("Invalid choice");

           }

       }while (choice!=8);
sc.close();
    }
}
