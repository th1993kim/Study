package Y2025M08;

public class P62 {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public void left(Node node) {
            this.left = node;
        }

        public void right(Node node) {
            this.right = node;
        }
    }




    public static void main(String[] args) {
        P62 main = new P62();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        main.DFS(root);
    }

    private void DFS(Node root) {
        if (root == null) return;
        System.out.println(root.data);
        DFS(root.left);
        DFS(root.right);
    }


}
