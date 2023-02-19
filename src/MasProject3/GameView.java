package MasProject3;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import MasProject1.*;
import MasProject2.*;

public class GameView {
    JFrame difficultyFrame = new JFrame("게임 난이도 선택");
    JFrame GameFrame = new JFrame("게임 화면");

    static int difficulty; // 게임 난이도 저장 변수
    static String nickname; // 닉네임
    static int score; // 점수 변수

    JLabel scoreLbl = new JLabel(); // 점수 표시 라벨
    int ImgCnt = 1; // 문제(이미지) 카운트

    JTextField InpAnswer = new JTextField(); // 정답 입력 텍스트필드
    JPanel stagePanel = new JPanel(null); // 단계 화면
    JLabel stageImg = new JLabel(); // 문제(이미지) 라벨
    JButton AnswerBtn = new JButton("다음"); // 다음 버튼
    JButton PassBtn = new JButton("패스"); // 패스 버튼

    //    JPanel totalPanel = new JPanel(null); //총점 화면

    static gameScoreGUI GSG;
    static UserSetGet USG = new UserSetGet();

    JLabel totalLbl = new JLabel(); //총점 출력

    public GameView() {
        difficultyFrame();
    }

    public void difficultyFrame() { // 난이도 선택, 닉네임 설정 Frame

        JPanel difficultyPanel = new JPanel(null); // 난이도 선택 Panel
        difficultyPanel.setBounds(0, 0, 840, 720);
        difficultyPanel.setVisible(true);
        difficultyFrame.add(difficultyPanel);

        JPanel NicknamePanel = new JPanel(null); // 닉네임 설정 Panel
        NicknamePanel.setBounds(0, 0, 840, 720);
        NicknamePanel.setVisible(false);
        difficultyFrame.add(NicknamePanel);

        JButton[] difficultyBtn = new JButton[4]; // 단계 선택 버튼

        for (int i = 0; i < difficultyBtn.length; i++) {
            difficultyBtn[i] = new JButton((i + 1) + "단계");
            difficultyBtn[i].setFont(new Font("굴림", Font.BOLD, 20));
            difficultyBtn[i].setBackground(Color.YELLOW);
            difficultyBtn[i].setBounds((i + 2) * 55 + i * 100, 300, 150, 120);
            difficultyPanel.add(difficultyBtn[i]);
        }

        JLabel NicknameLbl = new JLabel("닉네임을 입력하세요");
        NicknameLbl.setBounds(300, 120, 500, 200);
        NicknameLbl.setFont(new Font("고딕", Font.BOLD, 25));
        NicknamePanel.add(NicknameLbl);

        JTextField InpNickname = new JTextField(); // 닉네임 입력 텍스트필드
        InpNickname.setBounds(300, 330, 250, 50);
        InpNickname.setHorizontalAlignment(SwingConstants.CENTER); // InpName을 텍스트필드의 가운데로 설정
        NicknamePanel.add(InpNickname);

        JButton setNickname = new JButton("확인");
        setNickname.setBounds(350, 420, 150, 100);
        setNickname.setFont(new Font("굴림", Font.BOLD, 20));
        setNickname.setBackground(Color.CYAN);
        NicknamePanel.add(setNickname);

        for (int i = 0; i < difficultyBtn.length; i++) {
            difficultyBtn[i].addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    for (int j = 0; j < difficultyBtn.length; j++) {
                        if (difficultyBtn[j] == e.getSource()) {
                            difficulty = j + 1;
                            score = 0;
                        }
                    }
                    difficultyPanel.setVisible(false);
                    NicknamePanel.setVisible(true);
                }

            });
        }

        setNickname.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                nickname = InpNickname.getText();
                JOptionPane.showMessageDialog(null, "닉네임이 설정되었습니다! 곧 게임이 시작됩니다.");
                NicknamePanel.setVisible(false);
                difficultyFrame.setVisible(false);
                GameFrame();
            }
        });

        difficultyFrame.setResizable(false); // 창 크기 조절 불가
        difficultyFrame.setSize(840, 720);
        difficultyFrame.setLocationRelativeTo(null); // 창을 정중앙에서 출력
        difficultyFrame.setVisible(true); // 창이 화면에 보이게
        difficultyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫았을 때 프로그램이 종료되게 함
    }

    ActionListener PassBtnL = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            ImgCnt++;
            if (ImgCnt > 6) {
                stagePanel.setVisible(false);
//                totalPanel.setVisible(true);
                dataGS();
            } else stageImg.setIcon(new ImageIcon("mas_images/stage" + difficulty + "_" + ImgCnt + ".jpg"));
            InpAnswer.setText("");
            InpAnswer.requestFocus();
        }
    };

    public void stage1() {
        stageImg.setIcon(new ImageIcon("mas_images/stage1_1.jpg"));

        AnswerBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String Answer = InpAnswer.getText();

                switch (ImgCnt) {
                    case 1:
                        if (Answer.equals("뽀로로")) {
                            JOptionPane.showMessageDialog(null, "정답입니다");
                            score++;
                            ImgCnt++;
                            scoreLbl.setText(("현재 점수: " + score));
                            stageImg.setIcon(new ImageIcon("mas_images/stage1_2.jpg"));
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "오답입니다");
                            ImgCnt++;
                            stageImg.setIcon(new ImageIcon("mas_images/stage1_2.jpg"));
                            break;
                        }

                    case 2:
                        if (Answer.equals("유재석")) {
                            JOptionPane.showMessageDialog(null, "정답입니다");
                            score++;
                            ImgCnt++;
                            scoreLbl.setText(("현재 점수: " + score));
                            stageImg.setIcon(new ImageIcon("mas_images/stage1_3.jpg"));
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "오답입니다");
                            ImgCnt++;
                            stageImg.setIcon(new ImageIcon("mas_images/stage1_3.jpg"));
                            break;
                        }

                    case 3:
                        if (Answer.equals("강호동")) {
                            JOptionPane.showMessageDialog(null, "정답입니다");
                            score++;
                            ImgCnt++;
                            scoreLbl.setText(("현재 점수: " + score));
                            stageImg.setIcon(new ImageIcon("mas_images/stage1_4.jpg"));
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "오답입니다");
                            ImgCnt++;
                            stageImg.setIcon(new ImageIcon("mas_images/stage1_4.jpg"));
                            break;
                        }

                    case 4:
                        if (Answer.equals("아이유")) {
                            JOptionPane.showMessageDialog(null, "정답입니다");
                            score++;
                            ImgCnt++;
                            scoreLbl.setText(("현재 점수: " + score));
                            stageImg.setIcon(new ImageIcon("mas_images/stage1_5.jpg"));
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "오답입니다");
                            ImgCnt++;
                            stageImg.setIcon(new ImageIcon("mas_images/stage1_5.jpg"));
                            break;
                        }

                    case 5:
                        if (Answer.equals("알엠") || Answer.equals("RM") || Answer.equals("rm")) {
                            JOptionPane.showMessageDialog(null, "정답입니다");
                            score++;
                            ImgCnt++;
                            scoreLbl.setText(("현재 점수: " + score));
                            stageImg.setIcon(new ImageIcon("mas_images/stage1_6.jpg"));
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "오답입니다");
                            ImgCnt++;
                            stageImg.setIcon(new ImageIcon("mas_images/stage1_6.jpg"));
                            break;
                        }

                    case 6:
                        if (Answer.equals("승관") || Answer.equals("부승관")) {
                            JOptionPane.showMessageDialog(null, "정답입니다");
                            score++;
                            scoreLbl.setText(("현재 점수: " + score));
                            stagePanel.setVisible(false);
//                            totalPanel.setVisible(true);
                            dataGS();
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "오답입니다");
                            stagePanel.setVisible(false);
