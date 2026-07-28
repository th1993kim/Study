package Y2026M07.sub;

public class MyArrayList<E> {

    Object[] elementData;
    int size;

    public MyArrayList() {
        elementData = new Object[2];
        size = 0;
    }

    public void add(E value) {
        ensureCapacity();
        elementData[size++] = value;
    }

    private void ensureCapacity() {
        if (elementData.length == size)  {
            Object[] copy = new Object[size * 2];
            for (int i = 0; i < size; i ++) {
                copy[i] = elementData[i];
            }
            elementData = copy;
        }
    }

    public E get(int index) {
        if (index > size - 1 || index < 0)  {
            throw new IndexOutOfBoundsException();
        }
        return (E) elementData[index];
    }

    public E remove(int index) {
        if (index >= size || index < 0)  {
            throw new IndexOutOfBoundsException();
        }
        E removeValue = (E) elementData[index];
        int moveCount = size - index - 1;
        if (moveCount > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, moveCount);
        }
        elementData[--size] = null;


        return removeValue;
    }
    
}
