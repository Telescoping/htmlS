package Util;

import JavaBean.Project;
import Service.ProjectService;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@WebServlet(name = "addProjectServlet", value = "/addProjectServlet")
public class addProjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] project = request.getParameterValues("inputs");

        Project pj = new Project(project[0], project[1], project[2], Long.parseLong(project[3]), project[4], project[5]);

        try {
            ProjectService.CommitData(pj);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
