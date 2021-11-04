package niit.java.java22;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;

public class GetSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("school")!=null) {
            System.out.println(session.getAttribute("school"));
            System.out.println(session.getAttribute("age"));
            System.out.println(session.getAttribute("address"));
        }
    }
}
