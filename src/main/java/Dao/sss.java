package Dao;

import JavaBean.Department;
import JavaBean.Participator;
import JavaBean.Project;
import JavaBean.Science;
import Service.DepartmentService;
import Service.ParticipatorService;
import Service.ProjectService;
import Service.ScienceService;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class sss {
    public static void main(String[] args) throws SQLException {
        List<Project> list = ProjectService.ReceiveProject();
        Iterator<Project> iterator = list.iterator();
        while (iterator.hasNext()) {
            Project pjt = iterator.next();
            System.out.printf("%-11s %-11s %-11s %-11s %-11s %-11s\n", pjt.getPno(), pjt.getPname(), pjt.getPfrom(), pjt.getPmoney()
                    , pjt.getPtime(), pjt.getProle());
        }
    }
}
