package Util;

import JavaBean.dataSource;
import Service.loginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class loginServlet extends HttpServlet {
    private static final long serialVersionUID = -4186928407001085733L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        dataSource newData = new dataSource();
        newData.setUsername(username);
        newData.setPassword(password);

        try {
            loginService.CommitData(newData);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (isEqual.getFlag()) {
            resp.sendRedirect(req.getContextPath() + "/View/hello.html");
        }
    }
}