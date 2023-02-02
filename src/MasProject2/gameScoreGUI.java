package MasProject2;

import java.awt.*;
import javax.swing.*;

public class gameScoreGUI extends JFrame{
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
