package task2.cp;


import task2.cp.Model.Book;

import java.util.ArrayList;
import java.util.List;

interface BookManagerDAO {
    List<Book>findByBookName = new ArrayList<>();
    List<Book>findByAuthor = new ArrayList<>();

    void insertABook(String author, String name);
    void deleteABook(String name);
    void showCollection();
    void findByName(String name);
    void findByAuthor(String author);
}
