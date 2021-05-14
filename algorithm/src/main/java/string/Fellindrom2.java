package string;

import java.util.Scanner;

public class Fellindrom2 {

    public String solution(String str) {

        String answer = "YES";

        String tmp = new StringBuilder(str).reverse().toString();
        if (!str.equalsIgnoreCase(tmp.toUpperCase())) return "NO";

        return answer;
    }

    public static void main(String[] args) {
        Fellindrom2 t = new Fellindrom2();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(t.solution(str));


    }
}
