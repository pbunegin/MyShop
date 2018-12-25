package servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);
    private final String LOGIN = "bunegin_p";
    private final String PASSWORD = "123";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (login == null) {
            logger.info("open login.jsp login: {}, password: {}",login,password);
            request.getRequestDispatcher("login.jsp").forward(request, response);

        } else if (!(login.equals(LOGIN) && password.equals(PASSWORD))) {
            logger.info("wrong login/password login: {}, password: {}",login,password);
            request.setAttribute("errorLoginPass", true);
            request.getRequestDispatcher("login.jsp").forward(request, response);

        } else {
            logger.info("successfully login, redirect /shop login: {}, password: {}",login,password);
            session.setAttribute("login", login);
            session.setAttribute("password", password);
            response.sendRedirect("shop");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
