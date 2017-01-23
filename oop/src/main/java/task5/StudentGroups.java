package task5;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;


public class StudentGroups extends Group {
    public StudentGroups(Disciplines name) {
        super(name);
    }

    protected static void checkAllMarks(List<Student> studentList, List<Group> listOfGroups)
    {
        for(Student a : studentList)
        {
            checkMarks(a, listOfGroups);
        }
    }
    protected static void chooseAStudent(List<Student> studentList, List<Group> listOfGroups )
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите имя и фамилию студента, оценки которого необходимо узнать: ");
        try {
            String studentName = reader.readLine();
            for (int i = 0; i < studentList.size(); i++)
            {
                    String currentName = studentList.get(i).getName();
                    Student currentStudent = studentList.get(i);
                    if(currentName.equals(studentName))
                    {
                        checkMarks(currentStudent, listOfGroups);
                    }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected static void addStudentToGroup(Student student, List<Group> listOfGroups)
    {

        for (int i = 0; i < student.getGroup().size(); i++)
        {
            Disciplines a = student.getGroup().get(i);

            for (int j = 0; j < listOfGroups.size(); j++)
            {
                Disciplines b = listOfGroups.get(j).getName();

                if (a == b)
                {
                    listOfGroups.get(j).students.add(student);
                }
            }
        }
    }
    protected static void assignMarksToStudents(Group group)
    {
        if (Disciplines.valueOf(group.getName().toString()).isInteger) {

            for (int i = 0; i < group.students.size(); i++) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                try {

                    System.out.println("Введите оценку по " + group.getName() + " студента" + group.students.get(i).getName()
                            + "(целое число от 1 до 5)");
                    int mark1 = Integer.parseInt(reader.readLine());
                    Mark<Integer> mark = new Mark<>(mark1);
                    group.setStudentsAndMarks(group.students.get(i), mark);


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
            else
            {
                for (int i = 0; i < group.students.size(); i++) {

                BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));

                try {
                    System.out.println("Введите оценку по " + group.getName() + " студента" + group.students.get(i).getName()
                            + "(дробное число от 1 до 5)");
                    double mark1 = Double.parseDouble(reader1.readLine());
                    Mark<Double> mark = new Mark<>(mark1);
                    group.setStudentsAndMarks(group.students.get(i), mark);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void checkMarks(Student student, List<Group> listOfGroups)
    {
        for (int i = 0; i < listOfGroups.size(); i++)
        {
            listOfGroups.get(i).getStudentsAndMarks();
            for (Map.Entry<Student, Mark> pair : listOfGroups.get(i).getStudentsAndMarks().entrySet())
            {
                if (pair.getKey().getName().equals(student.getName()))
                {
                    System.out.println("Оценка студента " + student.getName() + " по предмету " + listOfGroups.get(i).getName() + " : " + pair.getValue().getValue());
                }
            }
        }
    }
}
