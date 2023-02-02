package MasProject1;

import java.awt.*;
import javax.swing.*;

public class rankingShowDB extends JFrame {
    public rankingShowDB() {
        setTitle("masproject");
        setSize(1500, 850);
        setBackground(Color.WHITE);

        JPanel Jp = new JPanel();
        JLabel Jl = new JLabel();

        Jp.setLayout(new BorderLayout());
        Jl.setFont(Jl.getFont().deriveFont(30.0f));
        Jl.setBounds(400, 200, 700, 250);

        add(Jl);
        add(Jp);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {

        new rankingShowDB();
    }

}
