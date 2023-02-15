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
        setSize(1500, 850);
        setBackground(Color.WHITE);

        System.out.println(userScoreData);

        JPanel Jp = new JPanel();
        JLabel Jl = new JLabel("<html><body style='text-align:center;'>" +
                userScoreData + "개를 맞추셨습니다!" +
                "</body></html>");

        Jl.setFont(Jl.getFont().deriveFont(30.0f));
        Jl.setBounds(590, 250, 350, 250);

        add(Jl);
        add(Jp);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }


    public static void main(String[] args) throws SQLException {
        new gameScoreGUI();
    }
}
