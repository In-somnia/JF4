package task5;

import java.util.List;


public class Student {
    private String name;
    private List<Disciplines> group;

    public Student(String name, List<Disciplines> group)
    {
        this.name = name;
        this.group = group;

    }

    List<Disciplines> getGroup()
    {
        return group;
    }

    public String getName()
    {
        return name;
    }
}
