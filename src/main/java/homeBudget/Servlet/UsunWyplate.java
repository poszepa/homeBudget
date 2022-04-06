package homeBudget.Servlet;

import homeBudget.DAO.SesjaBazaDanych;
import homeBudget.DAO.WyplataDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/app/wyplataDelete")
public class UsunWyplate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        SesjaBazaDanych sesjaBazaDanych = new SesjaBazaDanych();
        sesjaBazaDanych.bazaDanych(req,resp);
        HttpSession session = req.getSession();
        String nazwaBazy = (String) session.getAttribute("bazaDanych");
        WyplataDao wyplataDao = new WyplataDao();
        int idUser = (Integer)req.getSession().getAttribute("user");
        wyplataDao.deleteSalary(id, nazwaBazy, idUser);
        resp.sendRedirect("/homebudget/app/wyplata");
    }
}
