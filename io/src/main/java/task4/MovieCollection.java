package task4;


import java.io.*;
import java.util.List;

public class MovieCollection implements Serializable {
    public List<Movie> movieCollection;
    private String savedCollection = "D:\\test8.docx";
    public MovieCollection()
    {
        System.out.println("Коллекция загружена.");
        restoreCollection();
    }

    public void saveCollection()
    {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(savedCollection)));
            out.writeObject(movieCollection);

        } catch (IOException e) {
            e.printStackTrace();
        } finally
        {
            System.out.println("Коллекция сохранена.");
            try {
                assert out != null;
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


private List<Movie> restoreCollection()
{
   ObjectInputStream in = null;
    try {
        in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(savedCollection)));
        movieCollection = (List<Movie>)in.readObject();
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    } finally
    {
        try {
            assert in != null;
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    return movieCollection;
}
}
