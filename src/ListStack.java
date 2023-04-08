import java.util.NoSuchElementException;

public class ListStack<E> {

    private OneWayLinkedList<E> list;

    public ListStack() {
        list = new OneWayLinkedList<>();
    }

    public void push(E item) {
        list.insert(0, item);
    }

    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.removePos(0);
    }

    public E top() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size;
    }

}
