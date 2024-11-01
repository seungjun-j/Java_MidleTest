import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class CalulTest extends JFrame {
    private JLabel result; // 결과 표시 레이블
    private JLabel info;   // 수식 입력 레이블
    private StringBuilder expression = new StringBuilder(); // 수식 저장
//JFrame 기본 설정.
    CalulTest() {
        setTitle("계산기");
        setSize(520, 250);
        setLayout(new BorderLayout(0, 0));
        showNorth();
        showCenter();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
//JPanel1,Jpanel2를 분리하여 JFrame North부분에 들어갈 ui 제작
//추후 추가적인 업데이트를 통해 다른 계산기를 추가할 수 있도록 콤보 박스를 사용하여 선택할 수 있게 만듬.
//info, result Lable의 텍스트에 대한 글꼴 및 컬러를 지정하여 Panel에 추가함
    void showNorth() {
        JPanel j1 = new JPanel(new GridLayout(0, 3));
        JPanel j2 = new JPanel();
        JPanel j3 = new JPanel(new BorderLayout());

        String[] kindCal = {"일반 계산기", ""};
        JComboBox<String> cb1 = new JComboBox<>(kindCal);
        result = new JLabel("0");
        result.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        result.setForeground(Color.BLACK);

        info = new JLabel("0");
        info.setForeground(Color.BLACK);
        info.setFont(new Font("맑은 고딕", Font.BOLD, 25));

        JButton history = new JButton("History");

        j1.add(cb1);
        j1.add(result);
        j1.add(history);
        j2.add(info, BorderLayout.CENTER);
        j3.add(j2, BorderLayout.NORTH);
        j3.add(j1, BorderLayout.SOUTH);

        add(j3, BorderLayout.NORTH);
    }
//JFrame 계산기의 키패드를 Center에 배치, 그리고 ui의 가시성을 위해 버튼에 색상 추가
// 이전 버전에서는 버튼을 하나씩 추가 하였지만 이번 버전에서는 배열을 사용하여 코드의 가독성을 좋게하기 위해 배열을 사용하여 업데이트 하였음.
    void showCenter() {
        JPanel j2 = new JPanel(new GridLayout(5, 4));

        String[] buttonLabels = {"C", "Back", "", "+", "7", "8", "9", "÷", "4", "5", "6", "x", "1", "2", "3", "-", "/", "0", ".", "="};
        Color[] buttonColors = {Color.BLACK, Color.BLACK, Color.BLACK, Color.ORANGE,
                Color.GRAY, Color.GRAY, Color.GRAY, Color.ORANGE, Color.GRAY, Color.GRAY, Color.GRAY, Color.ORANGE,
                Color.GRAY, Color.GRAY, Color.GRAY, Color.ORANGE, Color.GRAY, Color.GRAY, Color.GRAY, Color.ORANGE};

        for (int i = 0; i < buttonLabels.length; i++) {
            JButton button = new JButton(buttonLabels[i]);
            button.setBackground(buttonColors[i]);
            button.setForeground(Color.WHITE);
            button.addActionListener(new ButtonClickListener(buttonLabels[i]));
            j2.add(button);
        }

        add(j2, BorderLayout.CENTER);
    }
// ActionListener을 사용하여 계산기가 작동할 수 있도록 함. (Chat gpt를 참조.)
    private class ButtonClickListener implements ActionListener {
        private String label;

        ButtonClickListener(String label) {
            this.label = label;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (label) {
                case "C":
                    expression.setLength(0);
                    info.setText("0");
                    result.setText("0");
                    break;
                case "Back":
                    if (expression.length() > 0) {
                        expression.deleteCharAt(expression.length() - 1);
                        info.setText(expression.length() == 0 ? "0" : expression.toString());
                    }
                    break;
                case "=":
                    try {
                        double resultValue = evaluateExpression(expression.toString());
                        result.setText(String.valueOf(resultValue));
                    } catch (Exception ex) {
                        result.setText("Error");
                    }
                    break;
                default:
                    if (!label.isEmpty()) {
                        expression.append(label.equals("÷") ? "/" : label.equals("x") ? "*" : label);
                        info.setText(expression.toString());
                    }
            }
        }
    }

    // Stack을 사용한 수식 평가 메서드
    private double evaluateExpression(String expression) {
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();
        int i = 0;

        while (i < expression.length()) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch) || ch == '.') {
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sb.append(expression.charAt(i++));
                }
                numbers.push(Double.parseDouble(sb.toString()));
                i--;
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch)) {
                    performOperation(numbers, operators.pop());
                }
                operators.push(ch);
            }
            i++;
        }

        while (!operators.isEmpty()) {
            performOperation(numbers, operators.pop());
        }

        return numbers.pop();
    }

    private int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }

    private void performOperation(Stack<Double> numbers, char operator) {
        double b = numbers.pop();
        double a = numbers.pop();
        switch (operator) {
            case '+':
                numbers.push(a + b);
                break;
            case '-':
                numbers.push(a - b);
                break;
            case '*':
                numbers.push(a * b);
                break;
            case '/':
                numbers.push(a / b);
                break;
        }
    }

    public static void main(String[] args) {
        new CalulTest();
    }
}
