package niit.java.java22;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;

public class SessionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("username"));
        System.out.println(req.getParameter("password"));
        System.out.println(req.getParameter("phone"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /* Cookie cookie = new Cookie("username", "luan");
        cookie.setMaxAge(60 * 60 * 24 * 7);//sống 1 tuần
        resp.addCookie(cookie);*/
        //resp.sendRedirect("/session.html");


        //Lấy ra
/*        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            {
                if (cookie.getName().equals("username")) {
                    System.out.println(cookie.getValue());
                    break;
                }
            }
        }*/

        //Xoá
        /*Cookie cookie = new Cookie("username", "");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);*/


        //set session
        HttpSession session = req.getSession();
        session.setAttribute("school", "NIIT");
        session.setAttribute("age", "20");
        session.setAttribute("address", new String("Hà Nội"));

        //get session

        //remove session
        /*session.removeAttribute("school");
        session.removeAttribute("age");
        session.removeAttribute("address");*/
    }
}
