package MasProject1;

import java.awt.*;
import java.sql.*;
import java.util.List;
import javax.swing.*;

public class rankingShowDB {
    public rankingShowDB() throws SQLException {

    }


    ///////////////////////////////////////////////////////////////

    Connection con;
    Statement stmt;
    ResultSet rs;


    public void empList() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/MasMMProject";
        String userName = "root";
        String password = "@summer0573";

        con = DriverManager.getConnection(url, userName, password);
        stmt = con.createStatement();
        rs = stmt.executeQuery("SELECT * FROM ranking_table");

        while (rs.next()) {
            System.out.println(rs.getString("name"));
            System.out.println(rs.getString("diff"));
            System.out.println(rs.getInt("score"));
        }
        // 5. 자원 해제
        rs.close();
        stmt.close();
    }


    public static void main(String[] args) throws SQLException {

    }

}
