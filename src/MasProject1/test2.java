package MasProject1;

import java.sql.SQLException;

public class test2 {
    int T2;
    int T3 = 5;
    public  test2(){
        test T = new test();
        T.setT(T3);
        T2 = T.getT();

    }
    public static void main(String[] args) {
        new test2();
    }
}

//package game;
//
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.*;
//
//public class test2 {
//    JFrame difficultyFrame = new JFrame("게임 난이도 선택");
//    JFrame GameFrame = new JFrame("게임 화면");
//    int difficulty; // 게임 난이도 저장 변수
//    String nickname; // 닉네임
//
//    public test2() {
//        difficultyFrame();
//    }
//
//    public void difficultyFrame() { // 난이도 선택, 닉네임 설정 Frame
//
//        JPanel difficultyPanel = new JPanel(null); // 난이도 선택 Panel
//        difficultyPanel.setBounds(0, 0, 840, 720);
//        difficultyPanel.setVisible(true);
//        difficultyFrame.add(difficultyPanel);
//
//        JPanel NicknamePanel = new JPanel(null); // 닉네임 설정 Panel
//        NicknamePanel.setBounds(0, 0, 840, 720);
//        NicknamePanel.setVisible(false);
//        difficultyFrame.add(NicknamePanel);
//
//        JButton[] difficultyBtn = new JButton[4]; //단계 선택 버튼
//
//        for (int i = 0; i < difficultyBtn.length; i++) {
//            difficultyBtn[i] = new JButton((i + 1) + "단계");
//            difficultyBtn[i].setFont(new Font("굴림", Font.BOLD, 20));
//            difficultyBtn[i].setBackground(Color.YELLOW);
//            difficultyBtn[i].setBounds((i + 2) * 55 + i * 100, 300, 150, 120);
//            difficultyPanel.add(difficultyBtn[i]);
//        }
//
//        JLabel NicknameLbl = new JLabel("닉네임을 입력하세요");
//        NicknameLbl.setBounds(300, 120, 500, 200);
//        NicknameLbl.setFont(new Font("고딕", Font.BOLD, 25));
//        NicknamePanel.add(NicknameLbl);
//
//        JTextField InpNickname = new JTextField(); // 닉네임 입력 텍스트필드
//        InpNickname.setBounds(300, 330, 250, 50);
//        InpNickname.setHorizontalAlignment(SwingConstants.CENTER); // InpName을 텍스트필드의 가운데로 설정
//        NicknamePanel.add(InpNickname);
//
//        JButton setNickname = new JButton("확인");
//        setNickname.setBounds(350, 420, 150, 100);
//        setNickname.setFont(new Font("굴림", Font.BOLD, 20));
//        setNickname.setBackground(Color.CYAN);
//        NicknamePanel.add(setNickname);
//
//        for (int i = 0; i < difficultyBtn.length; i++) {
//            difficultyBtn[i].addActionListener(new ActionListener() {
//
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    for (int j = 0; j < difficultyBtn.length; j++) {
//                        if (difficultyBtn[j] == e.getSource()) {
//                            difficulty = j + 1;
//                        }
//                    }
//                    difficultyPanel.setVisible(false);
//                    NicknamePanel.setVisible(true);
//
//                }
//            });
//        }
//
//        setNickname.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                nickname = InpNickname.getText();
//                System.out.println(nickname);
//                JOptionPane.showMessageDialog(null, "닉네임이 설정되었습니다! 곧 게임이 시작됩니다.");
//
//                NicknamePanel.setVisible(false);
//                difficultyFrame.setVisible(false);
//                GameFrame();
//
//            }
//        });
//
//        difficultyFrame.setResizable(false); // 창 크기 조절 불가
//        difficultyFrame.setSize(840, 720);
//        difficultyFrame.setLocationRelativeTo(null); // 창을 정중앙에서 출력
//        difficultyFrame.setVisible(true); // 창이 화면에 보이게
//        difficultyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫았을 때 프로그램이 종료되게 함
//    }
//
//    public void stage1() {
//        JPanel stage1 = new JPanel(null); //1단계 화면
//        stage1.setBounds(0, 0, 840, 720);
//        GameFrame.add(stage1);
//
//        JLabel stage1Img = new JLabel(); //1단계 문제 이미지 Label
//        stage1Img.setBounds(300, 200, 100, 100);
//        stage1Img.setIcon(new ImageIcon("Images/test1.png"));
//        stage1.add(stage1Img);
//
//        stage1.setVisible(true);
//        System.out.println("1번 열림");
//        System.out.println("1번 사진 열림");
//    }
//    public void stage2() {
//
//    }
//
//    public void stage3() {
//
//    }
//
//    public void stage4() {
//
//    }
//
//    public void GameFrame() {
//
//        if (difficulty == 1) {
//            stage1();
//
//        } else if (difficulty == 2) {
//
//        } else if (difficulty == 3) {
//
//        } else if (difficulty == 4) {
//
//        }
//
//        GameFrame.setLayout(null);
//        GameFrame.setVisible(true);
//        GameFrame.setResizable(false);
//        GameFrame.setSize(840, 720);
//        GameFrame.setLocationRelativeTo(null);
//        GameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
//
//    public static void main(String[] args) {
//        new test2();
//    }
//
//}