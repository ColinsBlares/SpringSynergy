import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App{
    App(){
        JFrame a = new JFrame("example");
        JTextField b1 = new JTextField("synergy");
        b1.setBounds(50,50,200,30);
        a.add(b1);

        JTextField b2 = new JTextField("");
        b2.setBounds(50,150,200,30);
        a.add(b2);

        a.setSize(300,300);
        a.setLayout(null);
        a.setVisible(true);

        JButton btn = new JButton("Click");
        btn.setBounds(50, 100, 200, 30);
        a.add(btn);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b2.setText(b1.getText());
            }
        });
    }
}
