package homeBudget.Servlet;

import homeBudget.DAO.WydatekDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/usunWydatek")
public class UsunWydatek extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nazwaBazy = req.getParameter("nazwaBazy");
        String kategoria = req.getParameter("kategoria");
        int id = Integer.parseInt(req.getParameter("id"));
        WydatekDao wydatekDao = new WydatekDao();
        wydatekDao.usunWydatekById(id, nazwaBazy, kategoria);

        resp.sendRedirect("/homebudget/dodajWydatek?nazwaBazy="+nazwaBazy +"&kategoria="+kategoria);

    }
}
