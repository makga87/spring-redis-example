package array;

import java.util.ArrayList;
import java.util.Scanner;

public class TestGrade {

    public ArrayList<Integer> solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int grade = 1;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] < arr[j]) grade++;
            }
            answer.add(grade);
        }

        return answer;
    }

    public static void main(String[] args) {
        TestGrade t = new TestGrade();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for (int res : t.solution(arr)) {
            System.out.print(res + " ");
        }
    }
}
