package MasProject1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class howPlayGUI extends JFrame {

    public howPlayGUI() {
        setTitle("masproject");

        JPanel Jpanel = new JPanel();
        JButton startBtn = new JButton("게임 시작");

        setSize(1500, 850);
        setBackground(Color.WHITE);

        startBtn.setContentAreaFilled(false);
        startBtn.setFocusPainted(false);

        startBtn.setPreferredSize(new Dimension(170, 120));
        startBtn.setBounds(550, 530, 170, 120);

        Jpanel.add(startBtn);
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

    }

    public static void main(String[] args) {
        new howPlayGUI();
    }

}
