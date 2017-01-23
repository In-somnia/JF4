package task3;


public class Pen extends Stationery {
    private String color;

    public Pen(String name, int price, String color, String itemName)
    {
        super(name, price, itemName);
        this.color = color;
    }

    public String getColor()
    {
        return color;
    }

}
