package task2.cp;

import lombok.SneakyThrows;
import task2.cp.Model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;


public class BookManager implements BookManagerDAO{
    private List<Book> bookCollection = new ArrayList<>();
    private ConnectionPool cp = new ConnectionPool();
    private Connection con;
    private ResultSet rs;

    @Override
    @SneakyThrows
    public void insertABook(String author, String name) {
        con = cp.takeConnection();
        String prepQuery = "INSERT INTO Books(full_author_name, book_name) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(prepQuery);
        ps.setString(1, author);
        ps.setString(2, name);
        ps.executeUpdate();
        System.out.printf("Книга %s автора %s добавлена в коллекцию.\n", name, author);
        bookCollection.clear();
        String query = "SELECT * FROM Books ORDER BY id";
        PreparedStatement pst = con.prepareStatement(query);
        rs = pst.executeQuery();
        while (rs.next())
        {
            Book book = new Book();
            book.setId(rs.getInt(1));
            book.setAuthor(rs.getString(2));
            book.setName(rs.getString(3));
            bookCollection.add(book);
        }
        con.close();
    }

    @Override
    @SneakyThrows
    public void deleteABook(String name) {
        con = cp.takeConnection();
        String prepQuery = "DELETE FROM Books WHERE book_name=?";
        PreparedStatement ps = con.prepareStatement(prepQuery);
        ps.setString(1, name);
        ps.executeUpdate();
        System.out.printf("Книга %s удалена из коллекции.\n", name);
        bookCollection.clear();
        String query = "SELECT * FROM Books ORDER BY id";
        PreparedStatement pst = con.prepareStatement(query);
        rs = pst.executeQuery();
        while (rs.next())
        {
            Book book = new Book();
            book.setId(rs.getInt(1));
            book.setAuthor(rs.getString(2));
            book.setName(rs.getString(3));
            bookCollection.add(book);
        }
        con.close();
    }

    @Override
    @SneakyThrows
    public void showCollection() {
        con = cp.takeConnection();
        bookCollection.clear();
        String prepQuery = "SELECT * FROM Books ORDER BY id";
        PreparedStatement ps = con.prepareStatement(prepQuery);
        rs = ps.executeQuery();
        while (rs.next())
        {
            Book book = new Book();
            book.setId(rs.getInt(1));
            book.setAuthor(rs.getString(2));
            book.setName(rs.getString(3));
            bookCollection.add(book);
        }
        for (Book b : bookCollection)
        {
            System.out.printf("%s - %s.%n", b.getAuthor(), b.getName());
        }
        con.close();
    }

    @Override
    @SneakyThrows
    public void findByName(String name) {

        con = cp.takeConnection();
        String prepQuery = "SELECT * FROM Books WHERE book_name=?";
        PreparedStatement ps = con.prepareStatement(prepQuery);
        findByBookName.clear();
        ps.setString(1, name);
        rs = ps.executeQuery();
        System.out.printf("Книги с названием %s: \n", name);
        while (rs.next())
        {
            Book book = new Book();
            book.setId(rs.getInt(1));
            book.setAuthor(rs.getString(2));
            book.setName(rs.getString(3));
            findByBookName.add(book);
        }
        for (Book b : findByBookName)
        {
            System.out.printf("%s - %s.%n", b.getAuthor(), b.getName());
        }
        con.close();
    }

    @Override
    @SneakyThrows
    public void findByAuthor(String author) {
        con = cp.takeConnection();
        String prepQuery = "SELECT * FROM Books WHERE full_author_name=?";
        PreparedStatement ps = con.prepareStatement(prepQuery);
        findByAuthor.clear();
        ps.setString(1, author);
        rs = ps.executeQuery();
        System.out.printf("Книги автора %s: \n", author);

        while (rs.next())
        {
            Book book = new Book();
            book.setId(rs.getInt(1));
            book.setAuthor(rs.getString(2));
            book.setName(rs.getString(3));
            findByAuthor.add(book);
        }
        for (Book b : findByAuthor)
        {
            System.out.printf("%s - %s.%n", b.getAuthor(), b.getName());
        }
        con.close();
    }
}
