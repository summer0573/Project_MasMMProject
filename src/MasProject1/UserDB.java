package MasProject1;

import java.sql.*;
import MasProject2.*;
import MasProject3.*;

public class UserDB {

    public String name;
    public int diff;
    public int score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDiff() {
        return diff;
    }

    public void setDiff(int diff) {
        this.diff = diff;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
//데이터 저장하기

    public UserDB() {
        String url = "jdbc:mysql://localhost:3306/MasMMProject";
        String userName = "root";
        String password = "@summer0573";

        GameView GV = new GameView();
        String name = GV.name;
        String diff = GV.diff + "단계";
        int score = GV.Fscore;

        System.out.println(name);
        System.out.println(diff);
        System.out.println(score);

        try {
//데이터베이스불러오기
            Connection connection = DriverManager.getConnection(url, userName, password);
            Statement stmt = connection.createStatement();

            stmt.executeUpdate(" INSERT INTO ranking_table(name, diff, score)  VALUES ('" + name + "', '" + diff + "', '" + score + "')");//테이블에 스코어를 추가 시키는 큐리문


        } catch (SQLException e) {
            System.out.println(e);
        }

        /*TRUNCATE
        jlabel로 점수 데이터 확인하기
        아니면 dialog로 새창 띄우기

        게임 내에서 이름, 단계, 데이터 받고
        테이블에 저장한 다음
        점수 화면에 띄우고
        시작창에 최신순으로 띄우기
        */

    }

    public static void main(String[] args) throws SQLException {
        new UserDB();
    }
}
