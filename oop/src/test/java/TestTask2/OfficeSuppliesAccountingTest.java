package TestTask2;


import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import task2.Staff;
import task2.StaffList;
import java.io.*;
import java.util.List;


public class OfficeSuppliesAccountingTest {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            StaffList.employees.add(new Staff("Ivanov Sergey", "Manager"));
            StaffList.employees.add(new Staff("Petrov Alexey", "Advertisment manager"));
            StaffList.employees.add(new Staff("Sidorov Pavel", "Content manager"));
            StaffList.employees.add(new Staff("Zaitseva Elena", "Secretary"));
            StaffList.employees.add(new Staff("Liubimov Alexey", "Translator"));
            StaffList.employees.add(new Staff("Muravyova Regina", "Sales manager"));
            StaffList.employees.add(new Staff("Stepanov Nikolay", "HR"));
            StaffList.employees.add(new Staff("Melnikova Marina", "Quality director"));
            StaffList.employees.add(new Staff("Sidorova Vera", "Technical writer"));
            StaffList.employees.add(new Staff("Petrova Irina", "Editor"));
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println("Выберите действие: ");
                System.out.println("1 - добавить канцтовары сотруднику");
                System.out.println("2 - посчитать стоимость всех канцтоваров сотрудника");
                System.out.println("0 - закрыть программу");
                String a = reader.readLine();
                switch (a) {
                    case "1":
                        System.out.println("Введите имя сотрудника, которому необходимо добавить канцтовары:");
                        String name = reader.readLine();
                        System.out.println("Введите должность сотрудника:");
                        String jobPosition = reader.readLine();
                        System.out.println("Введите тип канцтоваров:");
                        String type = reader.readLine();
                        System.out.println("Введите количество:");
                        int quantity = Integer.parseInt(reader.readLine());
                        System.out.println("Введите цену за единицу товара:");
                        int price = Integer.parseInt(reader.readLine());
                        Staff currentEmployee = getEmployeeByNameAndPosition(name, jobPosition, StaffList.employees);
                        currentEmployee.addOfficeSupplies(currentEmployee, type, quantity, price, StaffList.employees);
                        break;
                    case "2":
                        System.out.println("Введите имя сотрудника, общую сумму канцтоваров которого необходимо получить:");
                        String name2 = reader.readLine();
                        System.out.println("Введите должность сотрудника:");
                        String jobPosition2 = reader.readLine();
                        Staff currentEmployee2 = getEmployeeByNameAndPosition(name2, jobPosition2, StaffList.employees);
                        currentEmployee2.countOfficeSupplies(currentEmployee2, StaffList.employees);
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

    private static Staff getEmployeeByNameAndPosition(String name, String jobPosition, List<Staff> employees)
    {
        Staff currentEmployee = null;
        for (Staff employee : employees) {
            if (((employee.getName()).equals(name)) && ((employee.getJobPosition()).equals(jobPosition))) {
                currentEmployee = employee;
            }
        }
        return currentEmployee;
    }

    @Test
    public void getEmployeeIsWorking()
    {
        Staff currentEmployee = getEmployeeByNameAndPosition("Zaitseva Elena", "Secretary", StaffList.employees);
        assertThat(currentEmployee.getName(), is("Zaitseva Elena"));
        assertThat(currentEmployee.getJobPosition(), is("Secretary"));
    }

}

