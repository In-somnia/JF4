package task4;


import java.io.Serializable;

public class Actor implements Serializable {
    private String name;
    private int age;
    private String bestFilms;
    public Actor(String name, int age, String bestFilms)
    {
        this.name = name;
        this.age = age;
        this.bestFilms = bestFilms;
    }
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
    public String getBestFilms()
    {
        return bestFilms;
    }
}
