import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Chessboard extends JFrame {

    public Chessboard() {
        setTitle("Chessboard");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel[][] panels = new JPanel[8][8];
        setLayout(new GridLayout(8, 8));

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                panels[i][j] = new JPanel();
                if ((i + j) % 2 == 0) {
                    panels[i][j].setBackground(Color.WHITE);
                } else {
                    panels[i][j].setBackground(Color.BLACK);
                }
                add(panels[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        Chessboard chessboard = new Chessboard();
        chessboard.setVisible(true);
    }
}
