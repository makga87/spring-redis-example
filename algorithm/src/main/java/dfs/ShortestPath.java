package dfs;

public class ShortestPath {

    Node root;

    public int DFS(int L, Node root) {

        if (root.leftChild == null && root.rightChild == null) return L;
        else {
            return Math.min(DFS(L + 1, root.leftChild), DFS(L + 1, root.rightChild));
        }

    }

    public static void main(String[] args) {
        ShortestPath p = new ShortestPath();
        p.root = new Node(1);
        p.root.leftChild = new Node(2);
        p.root.rightChild = new Node(3);
        p.root.leftChild.leftChild = new Node(4);
        p.root.leftChild.rightChild = new Node(5);

        System.out.println(p.DFS(0, p.root));

    }
}
