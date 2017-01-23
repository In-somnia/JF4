package TestTask5;

import task5.Disciplines;
import task5.Group;
import task5.Student;
import task5.StudentGroups;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class ApplicationInterface extends StudentGroups {
    public ApplicationInterface(Disciplines name) {
        super(name);
    }
    public static void main(String[] args) {

        List<Disciplines> disciplineList1 = new ArrayList<>();
        disciplineList1.add(Disciplines.ЮРИСПРУДЕНЦИЯ);
        disciplineList1.add(Disciplines.ЭКОНОМИКА);

        List<Disciplines> disciplineList2 = new ArrayList<>();
        disciplineList2.add(Disciplines.ЮРИСПРУДЕНЦИЯ);
        disciplineList2.add(Disciplines.ЭКОНОМИКА);

        List<Disciplines> disciplineList3 = new ArrayList<>();
        disciplineList3.add(Disciplines.ЮРИСПРУДЕНЦИЯ);
        disciplineList3.add(Disciplines.МАТЕМАТИКА);
        disciplineList3.add(Disciplines.ФИЗИКА);

        List<Disciplines> disciplineList4 = new ArrayList<>();
        disciplineList4.add(Disciplines.ФИЗИКА);
        disciplineList4.add(Disciplines.ЛИТЕРАТУРА);

        List<Disciplines> disciplineList5 = new ArrayList<>();
        disciplineList5.add(Disciplines.ЛИНГВИСТИКА);
        disciplineList5.add(Disciplines.ЛИТЕРАТУРА);

        List<Disciplines> disciplineList6 = new ArrayList<>();
        disciplineList6.add(Disciplines.ЛИНГВИСТИКА);
        disciplineList6.add(Disciplines.МАТЕМАТИКА);

        List<Group> listOfGroups = new ArrayList<>();
        listOfGroups.add(new Group(Disciplines.ЮРИСПРУДЕНЦИЯ));
        listOfGroups.add(new Group(Disciplines.ФИЗИКА));
        listOfGroups.add(new Group(Disciplines.МАТЕМАТИКА));
        listOfGroups.add(new Group(Disciplines.ЛИНГВИСТИКА));
        listOfGroups.add(new Group(Disciplines.ЛИТЕРАТУРА));
        listOfGroups.add(new Group(Disciplines.ЭКОНОМИКА));

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Воронцов Сергей", disciplineList1));
        studentList.add(new Student("Ромашкина Светлана", disciplineList2));
        studentList.add(new Student("Картошкин Виктор", disciplineList3));
        studentList.add(new Student("Печенкина Карина", disciplineList4));
        studentList.add(new Student("Иванов Павел", disciplineList5));
        studentList.add(new Student("Петрова Евгения", disciplineList6));

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (Student y: studentList)
        {
            addStudentToGroup(y, listOfGroups);
        }
        System.out.println("Студенты добавлены в группы. Расставьте оценки студентам: ");
        listOfGroups.forEach(StudentGroups::assignMarksToStudents);

        while (true) {
            System.out.println("Выберите действие: ");
            System.out.println("1 - вывести оценки всех студентов");
            System.out.println("2 - вывести оценки студента по имени");
            System.out.println("0 - закрыть программу");
            try {
                String a = reader.readLine();
                switch(a)
                {
                    case "1":
                        checkAllMarks(studentList, listOfGroups);
                        break;
                    case "2":
                        chooseAStudent(studentList, listOfGroups);
                        break;
                    case "0":
                        return;
                    default:
                        break;

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
