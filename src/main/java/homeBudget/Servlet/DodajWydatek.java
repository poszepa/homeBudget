package homeBudget.Servlet;

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
        req.setAttribute("kategoria",kategoria);


        getServletContext().getRequestDispatcher("/WEB-INF/dodajWydatek.jsp").forward(req,resp);


    }
}
