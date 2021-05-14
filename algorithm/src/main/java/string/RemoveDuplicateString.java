package string;

import java.util.Scanner;

public class RemoveDuplicateString {

    public String solution(String str){

        String answer="";

        for(int i = 0; i < str.length(); i++){
            //indexOf 지정한 문자열이 최초로 나오는 index 번호
            if(str.indexOf(str.charAt(i)) == i) answer += str.charAt(i);
        }

        return answer;
    }

    public static void main(String[] args){
        RemoveDuplicateString t = new RemoveDuplicateString();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        t.solution(str);

    }
}
