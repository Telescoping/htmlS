package Util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCTools {
    private static DataSource ds;

    static {//静态代码块，JDBCTools类初始化执行
        try {
            Properties pro = new Properties();
            InputStream is = JDBCTools.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static void free(Connection conn) throws SQLException {
        conn.close();//还给连接池
    }
}
