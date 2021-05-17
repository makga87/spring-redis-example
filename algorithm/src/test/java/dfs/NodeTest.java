package dfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    Node root;

    public void dfs_preorder(Node node) {

        if(node == null) return;

        System.out.print(node.data + " ");

        dfs_preorder(node.leftChild);
        dfs_preorder(node.rightChild);
    }

    public void dfs_inorder(Node node) {

        if(node == null) return;

        dfs_inorder(node.leftChild);
        System.out.print(node.data + " ");
        dfs_inorder(node.rightChild);
    }

    public void dfs_postorder(Node node) {

        if(node == null) return;

        dfs_postorder(node.leftChild);
        dfs_postorder(node.rightChild);
        System.out.print(node.data + " ");
    }

    @Test
    void dfsTest() {

        root = new Node(1);
        root.leftChild = new Node(2);
        root.rightChild = new Node(3);
        root.leftChild.leftChild = new Node(4);
        root.leftChild.rightChild = new Node(5);
        root.rightChild.leftChild = new Node(6);
        root.rightChild.rightChild = new Node(7);

        dfs_preorder(root);
        System.out.println();
        dfs_inorder(root);
        System.out.println();
        dfs_postorder(root);

    }


}