package stqu;


import java.util.Scanner;
import java.util.Stack;

public class RemoveBracket {

    public String solution(String brackets) {
        String answer = "";

        Stack<Character> stack = new Stack<>();

        for (char ch : brackets.toCharArray()) {
            if (ch == ')') {
                boolean flag = true;
                while (flag) {
                    char _ch = stack.pop();
                    if (_ch == '(') flag = false;
                }
            } else {
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(String.valueOf(c));
        }

        answer = sb.toString();
        return answer;
    }

    public static void main(String[] args) {

        RemoveBracket t = new RemoveBracket();
        Scanner kb = new Scanner(System.in);
        String bracket = kb.next();

        System.out.println(t.solution(bracket));
    }
}
