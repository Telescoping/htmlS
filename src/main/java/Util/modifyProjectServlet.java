package Util;

import JavaBean.Project;
import Service.ProjectService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "modifyProjectServlet", value = "/modifyProjectServlet")
public class modifyProjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] project = request.getParameterValues("inputs");

        Project pj = new Project(project[0], project[1], project[2], Long.parseLong(project[3]), project[4], project[5]);

        try {
            ProjectService.CommitModifyData(pj);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
