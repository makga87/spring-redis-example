package array;

import java.util.Scanner;
import java.util.Stack;

public class StudentCounting {

    public int solution(int[] arr){
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < arr.length; i++){

            if(stack.isEmpty()){
                stack.push(arr[i]);
            } else {
                if(stack.peek() < arr[i]){
                    stack.push(arr[i]);
                }
            }
        }
        return stack.size();
    }

    public static void main(String[] args){
        StudentCounting t = new StudentCounting();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = kb.nextInt();
        }
        System.out.println(t.solution(arr));
    }
}
