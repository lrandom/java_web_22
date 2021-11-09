package dals;

import domains.Book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DALBook extends Conn implements ICrud<Book> {

    public DALBook() {
        super();
        setTableName("books");
    }

    @Override
    public ArrayList<Book> getListBook() {
        ArrayList<Book> list = new ArrayList<>();
        try {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM " + tableName);
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setDescription(rs.getString("description"));
                book.setAuthor(rs.getString("author"));
                list.add(book);
            }
        } catch (Exception e) {

        }
        return list;
    }

    @Override
    public boolean deleteById(int id) {
        try {
            Statement stm = connection.createStatement();
            int affectRows = stm.executeUpdate("DELETE * FROM " + tableName + " WHERE id=" + id);
            if (affectRows > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean add(Book obj) {
        try {
            PreparedStatement prp = connection.prepareStatement("INSERT INTO " + tableName + "(title,description,author) VALUES (?,?,?)");
            prp.setString(1, obj.getTitle());
            prp.setString(2, obj.getDescription());
            prp.setString(3, obj.getAuthor());
            int affectRows = prp.executeUpdate();
            if (affectRows > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Book obj) {
        try {
            PreparedStatement prp = connection.prepareStatement("UPDATE " + tableName + " SET title=?, SET description=?, SET author=? WHERE id=?");
            prp.setString(1, obj.getTitle());
            prp.setString(2, obj.getDescription());
            prp.setString(3, obj.getAuthor());
            prp.setInt(4, obj.getId());
            int affectRows = prp.executeUpdate();
            if (affectRows > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
