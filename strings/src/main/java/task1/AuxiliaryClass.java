package task1;


public class AuxiliaryClass {

    private String name;
    private int age;
    private int weight;

    public AuxiliaryClass(String name, int age, int weight)
    {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName()
    {
        return name;
    }

    private int getAge()
    {
        return age;
    }

    private int getWeight()
    {
        return weight;
    }

    public AuxiliaryClass compareAges(AuxiliaryClass o)
    {
        if(this.getAge() > o.getAge())
        {
            return this;
        }
        else
            return o;
    }

    public AuxiliaryClass compareWeight(AuxiliaryClass a)
    {
        if(this.getWeight() > a.getWeight())
        {
            return this;
        }
        else
            return a;
    }
}
