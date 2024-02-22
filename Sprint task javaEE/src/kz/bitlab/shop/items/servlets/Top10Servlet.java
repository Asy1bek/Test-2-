package kz.bitlab.shop.items.servlets;

import kz.bitlab.shop.items.service.ItemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/top10")
public class Top10Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("itemList", ItemService.findTop10());
        req.getRequestDispatcher("/top10.jsp").forward(req, resp);
    }
}
