package Dao;

import JavaBean.Project;
import Service.ProjectService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProjectDao {
    public static List<Project> ProjectShow() throws SQLException {
        PreparedStatement ps = ProjectService.conn.prepareStatement("select * from PROJECTINFORMATION");
        ResultSet rs = ps.executeQuery();
        List<Project> ProjectList = new ArrayList<>();
        while (rs.next()) {
            String pno = rs.getString("pno");
            String pname = rs.getString("pname");
            String pfrom = rs.getString("pfrom");
            Long pmoney = rs.getLong("pmoney");
            String ptime = String.valueOf(rs.getDate("ptime"));
            String prole = rs.getString("prole");
            Project pjt = new Project(pno, pname, pfrom, pmoney, ptime, prole);
            ProjectList.add(pjt);
        }
        ps.close();
        rs.close();

        return ProjectList;

    }

    public static void ProjectAdd(Project pj) throws SQLException {
        PreparedStatement ps = ProjectService.conn.prepareStatement("insert into PROJECTINFORMATION (pno, pname, pfrom," +
                "pmoney, ptime, prole) values (?, ?, ?, ?, to_date(?, 'yyyy-mm-dd'), ?)");
        ps.setString(1, pj.getPno());
        ps.setString(2, pj.getPname());
        ps.setString(3, pj.getPfrom());
        ps.setLong(4, pj.getPmoney());
        ps.setString(5, pj.getPtime());
        ps.setString(6, pj.getProle());
        ps.executeUpdate();
        ps.close();

    }

    public static void DeleteProject(String pno) throws SQLException {
        PreparedStatement ps = ProjectService.conn.prepareStatement("select pno from PROJECTINFORMATION" +
                " where pno = ? ");
        ps.setString(1, pno);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            PreparedStatement pss = ProjectService.conn.prepareStatement("delete from PROJECTINFORMATION" +
                    " where pno = ?");
            pss.setString(1, pno);
            pss.execute();
            pss.close();
            return;
        }
        ps.close();
    }

    public static void ModifyProject(Project pj) throws SQLException {
        PreparedStatement ps = ProjectService.conn.prepareStatement("select * from PROJECTINFORMATION " +
                "where pno = ?");
        ps.setString(1, pj.getPno());
        ResultSet rs = ps.executeQuery();


        while (rs.next()) {

            PreparedStatement pss = ProjectService.conn.prepareStatement("update projectinformation set pno = ?, pname = ?, pfrom = ?, pmoney = ?, ptime = to_date(?,'yyyy-mm-dd'), prole = ? where pno = ?");
            pss.setString(1, pj.getPno());
            pss.setString(2, pj.getPname());
            pss.setString(3, pj.getPfrom());
            pss.setLong(4, pj.getPmoney());
            pss.setString(5, pj.getPtime());
            pss.setString(6, pj.getProle());
            pss.setString(7, pj.getPno());
            pss.executeUpdate();
            pss.close();
        }

        ps.close();
    }
}
