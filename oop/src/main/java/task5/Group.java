package task5;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group {
    private Disciplines name;
    private Map<Student, Mark> studentsAndMarks = new HashMap<>();
    List<Student> students = new ArrayList<>();

    public Group(Disciplines name)
    {
        this.name = name;
    }

    public Disciplines getName()
    {
        return name;
    }

    Map<Student, Mark> getStudentsAndMarks()
    {
        return studentsAndMarks;
    }

    void setStudentsAndMarks(Student student, Mark mark)
    {
        this.studentsAndMarks.put(student, mark);
    }



}
