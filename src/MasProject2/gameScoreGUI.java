package MasProject2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

import MasProject1.*;
import MasProject3.GameView;

public class gameScoreGUI extends JFrame {

    JPanel Jp;
    JLabel JL;

    //게임 점수 화면
    public gameScoreGUI() throws SQLException {
//        UserDB RD = new UserDB();
//        int userScoreData = RD.score;

        GameView GV = new GameView();
        int userScoreData = GV.Fscore;

        final startGUI[] SG = new startGUI[1];


        setTitle("최종 점수");
        setSize(840, 720);
        setBackground(Color.WHITE);

//        System.out.println(userScoreData);

        Jp = new JPanel();
        JL = new JLabel("<html><body style='text-align:center;'>" +
                userScoreData +
                "개를 맞추셨습니다!" +
                "</body></html>");

        Font f = new Font("돋움", Font.PLAIN, 30);

        JL.setFont(f);
        JL.setBounds(270, 190, 350, 250);

        JButton startBtn = new JButton("다시 시작"); //시작 버튼

        startBtn.setPreferredSize(new Dimension(170, 120));
        startBtn.setBounds(600, 520, 170, 120);

        startBtn.setContentAreaFilled(false);
        startBtn.setFocusPainted(false);

        startBtn.setFont(f);

        add(startBtn);
        add(JL);
        add(Jp);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        startBtn.addActionListener(new ActionListener() { //게임 시작 이벤트
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SG[0] = new startGUI();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                setVisible(false);
            }
        });
    }


    public static void main(String[] args) throws SQLException {
        new gameScoreGUI();
    }
}
