package TestTask7;


import task7.Submarine;


public class StartOfTheSubmarine extends Submarine{
    public StartOfTheSubmarine(String name) {
        super(name);
    }
    public static void main(String[] args) {
        Submarine submarine1 = new Submarine("Admiral Krusenstern");
        submarine1.sail();
    }





}
