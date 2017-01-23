package task2;

import java.util.ArrayList;
import java.util.List;


public class Staff {
    private String name;
    private String jobPosition;
    private List<OfficeSupplies> personalOfficeSupplies = new ArrayList<>();


    public Staff(String name, String jobPosition)
    {
        this.name = name;
        this.jobPosition = jobPosition;
    }

    public String getName()
    {
        return name;
    }

    public String getJobPosition()
    {
        return jobPosition;
    }

    private List<OfficeSupplies> getPersonalOfficeSupplies()
    {
        return  personalOfficeSupplies;
    }

    public List<Staff> addOfficeSupplies(Staff employee, String type, int quantity, int price, List<Staff> employees)
    {

                for (int j = 0; j < quantity; j++)
                {
                    employee.personalOfficeSupplies.add(new OfficeSupplies(type, price));
                }


        System.out.println("Канцелярские принадлежности добавлены следующему сотруднику: " + employee.getName() +
                ", занимающему должность: " + employee.getJobPosition());

        return employees;
    }

    public void countOfficeSupplies(Staff employee, List<Staff> employees)
    {
        int resultingPrice = 0;

        employee.getPersonalOfficeSupplies();

        for (OfficeSupplies item : personalOfficeSupplies)
        {
            resultingPrice += item.getPrice();
        }

        System.out.println("Сотрудник: " + employee.getName());
        System.out.println("Должность: " + employee.getJobPosition());
        System.out.println("Получено канцтоваров на сумму: " + resultingPrice + "руб.");
    }

}
