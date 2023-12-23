package Service;

import Dao.UserSubmit;
import Util.JDBCTools;
import JavaBean.dataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class registerService {
    public static Connection conn;

    public static void dataCommit(dataSource newData) throws SQLException {
        conn = JDBCTools.getConnection();
        conn.setAutoCommit(false);
        try {
            UserSubmit.dataSubmitOracle(newData);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            throw e;
        } finally {
            JDBCTools.free(conn);
        }
    }
}
