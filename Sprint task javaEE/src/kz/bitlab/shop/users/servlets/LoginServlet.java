package kz.bitlab.shop.users.servlets;

import kz.bitlab.shop.users.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signIn")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/signIn.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Long userId = UserService.login(email, password);

        if (userId == null) {
            resp.sendRedirect("/signIn?invalidCredentials");
        } else {
            // Переход на страницу профиля после успешного входа
            resp.sendRedirect("/profile?id=" + userId);
        }
    }
}
