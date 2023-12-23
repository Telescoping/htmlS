package Util;

import Dao.ParticipatorDao;
import Service.DepartmentService;
import Service.ParticipatorService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "deleteParticipatorServlet", value = "/deleteParticipatorServlet")
public class deleteParticipatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rno = request.getParameter("inputs");

        try {
            ParticipatorService.CommitPTno(rno);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
