package task3;


public abstract class  Stationery {
    private String name;
    private int price;
    private String itemName;

    protected Stationery(String name, int price, String itemName)
    {
        this.name = name;
        this.price = price;
        this.itemName = itemName;
    }

    public String getName()
    {
        return name;
    }
    public int getPrice()
    {
        return price;
    }

    private String getItemName()
    {
        return itemName;
    }

    @Override
    public String toString()
    {
        return "Товар: " + getItemName() + ", производитель: " + getName() + ", цена: " + getPrice();
    }

}
