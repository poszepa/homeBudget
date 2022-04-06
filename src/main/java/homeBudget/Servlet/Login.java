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

@WebServlet("/")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
        httpSession.removeAttribute("login");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = new User(email, password);
        UserDao userDao = new UserDao();
        String redirect = "/homebudget/login";
        if(userDao.checkCorrectLogin(user, req)){
            user = userDao.findUserByEmail(email);
            HttpSession session = req.getSession();
            session.setAttribute("user", user.getId());
            redirect = "/homebudget/app/listaWydatkow";
        }
        resp.sendRedirect(redirect);
    }
}
