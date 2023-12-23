package Dao;

import JavaBean.Participator;
import Service.ParticipatorService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParticipatorDao {
    public static List<Participator> ParticipatorShow() throws SQLException {
        PreparedStatement ps = ParticipatorService.conn.prepareStatement("select * from PARTICIPATORINFORMATION");
        ResultSet rs = ps.executeQuery();
        List<Participator> participatorArrayList = new ArrayList<>();

        while (rs.next()) {
            String rno = rs.getString("rno");
            String rname = rs.getString("rname");
            String rsex = rs.getString("rsex");
            String rdate = String.valueOf(rs.getDate("rdate"));
            String rnation = rs.getString("rnation");
            String rdegree = rs.getString("rdegree");
            String dno = rs.getString("dno");
            String rjobtime = String.valueOf(rs.getDate("rjobtime"));
            String rtitle = rs.getString("rtitle");
            String rsalary = String.valueOf(rs.getLong("rsalary"));
            String rjobsalary = String.valueOf(rs.getLong("rjobsalary"));
            String rhelpsalary = String.valueOf(rs.getLong("rhelpsalary"));

            Participator ptr = new Participator(rno, rname, rsex, rdate,rnation, rdegree,  dno, rjobtime, rtitle,rsalary, rjobsalary, rhelpsalary);
            participatorArrayList.add(ptr);
        }
        ps.close();
        rs.close();

        return participatorArrayList;
    }

    public static void ParticipatorAdd(Participator pt) throws SQLException {
        PreparedStatement ps = ParticipatorService.conn.prepareStatement("insert into PARTICIPATORINFORMATION (rno, rname, rsex, rdate, rnation, rdegree, dno, " +
                "rjobtime, rtitle, rsalary, rjobsalary, rhelpsalary) values (?, ?, ?, to_date(?,'yyyy-mm-dd'), ?, ?, ?, to_date(?, 'yyyy-mm-dd'), ?, ?, ?, ?)");
        ps.setString(1, pt.getRno());
        ps.setString(2, pt.getRname());
        ps.setString(3, pt.getRsex());
        ps.setString(4, pt.getRdate());
        ps.setString(5, pt.getRnation());
        ps.setString(6, pt.getRdegree());
        ps.setString(7, pt.getDno());
        ps.setString(8, pt.getRjobtime());
        ps.setString(9, pt.getRtitle());
        ps.setString(10, pt.getRsalary());
        ps.setString(11, pt.getRjobsalary());
        ps.setString(12,pt. getRhelpsalary());
        ps.executeUpdate();
        ps.close();

    }

    public static void DeleteParticipator(String rno) throws SQLException {
        PreparedStatement ps = ParticipatorService.conn.prepareStatement("select * from PARTICIPATORINFORMATION where rno = ?");
        ps.setString(1, rno);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            PreparedStatement pss = ParticipatorService.conn.prepareStatement("delete from PARTICIPATORINFORMATION where rno = ?");
            pss.setString(1, rno);
            pss.execute();
            pss.close();
            return;
        }

        ps.close();
    }

    public static void ModifyParticipator(Participator pt) throws SQLException {
        PreparedStatement ps = ParticipatorService.conn.prepareStatement("select * from PARTICIPATORINFORMATION where rno = ?");
        ps.setString(1, pt.getRno());
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            PreparedStatement pss = ParticipatorService.conn.prepareStatement("update PARTICIPATORINFORMATION set rno = ?, rname = ?, rsex = ?, rdate = to_date(?, 'yyyy-mm-dd'), " +
                    "rnation = ?, rdegree = ?, dno = ?, rjobtime = to_date(?,'yyyy-mm-dd'), rtitle = ?, rsalary = ?, rjobsalary = ?, " +
                    "rhelpsalary = ?");
            pss.setString(1, pt.getRno());
            pss.setString(2, pt.getRname());
            pss.setString(3, pt.getRsex());
            pss.setString(4, pt.getRdate());
            pss.setString(5, pt.getRnation());
            pss.setString(6, pt.getRdegree());
            pss.setString(7, pt.getDno());
            pss.setString(8, pt.getRjobtime());
            pss.setString(9, pt.getRtitle());
            pss.setString(10, pt.getRsalary());
            pss.setString(11, pt.getRjobsalary());
            pss.setString(12, pt.getRhelpsalary());
            pss.executeUpdate();
            pss.close();
        }
        ps.close();
    }
}
