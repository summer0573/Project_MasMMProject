package MasProject2;

import java.awt.*;
import javax.swing.*;

public class gameScoreGUI extends JFrame{
    //게임 점수 화면
    public gameScoreGUI(){
        setTitle("masproject");
        setSize(1500, 850);
        setBackground(Color.WHITE);

        JPanel Jp = new JPanel();

        add(Jp);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new gameScoreGUI();
    }
}
