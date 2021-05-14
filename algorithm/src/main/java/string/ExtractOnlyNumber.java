package string;

import java.util.Scanner;

public class ExtractOnlyNumber {

    public int solution(String str) {

        int answer = 0;
        for (char x : str.toCharArray()) {
            // 숫자의 ascii범위
            if (x >= 48 && x <= 57) answer = answer * 10 + (x - 48);
        }

        return answer;
    }

    public static void main(String[] args) {
        ExtractOnlyNumber t = new ExtractOnlyNumber();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        t.solution(str);

    }
}
