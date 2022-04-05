package homeBudget.Servlet;

import homeBudget.DAO.SesjaBazaDanych;
import homeBudget.DAO.WyplataDao;
import homeBudget.model.Wyplata;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/wyplata")
public class WyplataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SesjaBazaDanych sesjaBazaDanych = new SesjaBazaDanych();
        sesjaBazaDanych.bazaDanych(req,resp);
        HttpSession session = req.getSession();
        String nazwaBazy = (String) session.getAttribute("bazaDanych");

        WyplataDao wyplataDao = new WyplataDao();
        req.setAttribute("wyplataList", wyplataDao.findAllSalary(nazwaBazy));

        getServletContext().getRequestDispatcher("/WEB-INF/Wyplata.jsp").forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SesjaBazaDanych sesjaBazaDanych = new SesjaBazaDanych();
        sesjaBazaDanych.bazaDanych(req,resp);
        HttpSession session = req.getSession();
        String nazwaBazy = (String) session.getAttribute("bazaDanych");
        String opis = req.getParameter("wyplataOpis");
        Double wyplata = Double.parseDouble(req.getParameter("kwota"));
        Wyplata wyplata1 = new Wyplata(wyplata, opis);

        WyplataDao wyplataDao = new WyplataDao();
        wyplataDao.addWyplata(wyplata1, nazwaBazy);

        resp.sendRedirect("/homebudget/wyplata");
    }
}
