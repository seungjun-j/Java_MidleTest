import javax.swing.*;
import java.awt.*;

public class CalulTest extends JFrame {
    CalulTest() {
        setTitle("계산기");
        setSize(520,250);

        setLayout(new BorderLayout(10,10));
        showCenter();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    void showCenter() {
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel panel = new JPanel(new GridLayout(2,0));

        JTextField t1 = new JTextField(250);
        t1.setEnabled(false);
        p1.add(t1);

        p2.setLayout(new GridLayout(5,5));
        p2.add(new JButton("Backspace"));
        p2.add(new JButton(""));
        p2.add(new JButton(""));
        p2.add(new JButton("CE"));
        p2.add(new JButton("C"));
        p2.add(new JButton("7"));
        p2.add(new JButton("8"));
        p2.add(new JButton("9"));
        p2.add(new JButton("/"));
        p2.add(new JButton("sqrt"));
        p2.add(new JButton("4"));
        p2.add(new JButton("5"));
        p2.add(new JButton("6"));
        p2.add(new JButton("x"));
        p2.add(new JButton("%"));
        p2.add(new JButton("1"));
        p2.add(new JButton("2"));
        p2.add(new JButton("3"));
        p2.add(new JButton("-"));
        p2.add(new JButton("1/x"));
        p2.add(new JButton("0"));
        p2.add(new JButton("+/-"));
        p2.add(new JButton("."));
        p2.add(new JButton("+"));
        p2.add(new JButton("="));
        panel.add(p1);
        panel.add(p2);
        add(panel,BorderLayout.CENTER);


    }
    public static void main(String[] args) {
        new CalulTest();
    }
}
