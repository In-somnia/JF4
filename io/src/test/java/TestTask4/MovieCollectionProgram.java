package TestTask4;


import task4.Actor;
import task4.Movie;
import task4.MovieCollection;
import java.io.*;


public class MovieCollectionProgram {
    public static void main(String[] args) throws IOException {

        MovieCollection myCollection = new MovieCollection();

        /*Закомментированные данные ниже нужны для того, чтобы захардкодить и сериализовать коллекцию при первом запуске
         программы, если ее еще неоткуда подгружать. Оставлены на всякий случай.*/

        /*Actor TimRobbins = new Actor("Tim Robbins", 1958, "Nothing To Lose(1997), Mystic River(2003)");
        Actor TomHanks = new Actor("Tom Hanks", 1956, "Forrest Gump(1994), Catch Me If You Can(2002)");
        Actor MorganFreeman = new Actor("Morgan Freeman", 1937, "Se7en(1995), Lucky Number Slevin(2005)");

        List<Actor> TheGreenMileCast = new ArrayList<>();
        TheGreenMileCast.add(TomHanks);

        List<Actor> TheShawshankRedemptionCast = new ArrayList<>();
        TheShawshankRedemptionCast.add(TimRobbins);

        TheShawshankRedemptionCast.add(MorganFreeman);
        List<Actor> ForrestGumpCast = new ArrayList<>();
        ForrestGumpCast.add(TomHanks);

        myCollection.movieCollection.add(new Movie("The Green Mile", 1999, TheGreenMileCast));
        myCollection.movieCollection.add(new Movie("Forrest Gump", 1994, ForrestGumpCast));
        myCollection.movieCollection.add(new Movie("The Shawshank Redemption", 1994, TheShawshankRedemptionCast));*/

        while(true)
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Выберите действия, которые необходимо осуществить: ");
            System.out.println("1 - посмотреть информацию о фильме");
            System.out.println("2 - редактировать информацию о фильме");
            System.out.println("3 - показать все фильмы");
            System.out.println("0 - выйти из программы");

            String choice = reader.readLine();

            switch(choice)
            {
                case "1":

                        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
                        System.out.println("Введите название фильма, информацию о котором необходимо узнать: ");
                        String name = reader1.readLine();
                        for (int i = 0; i < myCollection.movieCollection.size(); i++)
                        {
                            Movie movie = myCollection.movieCollection.get(i);
                            if (movie.getMovieName().equals(name))
                            {
                                System.out.println("Название: " + movie.getMovieName());
                                System.out.println("Год выпуска: " + movie.getReleaseDate());
                                for (Actor x : movie.getCast())
                                {
                                    System.out.println("Актер: " + x.getName());
                                    System.out.println("Возраст: " + x.getAge());
                                    System.out.println("Лучшие роли: " + x.getBestFilms());
                                }
                            }
                        }
                        break;
                case "2":
                    System.out.println("Выберите фильм, который необходимо отредактировать: ");
                    String editFilmName = reader.readLine();
                    System.out.println("Укажите параметр, который необходимо исправить: ");
                    System.out.println("1 - изменить название");
                    System.out.println("2 - изменить год выпуска");
                    System.out.println("0 - выйти из программы");
                    String change = reader.readLine();
                    switch(change)
                    {
                        case "1":
                            System.out.println("Введите новое название фильма: ");
                            String editedName = reader.readLine();
                            for (int i = 0; i < myCollection.movieCollection.size(); i++) {
                                Movie movie = myCollection.movieCollection.get(i);
                                if (movie.getMovieName().equals(editFilmName)) {
                                    movie.setMovieName(editedName);
                                }
                            }
                            System.out.println("Название фильма " + editFilmName + " успешно изменено на: " + editedName);
                            break;
                        case "2":
                            System.out.println("Введите новый год выпуска фильма: ");
                            int editedYear = Integer.parseInt(reader.readLine());
                            for (int i = 0; i < myCollection.movieCollection.size(); i++) {
                                Movie movie = myCollection.movieCollection.get(i);
                                if (movie.getMovieName().equals(editFilmName)) {
                                    movie.setReleaseDate(editedYear);
                                    System.out.println("Год выпуска фильма " + editFilmName + " успешно изменен на " + editedYear);
                                }
                            }
                            break;
                        case "0":
                            myCollection.saveCollection();
                            reader.close();
                            return;
                        default:
                            break;
                    }
                    break;
                case "3":
                    System.out.println("Все фильмы коллекции: ");
                    for (Movie x : myCollection.movieCollection)
                    {
                        System.out.println(x.getMovieName());
                    }
                    break;
                case "0":
                    myCollection.saveCollection();
                    reader.close();
                    return;
                default:
                    break;
            }
        }
    }
}
