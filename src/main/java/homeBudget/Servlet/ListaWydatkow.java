package homeBudget.Servlet;

import homeBudget.DAO.MiesiacDao;
import homeBudget.DAO.RokDao;
import homeBudget.model.Miesiac;
import homeBudget.model.Rok;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listaWydatkow")
public class ListaWydatkow extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MiesiacDao miesiacDao = new MiesiacDao();
        RokDao rokDao = new RokDao();
        String nazwaBazy = req.getParameter("miesiac");
        req.setAttribute("nazwaBazy", nazwaBazy);
        List<Miesiac> miesiacList = miesiacDao.miesiacList();
        List<Rok> rokList = rokDao.yearList();
        req.setAttribute("miesiacList", miesiacList);
        req.setAttribute("rokList", rokList);


        getServletContext().getRequestDispatcher("/WEB-INF/Wydatki.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String miesiac = req.getParameter("miesiac");
        String rok = req.getParameter("rok");

        resp.sendRedirect("/homebudget/listaWydatkow?miesiac=" + miesiac + rok);
    }
}
