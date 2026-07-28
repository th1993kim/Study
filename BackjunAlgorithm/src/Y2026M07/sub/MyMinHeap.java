package Y2026M07.sub;

public class MyMinHeap {

    private int[] heap;
    private int size;

    public MyMinHeap() {
        heap = new int[2];
    }

    public void add(int value) {
        if (heap.length == size) {
            int[] copy = new int[size * 2];

            System.arraycopy(heap, 0, copy, 0, size);
            heap = copy;
        }

        heap[size] = value;
        int current = size;
        while (current > 0) {
            int parent = (current - 1) / 2;

            if (heap[parent] <= heap[current]) break;


            int temp = heap[parent];
            heap[parent] = heap[current];
            heap[current] = temp;

            current = parent;
        }
        size++;
    }

    public int poll() {
        if (size <= 0) {
            throw new IndexOutOfBoundsException();
        }
        int poll = heap[0];

        heap[0] = heap[--size];
        int current = 0;
        while (current < size) {
            int left = (current * 2) + 1;
            int right = (current * 2) + 2;

            if (left >= size) break;

            int smaller = left;
            if (right < size && heap[right] < heap[left]) {
                smaller = right;
            }

            if (heap[smaller] >= heap[current]) break;

            int temp = heap[smaller];
            heap[smaller] = heap[current];
            heap[current] = temp;

            current = smaller;
        }
        return poll;
    }
}
