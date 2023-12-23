package Service;

import Dao.UserAccess;
import JavaBean.User;
import Util.JDBCTools;
import JavaBean.dataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class loginService {
    public static Connection conn;

    public static void CommitData(dataSource newData) throws SQLException {
        conn = JDBCTools.getConnection();
        conn.setAutoCommit(false);
        try {
            UserAccess.getUserPassword(newData);
            conn.commit();
        }catch (Exception e) {
            conn.rollback();
            throw e;
        }finally {
            JDBCTools.free(conn);
        }
    }
    public static List<User> getUserInfo() throws SQLException {
        conn = JDBCTools.getConnection();
        conn.setAutoCommit(false);
        List<User> list;
        try {
            list = UserAccess.UserShow();
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            throw e;
        } finally {
            JDBCTools.free(conn);
        }
        return list;
    }
}
