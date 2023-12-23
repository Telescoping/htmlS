package Util;

import JavaBean.Science;
import Service.ScienceService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "addScienceServlet", value = "/addScienceServlet")
public class addScienceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] science = request.getParameterValues("inputs");

        Science se = new Science(science[0], science[1], science[2], science[3], science[4], science[5], science[6]);

        try {
            ScienceService.CommitSql(se);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
