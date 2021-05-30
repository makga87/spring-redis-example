package bfs;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    Node root;

    public void bfs(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        int level = 0;

        while (!q.isEmpty()) {
            int len = q.size();
            System.out.print(level + " : ");
            for (int i = 0; i < len; i++) {
                Node cur = q.poll();
                System.out.print(cur.data + " ");
                if (cur.leftChild != null) q.offer(cur.leftChild);
                if (cur.rightChild != null) q.offer(cur.rightChild);
            }
            level++;
            System.out.println();
        }
    }

    @Test
    void bfsTest() {

        root = new Node(1);
        root.leftChild = new Node(2);
        root.rightChild = new Node(3);
        root.leftChild.leftChild = new Node(4);
        root.leftChild.rightChild = new Node(5);
        root.rightChild.leftChild = new Node(6);
        root.rightChild.rightChild = new Node(7);


        bfs(root);
    }

}