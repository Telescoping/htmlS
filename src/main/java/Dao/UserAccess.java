package Dao;

import JavaBean.User;
import Service.loginService;
import JavaBean.dataSource;
import Util.isEqual;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserAccess {
    public static void getUserPassword(dataSource newData) throws SQLException {
        PreparedStatement ps = loginService.conn.prepareStatement("select pwd from LOGIN where username = ?");
        ps.setString(1, newData.getUsername());
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String pwd = rs.getString(1);
            isEqual.dataIsEqual(newData.getPassword(), pwd);
        }
        rs.close();
        ps.close();
    }

    public static List<User> UserShow() throws SQLException {
        PreparedStatement ps = loginService.conn.prepareStatement("select * from LOGIN");
        ResultSet rs = ps.executeQuery();
        java.util.List<User> list = new ArrayList<>();
        while (rs.next()) {
            String user =rs.getString("username");
            String pwd = rs.getString("pwd");
            User u = new User(user,pwd);
            list.add(u);
        }
        ps.close();
        rs.close();

        return list;


    }
}
