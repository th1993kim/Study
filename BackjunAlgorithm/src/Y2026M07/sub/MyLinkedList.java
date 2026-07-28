package Y2026M07.sub;

public class MyLinkedList<E> {

    private MyNode<E> first;
    private MyNode<E> last;
    private int size;


    public MyLinkedList() {

    }
    private static class MyNode<E> {
        private E value;
        private MyNode<E> next;

        public MyNode(E value) {
            this.value = value;
        }
    }


    private void add(E value) {
        MyNode<E> node = new MyNode<>(value);
        if (first == null) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = last.next;
        }
        size++;
    }

    private void add(int index, E value) {
        validateAdd(index);
        MyNode<E> node = new MyNode<>(value);
        if (index == 0) {
            node.next = first;
            if (first == null) {
                last = node;
            }
            first = node;
            size++;
            return;
        }

        MyNode<E> previous = first;
        for (int i = 0; i < index - 1; i++) {
            previous = previous.next;
        }

        MyNode<E> next = previous.next;
        node.next = next;
        previous.next = node;
        if (node.next == null) {
            last = node;
        }
        size++;
    }

    private void validateAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private E get(int index) {
        validateIndex(index);
        MyNode<E> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return (E) current;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    }

    private E remove(int index) {
        validateIndex(index);


        E removeValue;
        if (index == 0) {
            MyNode<E> removeNode = first;
            first = removeNode.next;
            if (last == removeNode) last = null;

            size --;
            return removeNode.value;
        }

        MyNode<E> previous = first;
        for (int i = 0; i < index - 1; i++) {
            previous = previous.next;
        }
        MyNode<E> removeNode = previous.next;

        previous.next = removeNode.next;

        if (removeNode == last) last = previous;
        size--;
        return removeNode.value;
    }
}
