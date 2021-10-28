package StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentRepo {
    private final Map<String, Student> studentsByName;

    public StudentRepo(){
        this.studentsByName = new HashMap<String, Student>();
    }

    public void add(Student student){
        studentsByName.putIfAbsent(student.getName(), student);
    }

    public Student get(String name){
        return studentsByName.get(name);
    }
}
