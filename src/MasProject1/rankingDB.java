package MasProject1;

import java.sql.*;

public class rankingDB {
    String url = "jdbc:mysql://localhost:3306/MasMMProject";
    String userName = "root";
    String password = "@summer0573";
    Connection con = DriverManager.getConnection(url, userName, password);
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("select * from users");

    public rankingDB() throws SQLException {

        while (rs.next()){
            String name = rs.getString("name");
            String difficulty = rs.getString("difficulty");
            int score = rs.getInt("score");
        }
    }
}
