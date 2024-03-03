package Domain;

import java.util.Iterator;
import java.util.List;

/**
 * @author Пинжин Евгений Иванович
 */
public class StudentStreamIterator implements Iterator<StudentGroup> {
    private int counter;
    private final List<StudentGroup> students;
    
    public StudentStreamIterator(List<StudentGroup> students) {
        this.students = students;
        this.counter = 0;
    }

    // Student Stream
    @Override
    public boolean hasNext() {
       return counter<students.size();
    }
    @Override
    public StudentGroup next() {
        if(!hasNext())
        {
            return null;
        }
        //counter++;
        return students.get(counter++);        
    }
}
