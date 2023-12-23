package Util;

import JavaBean.Department;
import JavaBean.Project;
import Service.DepartmentService;
import Service.ProjectService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "QueryProjectServlet", value = "/QueryProjectServlet")
public class QueryProjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("json/application;charset=UTF-8");
        List<Project> list = null;
        try {
            list = ProjectService.ReceiveProject();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        JSONArray json = (JSONArray) JSONObject.toJSON(list);
        PrintWriter pw = response.getWriter();
        pw.print(json);
        System.out.println(json);
    }
}
