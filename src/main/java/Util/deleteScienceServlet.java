package Util;

import Service.ProjectService;
import Service.ScienceService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "deleteScienceServlet", value = "/deleteScienceServlet")
public class deleteScienceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sno = request.getParameter("inputs");

        try {
            ScienceService.CommitSno(sno);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
