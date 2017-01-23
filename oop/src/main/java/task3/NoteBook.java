package task3;


public class NoteBook extends Stationery {
    private int numberOfPages;
    private String coverColor;
    private String type;

    public NoteBook(String name, int price, int numberOfPages, String coverColor, String type, String itemName)
    {
       super(name, price, itemName);
       this.numberOfPages = numberOfPages;
       this.coverColor = coverColor;
       this.type = type;
    }
    public String getCoverColor()
    {
        return coverColor;
    }

    public int getNumberOfPages()
    {
        return numberOfPages;
    }
    public String getType()
    {
        return type;
    }
}
