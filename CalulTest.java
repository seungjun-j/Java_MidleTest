import javax.swing.*;
import java.awt.*;

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

        j1.add(cb1);
        j1.add(tf1);
        j1.add(his);
        j2.add(tf, BorderLayout.CENTER);
        j3.add(j2,BorderLayout.NORTH);
        j3.add(j1,BorderLayout.SOUTH);

        add(j3,BorderLayout.NORTH);



    }
    void showCenter(){
        JPanel j2 = new JPanel(new GridLayout(5,4));
        JButton bk1 = new JButton("");
        JButton bk2 = new JButton("");
        JButton bk3 = new JButton("");
        JButton bk4 = new JButton("");
        JButton bk5 = new JButton("7");
        JButton bk6 = new JButton("8");
        JButton bk7 = new JButton("9");
        JButton bk8 = new JButton("÷");
        JButton bk9 = new JButton("4");
        JButton bk10 = new JButton("5");
        JButton bk11 = new JButton("6");
        JButton bk12 = new JButton("x");
        JButton bk13 = new JButton("1");
        JButton bk14 = new JButton("2");
        JButton bk15 = new JButton("3");
        JButton bk16 = new JButton("-");
        JButton bk17 = new JButton("/");
        JButton bk18 = new JButton("0");
        JButton bk19 = new JButton(".");
        JButton bk20 = new JButton("=");
        j2.add(bk1); j2.add(bk2);j2.add(bk3);j2.add(bk4);j2.add(bk5);j2.add(bk6);j2.add(bk7);j2.add(bk8);j2.add(bk9);j2.add(bk10);
        j2.add(bk11);j2.add(bk12);j2.add(bk13);j2.add(bk14);j2.add(bk15);j2.add(bk16);j2.add(bk17);j2.add(bk18);j2.add(bk19);j2.add(bk20);

        add(j2,BorderLayout.CENTER);

    }


    public static void main(String[] args) {
        new CalulTest();
    }
}
