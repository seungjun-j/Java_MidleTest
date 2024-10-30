import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.EventListener;

public class CalulTest extends JFrame {

    CalulTest() {
        setTitle("계산기");
        setSize(520,250);
        setLayout(new BorderLayout(0,0));
        showNorth();
        showCenter();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    void showNorth(){
        JPanel j1 = new JPanel(new GridLayout(0,3));
        JPanel j2 = new JPanel();
        JPanel j3 = new JPanel(new BorderLayout());


        String[] kindCal = {"일반 계산기", "수면 시간 계산기"};
        JComboBox cb1 = new JComboBox(kindCal);
        TextField tf1 = new TextField(5);
        JButton his = new JButton("History");
        TextField tf = new TextField(100);

        cb1.setEditable(true);
        tf.setEditable(false);
        tf1.setEditable(false);
        j1.add(cb1);
        j1.add(tf1);
        j1.add(his);
        j2.add(tf, BorderLayout.CENTER);
        j3.add(j2,BorderLayout.NORTH);
        j3.add(j1,BorderLayout.SOUTH);

        add(j3,BorderLayout.NORTH);

        cb1.addItemListener(e -> {
            int index = ((JComboBox) cb1).getSelectedIndex();
            if (index == 0){

            }
        });


    }
    void showCenter(){
        JPanel j2 = new JPanel(new GridLayout(5,4));
        JButton bk1 = new JButton("C");
        bk1.setBackground(Color.BLACK);
        bk1.setForeground(Color.white);
        JButton bk2 = new JButton("Back");
        bk2.setBackground(Color.BLACK);
        bk2.setForeground(Color.white);
        JButton bk3 = new JButton("");
        bk3.setBackground(Color.BLACK);
        bk3.setForeground(Color.white);
        JButton bk4 = new JButton("+");
        bk4.setBackground(Color.ORANGE);
        bk4.setForeground(Color.white);
        JButton bk5 = new JButton("7");
        bk5.setBackground(Color.GRAY);
        bk5.setForeground(Color.WHITE);
        JButton bk6 = new JButton("8");
        bk6.setBackground(Color.GRAY);
        bk6.setForeground(Color.white);
        JButton bk7 = new JButton("9");
        bk7.setBackground(Color.GRAY);
        bk7.setForeground(Color.white);
        JButton bk8 = new JButton("÷");
        bk8.setBackground(Color.ORANGE);
        bk8.setForeground(Color.white);
        JButton bk9 = new JButton("4");
        bk9.setBackground(Color.GRAY);
        bk9.setForeground(Color.white);
        JButton bk10 = new JButton("5");
        bk10.setBackground(Color.GRAY);
        bk10.setForeground(Color.white);
        JButton bk11 = new JButton("6");
        bk11.setBackground(Color.GRAY);
        bk11.setForeground(Color.white);
        JButton bk12 = new JButton("x");
        bk12.setBackground(Color.ORANGE);
        bk12.setForeground(Color.white);
        JButton bk13 = new JButton("1");
        bk13.setBackground(Color.GRAY);
        bk13.setForeground(Color.white);
        JButton bk14 = new JButton("2");
        bk14.setBackground(Color.GRAY);
        bk14.setForeground(Color.white);
        JButton bk15 = new JButton("3");
        bk15.setBackground(Color.GRAY);
        bk15.setForeground(Color.white);
        JButton bk16 = new JButton("-");
        bk16.setBackground(Color.ORANGE);
        bk16.setForeground(Color.white);
        JButton bk17 = new JButton("/");
        bk17.setBackground(Color.GRAY);
        bk17.setForeground(Color.white);
        JButton bk18 = new JButton("0");
        bk18.setBackground(Color.GRAY);
        bk18.setForeground(Color.white);
        JButton bk19 = new JButton(".");
        bk19.setBackground(Color.GRAY);
        bk19.setForeground(Color.white);
        JButton bk20 = new JButton("=");
        bk20.setBackground(Color.ORANGE);
        bk20.setForeground(Color.white);
        j2.add(bk1); j2.add(bk2);j2.add(bk3);j2.add(bk4);j2.add(bk5);j2.add(bk6);j2.add(bk7);j2.add(bk8);j2.add(bk9);j2.add(bk10);
        j2.add(bk11);j2.add(bk12);j2.add(bk13);j2.add(bk14);j2.add(bk15);j2.add(bk16);j2.add(bk17);j2.add(bk18);j2.add(bk19);j2.add(bk20);

        add(j2,BorderLayout.CENTER);

    }



    public static void main(String[] args) {
        new CalulTest();
    }
}
