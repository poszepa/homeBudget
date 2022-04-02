package homeBudget.Servlet;

import homeBudget.DAO.WydatekDao;
import homeBudget.model.Wydatek;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dodajWydatek")
public class DodajWydatek extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String kategoria = req.getParameter("kategoria");
        String nazwaBazy = req.getParameter("nazwaBazy");

        req.setAttribute("kategoria", kategoria);
        req.setAttribute("nazwaBazy", nazwaBazy);



        getServletContext().getRequestDispatcher("/WEB-INF/dodajWydatek.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String skrot = req.getParameter("skrotWydatku");
        String opis = req.getParameter("opisWydatku");
        Double kwota = Double.parseDouble(req.getParameter("kwota"));
        String kategoria = req.getParameter("kategoria");
        String nazwaBazy = req.getParameter("nazwaBazy").toLowerCase();
        String calaNazwaTabeli = nazwaBazy +"."+kategoria;

        WydatekDao wydatekDao = new WydatekDao();
        Wydatek wydatek = new Wydatek(skrot, opis, kwota);
        wydatekDao.addWydatek(wydatek, calaNazwaTabeli);

        resp.sendRedirect("/homebudget/listaWydatkow?nazwaBazy="+nazwaBazy+"&kategoria="+kategoria);


    }
}