//                            totalPanel.setVisible(true);
                            dataGS();
                            break;
                        }
                }
                InpAnswer.setText("");
                InpAnswer.requestFocus();
            }


        });
    }

    public void stage2() {
        stageImg.setIcon(new ImageIcon("mas_images/stage2_1.jpg"));

        AnswerBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String Answer = InpAnswer.getText();

                switch (ImgCnt) {
                    case 1:
                        if (Answer.equals("나연")) {
                            JOptionPane.showMessageDialog(null, "정답입니다");
                            score++;
                            ImgCnt++;
                            scoreLbl.setText(("현재 점수: " + score));
                            stageImg.setIcon(new ImageIcon("mas_images/stage2_2.jpg"));
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "오답입니다");
                            ImgCnt++;
                            stageImg.setIcon(new ImageIcon("mas_images/stage2_2.jpg"));
                            break;
                        }

                    case 2:
                        if (Answer.equals("송강호")) {
                            JOptionPane.showMessageDialog(null, "정답입니다");
                            score++;
                            ImgCnt++;
                            scoreLbl.setText(("현재 점수: " + score));
                            stageImg.setIcon(new ImageIcon("mas_images/stage2_3.jpg"));
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "오답입니다");
                            ImgCnt++;
                            stageImg.setIcon(new ImageIcon("mas_images/stage2_3.jpg"));
                            break;
                        }

                    case 3:
                        if (Answer.equals("현빈")) {
                            JOptionPane.showMessageDialog(null, "정답입니다");
                            score++;
                            ImgCnt++;
                            scoreLbl.setText(("현재 점수: " + score));
                            stageImg.setIcon(new ImageIcon("mas_images/stage2_4.jpg"));
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "오답입니다");
                            ImgCnt++;
                            stageImg.setIcon(new ImageIcon("mas_images/stage2_4.jpg"));
                            break;
                        }

                    case 4:
                        if (Answer.equals("장성규")) {
                            JOptionPane.showMessageDialog(null, "정답입니다");
                            score++;
                            ImgCnt++;
                            scoreLbl.setText(("현재 점수: " + score));
                            stageImg.setIcon(new ImageIcon("mas_images/stage2_5.jpg"));
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "오답입니다");
                            ImgCnt++;
                            stageImg.setIcon(new ImageIcon("mas_images/stage2_5.jpg"));
                            break;
                        }

                    case 5:
                        if (Answer.equals("이영지")) {
                            JOptionPane.showMessageDialog(null, "정답입니다");
                            score++;
                            ImgCnt++;
                            scoreLbl.setText(("현재 점수: " + score));
                            stageImg.setIcon(new ImageIcon("mas_images/stage2_6.jpg"));
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "오답입니다");
                            ImgCnt++;
                            stageImg.setIcon(new ImageIcon("mas_images/stage2_6.jpg"));
                            break;
                        }

                    case 6:
                        if (Answer.equals("장원영") || Answer.equals("원영")) {
                            JOptionPane.showMessageDialog(null, "정답입니다");
                            score++;
                            scoreLbl.setText(("현재 점수: " + score));
                            stagePanel.setVisible(false);
//                            totalPanel.setVisible(true);
                            dataGS();
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "오답입니다");
                            stagePanel.setVisible(false);
