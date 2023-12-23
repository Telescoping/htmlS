package Service;

import Dao.DepartmentDao;
import Dao.ParticipatorDao;
import Dao.ScienceDao;
import JavaBean.Participator;
import JavaBean.Science;
import Util.JDBCTools;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ParticipatorService {
    public static Connection conn;

    public static void CommitSql(Participator pt) throws SQLException {
        conn = JDBCTools.getConnection();
        conn.setAutoCommit(false);
        try {
            ParticipatorDao.ParticipatorAdd(pt);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            throw e;
        } finally {
            JDBCTools.free(conn);
        }
    }
    public static List<Participator> ReceiveParticipator() throws SQLException {
        conn = JDBCTools.getConnection();
        List<Participator> list = null;
        try {
            conn.setAutoCommit(false);
            list = ParticipatorDao.ParticipatorShow();
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            throw e;
        } finally {
            JDBCTools.free(conn);
        }
        return list;
    }

    public static void CommitPTno(String rno) throws SQLException {
        conn = JDBCTools.getConnection();
        conn.setAutoCommit(false);
        try {
            ParticipatorDao.DeleteParticipator(rno);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            throw e;
        } finally {
            JDBCTools.free(conn);
        }
    }

    public static void CommitModifySql(Participator pt) throws SQLException {
        conn = JDBCTools.getConnection();
        conn.setAutoCommit(false);
        try {
            ParticipatorDao.ModifyParticipator(pt);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            throw e;
        } finally {
            JDBCTools.free(conn);
        }
    }
}
