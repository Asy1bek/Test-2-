package kz.bitlab.shop.users.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userIdParam = req.getParameter("id");

        if (userIdParam != null && !userIdParam.isEmpty()) {
            Long userId = Long.parseLong(userIdParam);
            String username = getUsernameById(userId);

            if (username != null) {
                req.setAttribute("username", username);
                req.getRequestDispatcher("/profile.jsp").forward(req, resp);
            } else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Пользователь не найден");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Неверный идентификатор пользователя");
        }
    }
    private String getUsernameById(Long userId) {
        if (userId == 1) {
            return "John Doe";
        } else {
            return null; 
        }
    }
}
