package homeBudget.DAO;

import homeBudget.model.User;
import homeBudget.utils.DbUtil;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

public class UserDao extends HttpServlet {

    private final String CREATE_USER_QUERY = "INSERT INTO users.user(email, password) VALUES(? ,?);";
    private final String FIND_USER_BY_ID_QUERY = "SELECT * FROM users.user WHERE id = ?";
    private final String FIND_USER_BY_EMAIL = "SELECT * FROM users.user WHERE email = ?";

    public User createUser(User user) {
        try(Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(CREATE_USER_QUERY,PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1,user.getEmail());
            String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
            statement.setString(2,hashedPassword);
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            while (resultSet.next()) {
                user.setId(resultSet.getInt(1));
            }
            return user;

        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public User findUserById(int userId) {
        try(Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_USER_BY_ID_QUERY);
            statement.setInt(1,userId);
            ResultSet resultSet = statement.executeQuery();
            User user = new User();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
            }
            return user;

        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public User findUserByEmail(String email) {
        try(Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_USER_BY_EMAIL);
            statement.setString(1,email);
            ResultSet resultSet = statement.executeQuery();
            User user = new User();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
            }
            return user;

        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Boolean checkCorrectLogin(User user, HttpServletRequest req) {
        try{
            User findUserInBase = findUserByEmail(user.getEmail());
            if(findUserInBase.getPassword() == null) {
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("login", "wrong");
                return false;
            }
            if(BCrypt.checkpw(user.getPassword(), findUserInBase.getPassword())){
                return true;
            }
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return false;
        }
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("login", "wrong");
        return false;
    }

    public Boolean checkExistEmail(String email) {
        if(findUserByEmail(email).getEmail() != null) {
            return false;
        }
        return true;
    }

    public Boolean checkPasswordEquals(String password, String rePassword) {
        if(password.equals(rePassword)){
            return true;
        }
        return false;
    }

    public Boolean checkPasswordLength(String password) {
        if(password.length() >= 8) {
            return true;
        }
        return false;
    }

    public Boolean checkRegister(HttpServletRequest req, HttpServletResponse resp, String email, String password, String rePassword){
        if(checkExistEmail(email)) {
            if (checkPasswordEquals(password, rePassword)) {
                if (checkPasswordLength(password)) {
                    HttpSession httpSession = req.getSession();
                    httpSession.setAttribute("register", "correct");
                    return true;
                }
            }
        }
        if(!checkExistEmail(email)) {
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("register", "emailExist");
            return false;
        }
        if(checkPasswordEquals(password, rePassword) == false) {
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("register", "passwordNotEquals");
            return false;
        }
        if(!checkPasswordLength(password)) {
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("register", "passwordToShort");
            return false;
        }
        return false;
    }
}
