package Util;

import JavaBean.Participator;
import Service.ParticipatorService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "QueryParticipatorServlet", value = "/QueryParticipatorServlet")
public class QueryParticipatorServlet extends HttpServlet {
    private static final long serialVersionUID = -4186928407001085733L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("json/application;charset=UTF-8");
        List<Participator> list = null;
        try {
            list = ParticipatorService.ReceiveParticipator();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        JSONArray json = (JSONArray) JSONObject.toJSON(list);
        PrintWriter pw = response.getWriter();
        pw.print(json);
        System.out.println(json);
    }
}
