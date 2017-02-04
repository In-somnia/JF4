package task4;


import java.io.Serializable;
import java.util.List;

public class Movie  implements Serializable{
    private String movieName;
    private int releaseDate;
    private List<Actor> cast;

    public Movie(String movieName, int releaseDate, List<Actor> cast)
    {
        this.movieName = movieName;
        this.releaseDate = releaseDate;
        this.cast = cast;
    }

    public String getMovieName()
    {
        return movieName;
    }
    public int getReleaseDate()
    {
        return  releaseDate;
    }
    public List<Actor> getCast()
    {
        return cast;
    }
    public void setMovieName(String editedName)
    {
     movieName = editedName;
    }
    public void setReleaseDate(int editedYear)
    {
        releaseDate = editedYear;
    }
}
