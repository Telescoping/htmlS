package Util;

import JavaBean.Department;
import Service.DepartmentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "modifyDepartmentServlet", value = "/modifyDepartmentServlet")
public class modifyDepartmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] department = request.getParameterValues("inputs");

        Department dt = new Department(department[0], department[1], department[2], department[3], department[4], Long.parseLong(department[5]));
        try {
            DepartmentService.CommitModifySql(dt);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
