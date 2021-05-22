package stqu;


import java.util.Scanner;
import java.util.Stack;

public class RightBracket {

    public String solution(String brackets){
        String answer = "YES";

        char[] bracket = brackets.toCharArray();

        Stack<Character> stack = new Stack<>();

        for(char b : bracket){
            if(b == '(') stack.push(b);
            if(stack.isEmpty() && b == ')') return "NO";
            if(b == ')') stack.pop();
        }

        if(!stack.isEmpty()) return "NO";

        return answer;
    }

    public static void main(String[] args) {

        RightBracket t = new RightBracket();
        Scanner kb = new Scanner(System.in);
        String bracket = kb.next();

        System.out.println(t.solution(bracket));
    }
}
