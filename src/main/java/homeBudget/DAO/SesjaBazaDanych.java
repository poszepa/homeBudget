package homeBudget.DAO;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SesjaBazaDanych extends HttpServlet {


    public void bazaDanych(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("bazaDanych") == null) {
            session.setAttribute("bazaDanych", "kwiecien2022");
        }else{
           String nazwaBazy = (String)session.getAttribute("bazaDanych");
           session.setAttribute("bazaDanych", nazwaBazy);
        }
    }
}
