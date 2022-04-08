package homeBudget.Servlet;

import homeBudget.DAO.*;
import homeBudget.model.Miesiac;
import homeBudget.model.Rok;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/app/listaWydatkow")
public class ListaWydatkow extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SesjaBazaDanych sesjaBazaDanych = new SesjaBazaDanych();
        sesjaBazaDanych.bazaDanych(req,resp);
        String nazwaBazy = (String)req.getSession().getAttribute("bazaDanych");

        MiesiacDao miesiacDao = new MiesiacDao();
        RokDao rokDao = new RokDao();
        List<Miesiac> miesiacList = miesiacDao.miesiacList();
        List<Rok> rokList = rokDao.yearList();
        BazaDanychDao bazaDanychDao = new BazaDanychDao();
        req.setAttribute("nazwyBazDanych", bazaDanychDao.bazaDanychList());
        WydatekDao wydatekDao = new WydatekDao();
        int idUser = (Integer) req.getSession().getAttribute("user");
        req.setAttribute("sumWydatkow", wydatekDao.sumaWydatkow(nazwaBazy, idUser));

        WyplataDao wyplataDao = new WyplataDao();
        Double sumaPrzychodow = wyplataDao.getWyplata(nazwaBazy, idUser);
        Double sumaKosztow = wydatekDao.sumaKosztow(wydatekDao.sumaWydatkow(nazwaBazy, idUser));

        req.setAttribute("wyplata" , Math.round((sumaPrzychodow - sumaKosztow)*100.0) / 100.0);



        getServletContext().getRequestDispatcher("/WEB-INF/Wydatki.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nazwaBazy = req.getParameter("nazwaBazy");
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("bazaDanych", nazwaBazy);
        resp.sendRedirect("/homebudget/app/listaWydatkow");
    }
}
