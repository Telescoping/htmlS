package Util;

import JavaBean.Science;
import JavaBean.User;
import Service.ScienceService;
import Service.loginService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "QueryScienceServlet", value = "/QueryScienceServlet")
public class QueryScienceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("json/application;charset=UTF-8");
        List<Science> list = null;
        try {
            list = ScienceService.ReceiveScience();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        JSONArray json = (JSONArray) JSONObject.toJSON(list);
        PrintWriter pw = response.getWriter();
        pw.print(json);
        System.out.println(json);
    }
}