//                            totalPanel.setVisible(true);
                            dataGS();
                            break;
                        }
                }
                InpAnswer.setText("");
                InpAnswer.requestFocus();
            }
        });
    }

    public void stage3() {
        stageImg.setIcon(new ImageIcon("mas_images/stage3_1.jpg"));

        AnswerBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String Answer = InpAnswer.getText();

                switch (ImgCnt) {
                    case 1:
                        if (Answer.equals("이용진")) {
                            JOptionPane.showMessageDialog(null, "정답입니다");
                            score++;
                            ImgCnt++;
                            scoreLbl.setText(("현재 점수: " + score));
                            stageImg.setIcon(new ImageIcon("mas_images/stage3_2.jpg"));
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "오답입니다");
                            ImgCnt++;
                            stageImg.setIcon(new ImageIcon("mas_images/stage3_2.jpg"));
                            break;
                        }

                    case 2:
                        if (Answer.equals("박나은") || Answer.equals("나은") || Answer.equals("나은이")) {
                            JOptionPane.showMessageDialog(null, "정답입니다");
                            score++;
                            ImgCnt++;
                            scoreLbl.setText(("현재 점수: " + score));
                            stageImg.setIcon(new ImageIcon("mas_images/stage3_3.jpg"));
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "오답입니다");
                            ImgCnt++;
                            stageImg.setIcon(new ImageIcon("mas_images/stage3_3.jpg"));
                            break;
                        }

                    case 3:
                        if (Answer.equals("리아")) {
                            JOptionPane.showMessageDialog(null, "정답입니다");
                            score++;
                            ImgCnt++;
                            scoreLbl.setText(("현재 점수: " + score));
                            stageImg.setIcon(new ImageIcon("mas_images/stage3_4.jpg"));
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "오답입니다");
                            ImgCnt++;
                            stageImg.setIcon(new ImageIcon("mas_images/stage3_4.jpg"));
                            break;
                        }

                    case 4:
                        if (Answer.equals("도겸")) {
                            JOptionPane.showMessageDialog(null, "정답입니다");
                            score++;
                            ImgCnt++;
                            scoreLbl.setText(("현재 점수: " + score));
                            stageImg.setIcon(new ImageIcon("mas_images/stage3_5.jpg"));
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "오답입니다");
                            ImgCnt++;
                            stageImg.setIcon(new ImageIcon("mas_images/stage3_5.jpg"));
                            break;
                        }

                    case 5:
                        if (Answer.equals("원필")) {
                            JOptionPane.showMessageDialog(null, "정답입니다");
                            score++;
                            ImgCnt++;
                            scoreLbl.setText(("현재 점수: " + score));
                            stageImg.setIcon(new ImageIcon("mas_images/stage3_6.jpg"));
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "오답입니다");
                            ImgCnt++;
                            stageImg.setIcon(new ImageIcon("mas_images/stage3_6.jpg"));
                            break;
                        }

                    case 6:
                        if (Answer.equals("영훈")) {
                            JOptionPane.showMessageDialog(null, "정답입니다");
                            score++;
                            scoreLbl.setText(("현재 점수: " + score));
                            stagePanel.setVisible(false);
//                            totalPanel.setVisible(true);
                            dataGS();
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "오답입니다");
                            stagePanel.setVisible(false);
