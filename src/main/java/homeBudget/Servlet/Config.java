package homeBudget.Servlet;

import homeBudget.DAO.CreatorDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/config")
public class Config extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nazwaBazy = req.getParameter("nazwaBazy");
        req.setAttribute("nazwaBazy", nazwaBazy);


        getServletContext().getRequestDispatcher("/WEB-INF/config.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String miesiac = req.getParameter("miesiac");
        int rok = Integer.parseInt(req.getParameter("rok"));
        double wyplata = Double.parseDouble(req.getParameter("wyplata"));
        CreatorDao creatorDao = new CreatorDao();
        creatorDao.createDB(miesiac + String.valueOf(rok));
        creatorDao.createTable();

        resp.sendRedirect("/homebudget/config");
    }
}
