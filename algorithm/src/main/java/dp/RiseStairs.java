package dp;


import java.util.Scanner;

public class RiseStairs {

    static int[] dy;
    public int solution(int n){
        int answer = 0;
        dy[1] = 1;
        dy[2] = 2;
        for(int i = 3; i <= n; i++){
            dy[i] = dy[i-2] + dy[i-1];
        }

        return dy[n];
    }

    public static void main(String[] args) {

        RiseStairs t = new RiseStairs();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        dy = new int[n+1];
        System.out.println(t.solution(n));
    }
}
