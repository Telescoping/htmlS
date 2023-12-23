package Service;

import Dao.ParticipatorDao;
import Dao.ScienceDao;
import JavaBean.Science;
import Util.JDBCTools;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ScienceService {
    public static Connection conn;

    public static void CommitSql(Science se) throws SQLException {
        conn = JDBCTools.getConnection();
        conn.setAutoCommit(false);
        try {
            ScienceDao.ScienceAdd(se);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            throw e;
        } finally {
            JDBCTools.free(conn);
        }
    }

    public static List<Science> ReceiveScience() throws SQLException {
        conn = JDBCTools.getConnection();
        List<Science> list = null;
        try {
            conn.setAutoCommit(false);
            list = ScienceDao.ScienceShow();
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            throw e;
        } finally {
            JDBCTools.free(conn);
        }
        return list;
    }

    public static void CommitSno(String sno) throws SQLException {
        conn = JDBCTools.getConnection();
        conn.setAutoCommit(false);
        try {
            ScienceDao.DeleteScience(sno);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            throw e;
        } finally {
            JDBCTools.free(conn);
        }
    }

    public static void CommitModifySql(Science se) throws SQLException {
        conn = JDBCTools.getConnection();
        conn.setAutoCommit(false);
        try {
            ScienceDao.ModifyScience(se);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            throw e;
        } finally {
            JDBCTools.free(conn);
        }
    }
}
