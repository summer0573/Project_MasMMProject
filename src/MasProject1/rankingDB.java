package MasProject1;

import java.sql.*;

public class rankingDB {

    public rankingDB() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/MasMMProject";
        String userName = "root";
        String password = "@summer0573";
        Connection con = DriverManager.getConnection(url, userName, password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from protable");

        while (rs.next()) {
            String name = rs.getString("name");
            String difficulty = rs.getString("difficulty");
            int score = rs.getInt("score");

//            System.out.print(name + "\t" + difficulty + "\t" + score + "\n");
        }
    }

    public static void main(String[] args) throws SQLException {
        new rankingDB();
    }
}
