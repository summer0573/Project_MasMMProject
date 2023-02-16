package MasProject1;

import java.sql.*;

public class rankingShowDB {
    public rankingShowDB() throws SQLException {
        Connection con;
        Statement stmt;
        ResultSet rs;
        String url = "jdbc:mysql://localhost:3306/MasMMProject";
        String userName = "root";
        String password = "@summer0573";

        con = DriverManager.getConnection(url, userName, password);
        stmt = con.createStatement();
        rs = stmt.executeQuery("SELECT * FROM ranking_table");

        while (rs.next()) {
            System.out.print(rs.getString("name") + "\t");
            System.out.print(rs.getString("diff") + "\t");
            System.out.print(rs.getInt("score") + "\t");
            System.out.println("");
        }
        // 5. 자원 해제
        rs.close();
        stmt.close();
    }

    public static void main(String[] args) throws SQLException {
        new rankingShowDB();
    }
}
