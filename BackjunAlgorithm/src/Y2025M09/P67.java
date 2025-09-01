package Y2025M09;

import java.util.LinkedList;
import java.util.Queue;

public class P67 {

    public static class Node {
        private int value;
        private Node left, right;

        public Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    public int BFS(Node root) {
       Queue<Node> Q = new LinkedList<>();
       if (root == null) return 0;
       Q.offer(root);
       int L = 0;
       while(!Q.isEmpty()) {
           int queueSize = Q.size();
           for(int i = 0; i < queueSize; i++) {
               Node node = Q.poll();
               if (node.left == null && node.right == null) return L;

               if (node.left != null) Q.offer(node.left);
               if (node.right != null) Q.offer(node.right);
           }
           L++;
       }
       return 0;
    }

    public static void main(String[] args) {
        P67 main = new P67();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(main.BFS(root));
    }
}