//                            totalPanel.setVisible(true);
                            dataGS();
                            break;
                        }
                }
                InpAnswer.setText("");
                InpAnswer.requestFocus();
            }
        });
    }

    public void stage4() {
        stageImg.setIcon(new ImageIcon("mas_images/stage4_1.jpg"));

        AnswerBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String Answer = InpAnswer.getText();

                switch (ImgCnt) {
                    case 1:
                        if (Answer.equals("앤 마리") || Answer.equals("앤마리") || Answer.equals("Anne-Marie")) {
                            JOptionPane.showMessageDialog(null, "정답입니다");
                            score++;
                            ImgCnt++;
                            scoreLbl.setText(("현재 점수: " + score));
                            stageImg.setIcon(new ImageIcon("mas_images/stage4_2.jpg"));
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "오답입니다");
                            ImgCnt++;
                            stageImg.setIcon(new ImageIcon("mas_images/stage4_2.jpg"));
                            break;
                        }

                    case 2:
                        if (Answer.equals("티모시 샬라메") || Answer.equals("티모시샬라메") || Answer.equals("Timothee Chalamet")) {
                            JOptionPane.showMessageDialog(null, "정답입니다");
                            score++;
                            ImgCnt++;
                            scoreLbl.setText(("현재 점수: " + score));
                            stageImg.setIcon(new ImageIcon("mas_images/stage4_3.jpg"));
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "오답입니다");
                            ImgCnt++;
                            stageImg.setIcon(new ImageIcon("mas_images/stage4_3.jpg"));
                            break;
                        }

                    case 3:
                        if (Answer.equals("미치에다 슌스케")) {
                            JOptionPane.showMessageDialog(null, "정답입니다");
                            score++;
                            ImgCnt++;
                            scoreLbl.setText(("현재 점수: " + score));
                            stageImg.setIcon(new ImageIcon("mas_images/stage4_4.jpg"));
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "오답입니다");
                            ImgCnt++;
                            stageImg.setIcon(new ImageIcon("mas_images/stage4_4.jpg"));
                            break;
                        }

                    case 4:
                        if (Answer.equals("하현상")) {
                            JOptionPane.showMessageDialog(null, "정답입니다");
                            score++;
                            ImgCnt++;
                            scoreLbl.setText(("현재 점수: " + score));
                            stageImg.setIcon(new ImageIcon("mas_images/stage4_5.jpg"));
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "오답입니다");
                            ImgCnt++;
                            stageImg.setIcon(new ImageIcon("mas_images/stage4_5.jpg"));
                            break;
                        }

                    case 5:
                        if (Answer.equals("리이나")) {
                            JOptionPane.showMessageDialog(null, "정답입니다");
                            score++;
                            ImgCnt++;
                            scoreLbl.setText(("현재 점수: " + score));
                            stageImg.setIcon(new ImageIcon("mas_images/stage4_6.jpg"));
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "오답입니다");
                            ImgCnt++;
                            stageImg.setIcon(new ImageIcon("mas_images/stage4_6.jpg"));
                            break;
                        }

                    case 6:
                        if (Answer.equals("이션")) {
                            JOptionPane.showMessageDialog(null, "정답입니다");
                            score++;
                            scoreLbl.setText(("현재 점수: " + score));
                            stagePanel.setVisible(false);
//                            totalPanel.setVisible(true);
                            dataGS();
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "오답입니다");
                            stagePanel.setVisible(false);
