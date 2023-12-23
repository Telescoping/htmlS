package Util;

import JavaBean.Participator;
import Service.ParticipatorService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "addParticipatorServlet", value = "/addParticipatorServlet")
public class addParticipatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] participator = request.getParameterValues("inputs");

        Participator pt = new Participator(participator[0], participator[1], participator[2], participator[3], participator[4], participator[5],
                participator[6], participator[7], participator[8], participator[9], participator[10], participator[11]);

        try {
            ParticipatorService.CommitSql(pt);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
