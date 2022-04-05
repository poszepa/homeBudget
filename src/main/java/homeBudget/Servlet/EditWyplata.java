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

@WebServlet("/wyplataEdit")
public class EditWyplata extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        SesjaBazaDanych sesjaBazaDanych = new SesjaBazaDanych();
        sesjaBazaDanych.bazaDanych(req,resp);
        HttpSession session = req.getSession();
        String nazwaBazy = (String) session.getAttribute("bazaDanych");
        WyplataDao wyplataDao = new WyplataDao();
        req.setAttribute("wyplata", wyplataDao.findSalaryById(id, nazwaBazy));

        getServletContext().getRequestDispatcher("/WEB-INF/WyplataEdit.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SesjaBazaDanych sesjaBazaDanych = new SesjaBazaDanych();
        sesjaBazaDanych.bazaDanych(req,resp);
        HttpSession session = req.getSession();
        String nazwaBazy = (String) session.getAttribute("bazaDanych");

        int id = Integer.parseInt(req.getParameter("id"));
        Double wyplata = Double.parseDouble(req.getParameter("kwota"));
        String opis = (String) req.getParameter("wyplataOpis");
        String data = (String) req.getParameter("data");
        Wyplata wyplata1 = new Wyplata(id, wyplata, opis, data);
        WyplataDao wyplataDao = new WyplataDao();
        wyplataDao.editSalary(wyplata1, nazwaBazy);

        resp.sendRedirect("/homebudget/wyplata");
    }
}
