package Service;

import Dao.DepartmentDao;
import Dao.ScienceDao;
import JavaBean.Department;
import JavaBean.Science;
import Util.JDBCTools;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DepartmentService {
    public static Connection conn;

    public static void CommitSql(Department dt) throws SQLException {
        conn = JDBCTools.getConnection();
        conn.setAutoCommit(false);
        try {
            DepartmentDao.DepartmentAdd(dt);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            throw e;
        } finally {
            JDBCTools.free(conn);
        }
    }

    public static void CommitDno(String dno) throws SQLException {
        conn = JDBCTools.getConnection();
        conn.setAutoCommit(false);
        try {
            DepartmentDao.DeleteDepartment(dno);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            throw e;
        } finally {
            JDBCTools.free(conn);
        }
    }

    public static List<Department> ReceiveDepartment() throws SQLException {
        conn = JDBCTools.getConnection();
        List<Department> list = null;
        try {
            conn.setAutoCommit(false);
            list = DepartmentDao.DepartmentShow();
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            throw e;
        } finally {
            JDBCTools.free(conn);
        }
        return list;
    }

    public static void CommitModifySql(Department dt) throws SQLException {
        conn = JDBCTools.getConnection();
        conn.setAutoCommit(false);
        try {
            DepartmentDao.ModifyDepartment(dt);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            throw e;
        } finally {
            JDBCTools.free(conn);
        }
    }
}
