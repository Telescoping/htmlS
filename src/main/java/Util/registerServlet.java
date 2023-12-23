package Util;

import JavaBean.dataSource;
import Service.registerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "registerServlet", value = "/registerServlet")
public class registerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        dataSource newData = new dataSource();
        newData.setUsername(username);
        newData.setPassword(password);

        try {
            registerService.dataCommit(newData);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (isEqual.getFlag()) {
            response.sendRedirect(request.getContextPath() + "/View/hello.html");
        }
    }
}
