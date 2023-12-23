package Service;

import Dao.ParticipatorDao;
import Dao.ProjectDao;
import Dao.ScienceDao;
import JavaBean.Project;
import JavaBean.Science;
import Util.JDBCTools;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProjectService {
    public static Connection conn;
    public static void CommitData(Project pj) throws SQLException {
        conn = JDBCTools.getConnection();
        conn.setAutoCommit(false);
        try {
            ProjectDao.ProjectAdd(pj);
            conn.commit();
        }catch (Exception e) {
            conn.rollback();
            throw  e;
        }finally {
            JDBCTools.free(conn);
        }
    }
    public static List<Project> ReceiveProject() throws SQLException {
        conn = JDBCTools.getConnection();
        List<Project> list = null;
        try {
            conn.setAutoCommit(false);
            list = ProjectDao.ProjectShow();
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            throw e;
        } finally {
            JDBCTools.free(conn);
        }
        return list;
    }

    public static void CommitPno(String pno) throws SQLException {
        conn = JDBCTools.getConnection();
        conn.setAutoCommit(false);
        try {
            ProjectDao.DeleteProject(pno);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            throw e;
        } finally {
            JDBCTools.free(conn);
        }
    }
    public static void CommitModifyData(Project pj) throws SQLException {
        conn = JDBCTools.getConnection();
        conn.setAutoCommit(false);
        try {
            ProjectDao.ModifyProject(pj);
            conn.commit();
        }catch (Exception e) {
            conn.rollback();
            throw  e;
        }finally {
            JDBCTools.free(conn);
        }
    }
}
