package Domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Пинжин Евгений Иванович
 * @version 1.2
 * @apiNote Поток студентов - Класс в котором хронятся группы, тоесть классы StudentsGroup
  */
public class StudentStream implements Iterable<StudentGroup> {
    private static Integer numberStream = 34;
    private List<StudentGroup> groupStream = new ArrayList<StudentGroup>();


    public StudentStream(List<StudentGroup> groupStream) {
        this.groupStream = groupStream;
    }

    public List<StudentGroup> getGroupStream() {
        return groupStream;
    }


    private List<Student> OneGroup(StudentGroup group){
        List<Student> listStudents = new ArrayList<Student>();
        for (int i = 0; i < group.getSize(); i++) {
            listStudents.add(group.getGroup().get(i));
        }
        return listStudents;
    }

    private Integer getSizeOfStream(){
        List<Student> group = new ArrayList<Student>();
        Integer number = 0;
        for (int i = 0; i < groupStream.size(); i++) {
            group = OneGroup(groupStream.get(i));
            for (int j = 0; j < group.size(); j++) {
                number++;
            }  
        }
        return number;
    }

    
    private StringBuilder listOfStudents(){
        List<Student> group = new ArrayList<Student>();
        StringBuilder listAllStudens = new StringBuilder();
        Integer numberGroup = 0;

        for (int i = 0; i < groupStream.size(); i++) {
            group = OneGroup(groupStream.get(i));
            numberGroup = groupStream.get(i).getIdGroup();
            for (int j = 0; j < group.size(); j++) {
               listAllStudens.append("---/---" + group.get(j).toString() + " Group=" + numberGroup);
            }  
        }
        return listAllStudens;
    }

    @Override
    public Iterator<StudentGroup> iterator() {
        return new StudentStreamIterator(groupStream);
    }

    @Override
    public String toString() {
        return 
        "Номер потока: " + numberStream 
        + "\nКлоичество групп: " + groupStream.size()
        + "\nКоличество студентов в потоке: " + getSizeOfStream()
        + "\nСписок студентов:\n" + listOfStudents();
    }
}
