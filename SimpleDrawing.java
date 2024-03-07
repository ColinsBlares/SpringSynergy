import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class SimpleDrawing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new DrawingPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

class DrawingPanel extends JPanel {

    public DrawingPanel() {
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.YELLOW);
        g.fillOval(100, 100, 200, 200);

        g.setColor(Color.BLACK);
        g.fillOval(150, 150, 20, 20); // Левый глаз
        g.fillOval(230, 150, 20, 20); // Правый глаз

        g.drawArc(150, 180, 100, 50, 0, -180);
    }
}
