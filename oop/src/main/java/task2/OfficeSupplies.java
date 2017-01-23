package task2;


class OfficeSupplies {
    private String type;
    private int price;

    OfficeSupplies(String type, int price)
    {
        this.type = type;
        this.price = price;
    }

    int getPrice()
    {return price;}

    public String getType()
    {return type;}
}
