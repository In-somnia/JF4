package task1;


import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.stream.Collectors;

public class ExecutePreparedStatement {

    @SneakyThrows
    public static void main(String[] args) {
        Connection con;
        ResultSet rs;
        Statement st = null;
        PreparedStatement ps;

        Class.forName("org.h2.Driver");
        con = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");

        for (int i = 1; new File("C:/Users/Julia/IdeaProjects/JF4/jdbc/src/main/resources/sql/" + i + ".sql")
                .exists(); i++) {
            String collect = Files.readAllLines(Paths.get("C:/Users/Julia/IdeaProjects/JF4/jdbc/src/main/resources/" +
                    "sql/" + i + ".sql")).stream().collect(Collectors.joining());
            st = con.createStatement();
            st.executeUpdate(collect);
        }
            String select = "SELECT * FROM Books";
            ps = con.prepareStatement(select);
            rs = ps.executeQuery();
            System.out.println("Загрузка коллекции из файла 1.sql: ");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " - " + rs.getString(3) + ".");
            }
            System.out.println("__________________________________________________________");

            String selectIdAndName = "SELECT * FROM Books WHERE id=? AND full_author_name=?";
            ps = con.prepareStatement(selectIdAndName);
            ps.setInt(1, 2);
            ps.setString(2, "Feodor Dostoevskiy");
            rs = ps.executeQuery();
            System.out.println("Извлечение информации с помощью подготовленного запроса: ");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " - " + rs.getString(3) + ".");
            }
            System.out.println("__________________________________________________________");

            String update = "UPDATE Books SET book_name=? WHERE full_author_name=?";
            ps = con.prepareStatement(update);
            ps.setString(1, "The Color of Magic");
            ps.setString(2, "Terry Pratchett");
            ps.executeUpdate();
            System.out.println("Строка обновлена.");
            System.out.println("__________________________________________________________");

            String insert = "INSERT INTO Books (full_author_name, book_name) VALUES (?, ?)";
            ps = con.prepareStatement(insert);
            ps.setString(1, "William Thackeray");
            ps.setString(2, "Vanity Fair");
            ps.executeUpdate();
            System.out.println("Строка добавлена.");
            System.out.println("__________________________________________________________");

            String selectByOrder = "SELECT * FROM Books ORDER BY id";
            ps = con.prepareStatement(selectByOrder);
            rs = ps.executeQuery();
            System.out.println("Таблица после добавления новой строки: ");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " - " + rs.getString(3) + ".");
            }
            System.out.println("__________________________________________________________");

            String delete = "DROP TABLE Books";
            ps = con.prepareStatement(delete);
            ps.executeUpdate();
            System.out.println("Таблица удалена");

        rs.close();
        if (st != null) {
            st.close();
        }
        ps.close();
        con.close();
    }
}






