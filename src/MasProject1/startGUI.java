package MasProject1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class startGUI extends JFrame{

    public startGUI(){
        setTitle("masproject");

        JPanel Jpanel = new JPanel();
        JButton startBtn = new JButton("게임 시작"); //시작 버튼
        JButton howPlayBtn = new JButton("게임 방법"); //게임 방법 안내 버튼

        setSize(1500, 850);
        setBackground(Color.WHITE);

        startBtn.setContentAreaFilled(false);
        startBtn.setFocusPainted(false);

        howPlayBtn.setContentAreaFilled(false);
        howPlayBtn.setFocusPainted(false);

        startBtn.setPreferredSize(new Dimension(170, 120));
        startBtn.setBounds(550, 530, 170, 120);

        howPlayBtn.setPreferredSize(new Dimension(170, 120));
        howPlayBtn.setBounds(750, 530, 170, 120);

        Jpanel.add(startBtn);
        Jpanel.add(howPlayBtn);
        add(Jpanel);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Frame();
                setVisible(false);
            }
        });

        howPlayBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new howPlayGUI();
                setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        new startGUI();
    }
}
