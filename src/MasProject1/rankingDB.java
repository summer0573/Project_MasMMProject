package MasProject1;

import java.sql.*;
import MasProject2.*;

public class rankingDB {

    public String userScore;

    public rankingDB() throws SQLException {
        test2 TT = new test2();
        int DT = TT.T2;

        String url = "jdbc:mysql://localhost:3306/MasMMProject";
        String userName = "root";
        String password = "@summer0573";

        //****임시 데이터
        String name = "김마스"; //플레이어 닉네임
        String diff = "2단계"; //플레이어가 선택한 난이도
        int score = 10; //플레이어가 문제를 맞춘 갯수
        
        scoreDateSG DSG = new scoreDateSG();
        DSG.setUserDT(String.valueOf(score));
        userScore = DSG.getUserDT();

//        try {
////데이터베이스불러오기
//            Connection connection = DriverManager.getConnection(url, userName, password);
//            Statement stmt = connection.createStatement();
//
//            stmt.executeUpdate(" INSERT INTO ranking_table(name, diff, score)  VALUES ('" + name + "', '" + diff + "', '" + score + "')");//테이블에 스코어를 추가 시키는 큐리문
//
//
//        } catch (SQLException e) {
//            System.out.println(e);
//        }

        /*TRUNCATE
        jlabel로 점수 데이터 확인하기
        아니면 dialog로 새창 띄우기

        게임 내에서 이름, 단계, 데이터 받고
        테이블에 저장한 다음
        점수 화면에 띄우고
        시작창에 최신순으로 띄우기
        */

        /*
        int num=1;
        try {
//데이터베이스불러오기
            Connection connection = DriverManager.getConnection(url, userName, password);
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(" INSERT INTO user_scoer_tabel(user_name,user_scoer)  VALUES ('" + name + "', '" + score + "')");//테이블에 스코어를 추가 시키는 큐리문
            ResultSet rs = stmt.executeQuery("SELECT * FROM user_scoer_tabel ORDER BY user_scoer DESC;");//데이터베이스에서 가져오는 큐리문
            while(num<=10 && http://rs.next()){//rs 에는 불러온 테이블 내용이 배열 처럼 들어 있으므로 반복문을 이용하여 불러온다
//num 은 등수 표시하기 위해 만든 거니까 무시해도 된다.
                scoret+=" "+num++;
                scoret+= "\t| "+rs.getString(1)+"\t| "+rs.getString(2)+"\n";
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        dialog.setScoreTest(scoret);
        dialog.setVisible(true);
    }
        * */



    }

    public static void main(String[] args) throws SQLException {
        new rankingDB();
    }
}
