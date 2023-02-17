package MasProject1;

import java.sql.*;
import MasProject2.*;

public class UserDB {
//데이터 저장하기
    public String userScore;

    public UserDB() {
        test2 TT = new test2();
        int DT = TT.T2;

        String url = "jdbc:mysql://localhost:3306/MasMMProject";
        String userName = "root";
        String password = "@summer0573";

        //****임시 데이터
        String name = "구준표"; //플레이어 닉네임
        String diff = "1단계"; //플레이어가 선택한 난이도
        int score = 1; //플레이어가 문제를 맞춘 갯수
        ///
        
        scoreDateSG DSG = new scoreDateSG();
        DSG.setUserDT(String.valueOf(score));
        userScore = DSG.getUserDT();

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
