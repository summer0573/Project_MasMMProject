package MasProject2;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import MasProject1.*;

public class gameScoreGUI extends JFrame{

    //게임 점수 화면
    public gameScoreGUI() throws SQLException {
        UserDB RD = new UserDB();
        String userScoreData = RD.userScore;

        setTitle("masproject");
        setSize(840, 720);
        setBackground(Color.WHITE);

        System.out.println(userScoreData);

        JPanel Jp = new JPanel();
        JLabel JL = new JLabel("<html><body style='text-align:center;'>" +
                userScoreData + "개를 맞추셨습니다!" +
                "</body></html>");

        Font f = new Font("돋움", Font.PLAIN, 30);

        JL.setFont(f);
        JL.setFont(JL.getFont().deriveFont(30.0f));
        JL.setBounds(270, 190, 350, 250);

        add(JL);
        add(Jp);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }


    public static void main(String[] args) throws SQLException {
        new gameScoreGUI();
    }
}
