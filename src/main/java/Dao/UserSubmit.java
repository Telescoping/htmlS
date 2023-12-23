package Dao;

import Service.registerService;
import JavaBean.dataSource;
import Util.isEqual;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserSubmit {
    public static void dataSubmitOracle(dataSource newData) throws SQLException {
        PreparedStatement ps = registerService.conn.prepareStatement("insert into LOGIN (username,pwd) values (?,?)");
        ps.setString(1, newData.getUsername());
        ps.setString(2, newData.getPassword());
        ps.executeUpdate();

        isEqual.dataIsEqual("1", "1");
        ps.close();

    }
}