//                            totalPanel.setVisible(true);
                            dataGS();
                            break;
                        }
                }
                InpAnswer.setText("");
                InpAnswer.requestFocus();
            }
        });
    }

    public void GameFrame() {

        stagePanel.setBounds(0, 0, 840, 720);
        GameFrame.add(stagePanel);

//        totalPanel.setBounds(0, 0, 840, 720);
//        GameFrame.add(totalPanel);

        stageImg.setBounds(300, 70, 200, 300);

        InpAnswer.setBounds(250, 400, 200, 50);
        InpAnswer.setHorizontalAlignment(SwingConstants.CENTER);
        stagePanel.add(InpAnswer);

        AnswerBtn.setBounds(470, 400, 100, 50);
        AnswerBtn.setFont(new Font("굴림", Font.BOLD, 20));
        AnswerBtn.setBackground(Color.CYAN);
        stagePanel.add(AnswerBtn);

        PassBtn.setBounds(350, 500, 150, 100);
        PassBtn.setFont(new Font("굴림", Font.BOLD, 20));
        PassBtn.setBackground(Color.YELLOW);
        PassBtn.addActionListener(PassBtnL);
        stagePanel.add(PassBtn);

        scoreLbl.setBounds(50, 10, 200, 200);
        scoreLbl.setFont(new Font("고딕", Font.BOLD, 25));
        scoreLbl.setText(("현재 점수: " + score));
        stagePanel.add(scoreLbl);

        totalLbl.setBounds(340, 210, 200, 200);
        totalLbl.setFont(new Font("고딕", Font.PLAIN, 30));
        totalLbl.setText("총점은 " + score + "점");

        if (difficulty == 1)
            stage1();
        else if (difficulty == 2)
            stage2();
        else if (difficulty == 3)
            stage3();
        else if (difficulty == 4)
            stage4();

        stagePanel.add(stageImg);
        stagePanel.setVisible(true);

//        totalPanel.add(totalLbl);
//        totalPanel.setVisible(false);

        GameFrame.setLayout(null);
        GameFrame.setVisible(true);
        GameFrame.setResizable(false);
        GameFrame.setSize(840, 720);
        GameFrame.setLocationRelativeTo(null);
        GameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static String name;
    public static int diff;
    public static int Fscore;

    public static void dataGS() {
        USG.setName(nickname);
        USG.setDiff(difficulty);
        USG.setScore(score);

        name = USG.getName();
        diff = USG.getDiff();
        Fscore = USG.getScore();
        new UserDB();
        userdbCall();
    }

    public static void userdbCall() {
        try {
            GSG = new gameScoreGUI();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void main(String[] args) {
        new GameView();

    }
}