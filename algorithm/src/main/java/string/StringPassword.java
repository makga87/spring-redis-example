package string;

import java.util.Scanner;

public class StringPassword {

    public String solution(int n, String s) {

        String answer = "";

        for (int i = 0; i < n; i++) {
            String tmp = s.substring(0, 7).replaceAll("#", "1").replaceAll("\\*", "0");
            int num = Integer.parseInt(tmp, 2);
            answer += (char) num;
            s = s.substring(7);
        }

        return answer;
    }

    public static void main(String[] args) {

        StringPassword t = new StringPassword();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String str = kb.next();
        System.out.println(t.solution(n, str));
    }
}
