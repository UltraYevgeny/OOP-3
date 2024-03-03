import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Domain.Student;
import Domain.StudentGroup;
import Domain.StudentStream;

public class App {
    public static void main(String[] args) throws Exception {
        
        Student s1 = new Student("Иван", 25);
        Student s2 = new Student("Игорь", 23);
        Student s3 = new Student("Иван", 22);
        Student s4 = new Student("Игорь",  23);
        Student s5 = new Student("Даша",  23);
        Student s6 = new Student("Лена",  23);

        List<Student> listStud = new ArrayList<Student>();
        listStud.add(s1);
        listStud.add(s2);
        listStud.add(s3);
        listStud.add(s4);
        listStud.add(s5);
        listStud.add(s6);

        List<Student> listStud02 = new ArrayList<Student>();
        listStud02.add(s1);
        listStud02.add(s2);
        
        List<Student> listStud03 = new ArrayList<Student>();
        listStud03.add(s1);
        listStud03.add(s5);
        listStud03.add(s3);

        StudentGroup group4580 = new StudentGroup(listStud, 4580);
        StudentGroup group2277 = new StudentGroup(listStud02, 2277);
        StudentGroup group3344 = new StudentGroup(listStud03, 3344);

        ArrayList<StudentGroup> listStream = new ArrayList<StudentGroup>();
        listStream.add(group4580);
        listStream.add(group2277);
        listStream.add(group3344);

        StudentStream streamOfGroup = new StudentStream(listStream);
        
        
        System.out.println(group4580);

        for(Student std : group4580){
            System.out.println(std);
        }

        System.out.println("=========================================================");

        Collections.sort(group4580.getGroup());
        for(Student std: group4580.getGroup()){
            System.out.println(std);
        }

        // Вывод потока на консоль
        System.out.println("\n --------------Вывод потока---------------- \n");
        System.out.println(streamOfGroup);
        System.out.println(" \n--------------Вывод потока через for---------------- ");
        for(StudentGroup stream: streamOfGroup)
        {
            System.out.println("\n" + stream);
        }
        
        System.out.println("\n --------------Вывод потока через for отсартированного---------------- \n");
        
        Collections.sort(streamOfGroup.getGroupStream());
        for(StudentGroup stream: streamOfGroup.getGroupStream())
        {
            System.out.println(stream);
        }

    }
}
