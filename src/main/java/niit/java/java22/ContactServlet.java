package niit.java.java22;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ContactServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer writer = resp.getWriter();
        resp.setContentType("text/html");
        writer.write("<html><head></head><body>Test</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        String note = req.getParameter("note");

        Connection conn = null;
        //kết nối vào CSDL để chèn vào bảng contact
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaweb_22", "root", "koodinh@");
            PreparedStatement prp = conn.prepareStatement("INSERT INTO contacts(full_name,email,note) VALUES(?,?,?)");
            prp.setString(1, fullName);
            prp.setString(2, email);
            prp.setString(3, note);
            int count = prp.executeUpdate();
            if (count > 0) {
                System.out.println("Insert thành văn công");
            }else{
                System.out.println("Insert thất văn bại");
            }
        } catch (Exception e) {
            System.out.println("Insert thất văn bại");
            e.printStackTrace();
        }
    }
}
