package Dao;

import JavaBean.Science;
import Service.ScienceService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ScienceDao {
    public static List<Science> ScienceShow() throws SQLException {
        PreparedStatement ps = ScienceService.conn.prepareStatement("select * from SCIENCEINFORMATION");
        ResultSet rs = ps.executeQuery();
        List<Science> scienceArrayList = new ArrayList<>();

        while (rs.next()) {
            String sno = rs.getString("sno");
            String sname = rs.getString("sname");
            String ssort = rs.getString("ssort");
            String slevel = rs.getString("slevel");
            String sgrade = rs.getString("sgrade");
            String srank = rs.getString("srank");
            String sdate = String.valueOf(rs.getDate("sdate"));
            Science sem = new Science(sno, sname, ssort, slevel, sgrade, srank, sdate);
            scienceArrayList.add(sem);
        }
        ps.close();
        rs.close();

        return scienceArrayList;
    }

    public static void ScienceAdd(Science se) throws SQLException {
        PreparedStatement ps = ScienceService.conn.prepareStatement("insert into SCIENCEINFORMATION (sno, sname, ssort," +
                "slevel, sgrade, srank, sdate) values (?, ?, ?, ?, ?, ?, to_date(?,'yyyy-mm-dd'))");
        ps.setString(1, se.getSno());
        ps.setString(2, se.getSname());
        ps.setString(3, se.getSsort());
        ps.setString(4, se.getSlevel());
        ps.setString(5, se.getSgrade());
        ps.setString(6, se.getSrank());
        ps.setString(7, se.getSdate());
        ps.executeUpdate();

        ps.close();
    }

    public static void DeleteScience(String sno) throws SQLException {
        PreparedStatement ps = ScienceService.conn.prepareStatement("select * from SCIENCEINFORMATION where sno = ?");
        ps.setString(1, sno);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            PreparedStatement pss = ScienceService.conn.prepareStatement("delete from SCIENCEINFORMATION where sno = ?");
            pss.setString(1, sno);
            pss.execute();
            pss.close();
            return;
        }
        ps.close();
    }

    public static void ModifyScience(Science se) throws SQLException {
        PreparedStatement ps = ScienceService.conn.prepareStatement("select * from SCIENCEINFORMATION where sno = ?");
        ps.setString(1, se.getSno());
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            PreparedStatement pss = ScienceService.conn.prepareStatement("update SCIENCEINFORMATION set sno = ?, sname = ?, ssort = ?, slevel = ?," +
                    " sgrade = ?, srank = ?, sdate = to_date(?, 'yyyy-mm-dd') where sno = ?");
            pss.setString(1, se.getSno());
            pss.setString(2, se.getSname());
            pss.setString(3, se.getSsort());
            pss.setString(4, se.getSlevel());
            pss.setString(5, se.getSgrade());
            pss.setString(6, se.getSrank());
            pss.setString(7, se.getSdate());
            pss.setString(8,se.getSno());
            pss.executeUpdate();
            pss.close();
        }
        ps.close();
    }
}
