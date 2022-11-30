import javax.swing.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {

        JFrame f = new JFrame("left or right");
        JTextField tf = new JTextField();
        JButton b1 = new JButton("left");
        JButton b2 = new JButton("right");

        tf.setBounds(100,150,200,100);
        b1.setBounds(10,10,100,100);
        b2.setBounds(290,10,100,100);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf.setText("                     left");
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf.setText("                     right");
            }
        });

        f.add(b1);
        f.add(b2);
        f.add(tf);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);

    }
}
