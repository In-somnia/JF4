package task1;


import java.util.Objects;
import java.util.Random;

public class Pen {

    private String color;
    private String producerName;
    private int price;
    private boolean state;

    public Pen(String color, String producerName, int price)
    {
        this.color = color;
        this.producerName = producerName;
        this.price = price;
        this.state = tryWrite();
    }

    public String getColor() {
        return this.color;
    }

    public String getProducerName() {
        return this.producerName;
    }

    public int getPrice() {
        return this.price;
    }

    private boolean getState() {
        return this.state;
    }

    @Override
    public String toString()
    {
        return "color: " + color + ", producerName: " + producerName + ", price: " + price + ", state: " + checkState();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Pen pen = (Pen) obj;

        if (!Objects.equals(color, pen.color))
            return false;
        if (!Objects.equals(producerName, pen.producerName))
            return false;
        if (price != pen.price)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        return (31 * price + ((null == producerName)? 0 : producerName.hashCode()) + ((null == color)? 0 : color.hashCode()));
    }

    private boolean tryWrite()
    {
        Random random = new Random();
        boolean isWorking = random.nextBoolean();

        if (isWorking)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    private String checkState()
    {
        String result;

        if(getState())
        {
            result = "This pen is working.";
        }
        else
        {
            result = "This pen is broken.";
        }
        return result;
    }
}
