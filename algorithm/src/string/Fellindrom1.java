package string;

import java.util.Scanner;

public class Fellindrom1 {

    public String solution(String str){

        String answer = "YES";
        str = str.toUpperCase();

        int len = str.length();
        for(int i = 0; i < len/2; i++){

            if(str.charAt(i) != len - i -1){
                return "NO";
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Fellindrom1 t = new Fellindrom1();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(t.solution(str));


    }
}
