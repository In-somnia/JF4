package task3;


public class Eraser extends Stationery {
    private String color;


    public Eraser(String name, int price, String color, String itemName)
    {
        super(name, price, itemName);
        this.color = color;

    }

    public String getColor()
    {
        return color;
    }



}
