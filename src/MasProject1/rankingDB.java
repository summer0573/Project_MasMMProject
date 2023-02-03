package MasProject1;

import java.sql.*;

public class rankingDB {

    public rankingDB() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/MasMMProject";
        String userName = "root";
        String password = "@summer0573";

        String difficulty = "4단계";
        String name = "??";
        int score = 6;

        int num = 1;
        try {
//데이터베이스불러오기
            Connection connection = DriverManager.getConnection(url, userName, password);
            Statement stmt = connection.createStatement();

            switch (difficulty) {
                case "1단계":
                    stmt.executeUpdate(" INSERT INTO diffi1_table(name, score)  VALUES ('" + name + "', '" + score + "')");//테이블에 스코어를 추가 시키는 큐리문
                    break;
                case "2단계":
                    stmt.executeUpdate(" INSERT INTO diffi2_table(name, score)  VALUES ('" + name + "', '" + score + "')");//테이블에 스코어를 추가 시키는 큐리문
                    break;
                case "3단계":
                    stmt.executeUpdate(" INSERT INTO diffi3_table(name, score)  VALUES ('" + name + "', '" + score + "')");//테이블에 스코어를 추가 시키는 큐리문
                    break;
                case "4단계":
                    stmt.executeUpdate(" INSERT INTO diffi4_table(name, score)  VALUES ('" + name + "', '" + score + "')");//테이블에 스코어를 추가 시키는 큐리문
                    break;
            }


        } catch (SQLException e) {
            System.out.println(e);
        }
//        dialog.setScoreTest(scoret);
//        dialog.setVisible(true);
    }

    public static void main(String[] args) throws SQLException {
        new rankingDB();
    }
}
