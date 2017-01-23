package task3;


public class Ruler extends Stationery{
    private int length;
    private String color;
    private String material;

    public Ruler(String name, int price, int length, String color, String material, String itemName) {
        super(name, price, itemName);
        this.length = length;
        this.color = color;
        this.material = material;
    }

    public int getLength()
    {
        return length;
    }

    public String getColor()
    {
        return color;
    }

    public String getMaterial()
    {
        return material;
    }
}
