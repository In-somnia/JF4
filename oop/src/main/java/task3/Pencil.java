package task3;


public class Pencil extends Stationery {
    private String density;

    public Pencil(String name, int price, String density, String itemName)
    {
        super(name, price, itemName);
        this.density = density;
    }

    public String getDensity()
    {
        return density;
    }
}
