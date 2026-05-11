package Y2026M05;

public class P625DFS {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        dfs(root);
    }

    public static void dfs(Node root) {
        if (root == null) return; //root 노드가 null 이면 종료
        else {
            dfs(root.lt);
            System.out.println(root.data + " ");
            dfs(root.rt);
        }
    }

    public static class Node {
        int data;
        Node lt,rt;

        public Node(int data) {
            this.data = data;
            lt = rt = null;
        }
    }
}
