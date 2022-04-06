package homeBudget.Servlet;

import homeBudget.DAO.UserDao;
import homeBudget.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        getServletContext().getRequestDispatcher("/WEB-INF/Register.jsp").forward(req,resp);
        session.removeAttribute("register");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String rePassword = req.getParameter("repassword");
        UserDao userDao = new UserDao();

        if(userDao.checkRegister(req,resp, email, password,rePassword)){
            User user = new User(email, password);
            userDao.createUser(user);
        }

        resp.sendRedirect("/homebudget/register");

    }
}
