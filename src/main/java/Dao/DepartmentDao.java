package Dao;

import JavaBean.Department;
import Service.DepartmentService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DepartmentDao {
    public static List<Department> DepartmentShow() throws SQLException {
        PreparedStatement ps = DepartmentService.conn.prepareStatement("select * from DEPARTMENTINFORMATION");
        ResultSet rs = ps.executeQuery();
        List<Department> DepartmentList = new ArrayList<>();

        while (rs.next()) {
            String dno = rs.getString("dno");
            String dname = rs.getString("dname");
            String dcontrol = rs.getString("dcontrol");
            String dadress = rs.getString("dadress");
            String dpostcode = rs.getString("dpostcode");
            Long dphone = rs.getLong("dphone");
            Department dtt = new Department(dno, dname, dcontrol, dadress, dpostcode, dphone);
            DepartmentList.add(dtt);
        }
        ps.close();
        rs.close();

        return DepartmentList;
    }

    public static void DepartmentAdd(Department dm) throws SQLException {
        PreparedStatement ps = DepartmentService.conn.prepareStatement("insert into DEPARTMENTINFORMATION (dno, dname, dcontrol, dadress, dpostcode, dphone) values (?, ?, ?, ?, ?, ?)");
        ps.setString(1, dm.getDno());
        ps.setString(2, dm.getDname());
        ps.setString(3, dm.getDcontrol());
        ps.setString(4, dm.getDadress());
        ps.setString(5, dm.getDpostcode());
        ps.setLong(6, dm.getDphone());
        ps.executeUpdate();

        ps.close();
    }

    public static void DeleteDepartment(String dno) throws SQLException {
        PreparedStatement ps = DepartmentService.conn.prepareStatement("select * from DEPARTMENTINFORMATION where dno = ?");
        ps.setString(1, dno);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            PreparedStatement pss = DepartmentService.conn.prepareStatement("delete from DEPARTMENTINFORMATION where dno = ?");
            pss.setString(1, dno);
            pss.execute();
            pss.close();
            return;
        }
        ps.close();
        rs.close();
    }

    public static void ModifyDepartment(Department dm) throws SQLException {
        PreparedStatement ps = DepartmentService.conn.prepareStatement("select * from DEPARTMENTINFORMATION where dno = ?");
        ps.setString(1, dm.getDno());
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            PreparedStatement pss = DepartmentService.conn.prepareStatement("update DEPARTMENTINFORMATION set " +
                    "dno = ?, dname = ?, dcontrol = ?, dadress = ?, dpostcode = ?, dphone = ?");
            pss.setString(1, dm.getDno());
            pss.setString(2, dm.getDname());
            pss.setString(3, dm.getDcontrol());
            pss.setString(4, dm.getDadress());
            pss.setString(5, dm.getDpostcode());
            pss.setLong(6, dm.getDphone());
            pss.executeUpdate();
            pss.close();
        }

        ps.close();
    }
}
