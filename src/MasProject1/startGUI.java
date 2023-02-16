package MasProject1;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class startGUI extends JFrame {

    JPanel JP;
    JScrollPane JSP;
    JLabel JL;

    //처음 시작 화면
    public startGUI() throws SQLException {

        JP = new JPanel();

        setTitle("masproject");
        setSize(840, 720);
        setBackground(Color.WHITE);

        JButton startBtn = new JButton("게임 시작"); //시작 버튼
        JButton howPlayBtn = new JButton("게임 방법"); //게임 방법 안내 버튼

        startBtn.setContentAreaFilled(false);
        startBtn.setFocusPainted(false);

        howPlayBtn.setContentAreaFilled(false);
        howPlayBtn.setFocusPainted(false);

        startBtn.setPreferredSize(new Dimension(170, 120));
        startBtn.setBounds(220, 550, 170, 120);

        howPlayBtn.setPreferredSize(new Dimension(170, 120));
        howPlayBtn.setBounds(440, 550, 170, 120);

        ////////////////////////////////////

        Connection con;
        Statement stmt;
        ResultSet rs;
        String url = "jdbc:mysql://localhost:3306/MasMMProject";
        String userName = "root";
        String password = "@summer0573";


        con = DriverManager.getConnection(url, userName, password);
        stmt = con.createStatement();
        rs = stmt.executeQuery("SELECT * FROM ranking_table");

        String DBJL ="<html><body style='text-align:center;'>";

        while (rs.next()) {

            DBJL +=
                    rs.getString("name") + " " +
                    rs.getString("diff") + " " +
                    rs.getInt("score") + "점<br />";

        }
        // 5. 자원 해제
        rs.close();
        stmt.close();

        DBJL += "</body></html>";

        JL = new JLabel(DBJL,JLabel.CENTER);
        JSP = new JScrollPane(JL);


        JL.setFont(JL.getFont().deriveFont(20.0f));
        JL.setBounds(0, 0, 250, 300);
        JSP.setBounds(265, 200, 300, 300);

        ///////////////////////////////////////


        add(startBtn);
        add(howPlayBtn);
        add(JSP);
        add(JP);

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
