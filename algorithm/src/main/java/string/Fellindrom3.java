package string;

import java.util.Scanner;


public class Fellindrom3 {

    public String solution(String str){

        String answer = "NO";

        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equals(tmp)) answer = "YES";

        return answer;
    }

    public static void main(String[] args){
        Fellindrom3 t = new Fellindrom3();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(t.solution(str));


    }
}
