package Y2026M08;

import java.util.HashMap;
import java.util.Map;

public class NeetCode104 {

    static class LRUCache {

        private Map<Integer, Node> cache;
        private int capacity;
        private int size;
        private Node head;
        private Node tail;

        public LRUCache(int capacity) {
            this.cache = new HashMap<>();
            this.capacity = capacity;
            this.size = 0;
        }

        public int get(int key) {
            Node node = cache.get(key);
            if (node == null) return -1;
            moveToLast(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = cache.get(key);
            if (node == null) {
                node = new Node(key, value);
                cache.put(key, node);
                addLast(node);
            } else {
                node.value = value;
                moveToLast(node);
            }

            if (cache.size() > capacity) {
                Node removeNode = removeFirst();
                cache.remove(removeNode.key);
            }

        }

        private void remove(Node node) {
            if (node.prev != null) {
                node.prev.next = node.next;
            } else {
                head = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            } else {
                tail = node.prev;
            }
            node.prev = null;
            node.next = null;
        }

        private void addLast(Node node) {
            if (tail == null) {
                head = node;
                tail = node;
                return;
            }

            tail.next = node;
            node.prev = tail;
            tail = node;
        }

        private void moveToLast(Node node) {
            if (node == tail) {
                return;
            }

            remove(node);
            addLast(node);
        }

        private Node removeFirst() {
            if (head == null) return null;
            Node node = head;
            remove(node);
            return node;
        }

        private static class Node {
            private int key;
            private int value;
            private Node prev;
            private Node next;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }

}
