package dfs;

import java.util.stream.IntStream;

public class PartialSet {
    static int n;
    static int[] ch;

    public void DFS(int L) {

        /*
        배열의 끝은 없음
         */
        if (L == n + 1) {
            String tmp = "";
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) tmp += (i + " ");
            }
            if (tmp.length() > 0) System.out.println(tmp);
        } else {
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }
    }

    public static void main(String[] args) {
        PartialSet p = new PartialSet();
        n = 3;
        ch = new int[n + 1];
        p.DFS(1);
    }
}
