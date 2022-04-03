package homeBudget.Servlet;

import homeBudget.DAO.WydatekDao;
import homeBudget.model.Wydatek;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edytujWydatek")
public class EdytujWydatek extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String nazwaBazy = req.getParameter("nazwaBazy");
        req.setAttribute("nazwaBazy", nazwaBazy);
        String kategoria = req.getParameter("kategoria");
        WydatekDao wydatekDao = new WydatekDao();
        Wydatek wydatek = wydatekDao.findWydatekById(id, nazwaBazy, kategoria);
        req.setAttribute("wydatek", wydatek);
        System.out.println(wydatek.getKwotaWydatku());
        System.out.println(wydatek.getOpisWydatku());

        getServletContext().getRequestDispatcher("/WEB-INF/edytujWydatek.jsp").forward(req,resp);
    }
}
