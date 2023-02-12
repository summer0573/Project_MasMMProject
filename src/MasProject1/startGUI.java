package MasProject1;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import MasProject2.gameScoreDialog;

public class startGUI extends JFrame{
//처음 시작 화면
    public startGUI() {
        setTitle("masproject");
        setSize(1500, 850);
        setBackground(Color.WHITE);

        JPanel Jp = new JPanel();
        JButton startBtn = new JButton("게임 시작"); //시작 버튼
        JButton howPlayBtn = new JButton("게임 방법"); //게임 방법 안내 버튼

        startBtn.setContentAreaFilled(false);
        startBtn.setFocusPainted(false);

        howPlayBtn.setContentAreaFilled(false);
        howPlayBtn.setFocusPainted(false);

        startBtn.setPreferredSize(new Dimension(170, 120));
        startBtn.setBounds(550, 630, 170, 120);

        howPlayBtn.setPreferredSize(new Dimension(170, 120));
        howPlayBtn.setBounds(750, 630, 170, 120);

        add(startBtn);
        add(howPlayBtn);
        add(Jp);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        startBtn.addActionListener(new ActionListener() { //게임 시작 이벤트
            @Override
            public void actionPerformed(ActionEvent e) {
                new Frame();
                setVisible(false);
            }
        });

        howPlayBtn.addActionListener(new ActionListener() { //게임 방법 이벤트
            @Override
            public void actionPerformed(ActionEvent e) {
                new howPlayGUI();
                setVisible(false);
            }
        });
    }

    public static void main(String[] args) throws SQLException {
        new startGUI();
    }
}
