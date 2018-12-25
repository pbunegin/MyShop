package servlets;


import dao.Dao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pojo.Category;
import pojo.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/shop")
public class MainServlet extends HttpServlet {
    public static final Logger logger = LoggerFactory.getLogger(MainServlet.class);
    private List<Category> categories;

    @Override
    public void init() throws ServletException {
        super.init();
        categories = new Dao().getAllCategories();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String login = (String) session.getAttribute("login");
        String password = (String) session.getAttribute("password");
        if (login == null || password == null) {
            logger.info("redirect /login login: {}, password: {}",login,password);
            response.sendRedirect("login");
            return;
        }
        logger.info("successfully login: {}, password: {}",login,password);

        request.setAttribute("categories", categories);
        request.setAttribute("login", login);

        request.getRequestDispatcher("main.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}