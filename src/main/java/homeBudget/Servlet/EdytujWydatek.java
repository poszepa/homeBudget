package homeBudget.Servlet;

import homeBudget.DAO.BazaDanychDao;
import homeBudget.DAO.SesjaBazaDanych;
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
        String kategoria = req.getParameter("kategoria");
        WydatekDao wydatekDao = new WydatekDao();
        SesjaBazaDanych sesjaBazaDanych = new SesjaBazaDanych();
        sesjaBazaDanych.bazaDanych(req,resp);
        String nazwaBazy = (String)req.getSession().getAttribute("bazaDanych");
        req.setAttribute("kategoria", kategoria);
        req.setAttribute("nazwaBazy", nazwaBazy);


        Wydatek wydatek = wydatekDao.findWydatekById(id,nazwaBazy, kategoria);
        req.setAttribute("wydatek", wydatek);

        getServletContext().getRequestDispatcher("/WEB-INF/edytujWydatek.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String nazwaBazy =  req.getParameter("nazwaBazy");
        String kategoria = req.getParameter("kategoria");
        Wydatek wydatek = new Wydatek(
            Integer.parseInt(req.getParameter("id")),
            req.getParameter("skrotWydatku"),
            req.getParameter("opisWydatku"),
            Double.parseDouble(req.getParameter("kwota")));


        WydatekDao wydatekDao = new WydatekDao();
        wydatekDao.editWydatekById(id,nazwaBazy,kategoria, wydatek );

        resp.sendRedirect("/homebudget/dodajWydatek?nazwaBazy=" +nazwaBazy+"&kategoria=" +kategoria);
    }
}
