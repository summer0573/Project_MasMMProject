package MasProject1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class howPlayGUI extends JFrame {
//게임 방법 설명 화면
    public howPlayGUI() {
        setTitle("masproject");
        setSize(840, 720);
        setBackground(Color.WHITE);

        JPanel Jp = new JPanel();
        JLabel Jl = new JLabel("<html><body style='text-align:center;'>1. 인물을 보고 해당 인물의 이름을 입력칸에 작성!<br />" +
                "2. 인물을 모르겠다면 패스 버튼!<br />" +
                "3. 최대한 많은 인물을 맞춰보아용</body></html>");
        JButton startBtn = new JButton("게임 시작");

        Jp.setLayout(new BorderLayout());

        Jl.setFont(Jl.getFont().deriveFont(30.0f));
        Jl.setBounds(60, 100, 700, 250);
//      Jl.setHorizontalAlignment(JLabel.CENTER);


        startBtn.setContentAreaFilled(false);
        startBtn.setFocusPainted(false);

        startBtn.setBounds(330, 500, 170, 120);
        startBtn.setPreferredSize(new Dimension(170, 120));


        add(startBtn);
        add(Jl);
        add(Jp);


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
