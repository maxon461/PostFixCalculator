
public class OneWayLinkedList<E> { //TODO
    private Element<E> head;
    private Element<E> tail;
    public int size;

    public boolean isEmpty() {
        return size == 0;
    }
    
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
    
    private static class Element<E> {
        E data;
        Element<E> next;

        Element(E data) {
            this.data = data;
            
        }

        private Element(E value , Element<E> next){
            
            this.data =value;
            this.next = next;

        }
    }

    public boolean add(E e) {
        Element<E> newElement = new Element<>(e);
        if (isEmpty()) {
            head = newElement;
        } else {
            tail.next = newElement;
        }
        tail = newElement;
        tail.next = head;
        size++;
        return true;
    }

    public boolean insert(int index, E e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Element<E> newElement = new Element<>(e);
        if (isEmpty()) {
            head = newElement;
            tail = newElement;
            tail.next = head;
        } else if (index == 0) {
            newElement.next = head;
            head = newElement;
            tail.next = head;
        } else if (index == size) {
            tail.next = newElement;
            tail = newElement;
            tail.next = head;
        } else {
            Element<E> previous = head;
            for (int i = 0; i < index - 1; i++) {
                previous = previous.next;
            }
            newElement.next = previous.next;
            previous.next = newElement;
        }
        size++;
        return true;
    }

    public int indexOf(E e) {
        int index = 0;
        if (isEmpty()) {
            return -1;
        }
        Element<E> current = head;
        do {
            if (current.data.equals(e)) {
                return index;
            }
            current = current.next;
            index++;
        } while (current != head);
        return -1;
    }

    public boolean contains(E e) {
        return indexOf(e) != -1;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Element<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public E removePos(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E removedElement;
        if (size == 1) {
            removedElement = head.data;
            clear();
            return removedElement;
        } else if (index == 0) {
            removedElement = head.data;
            head = head.next;
            tail.next = head;
        } else if (index == size - 1) {
            Element<E> previous = head;
            while (previous.next != tail) {
                previous = previous.next;
            }
            removedElement = tail.data;
            tail = previous;
            tail.next = head;
        } else {
            Element<E> previous = head;
            for (int i = 0; i < index - 1; i++) {
                previous = previous.next;
            }
            removedElement = previous.next.data;
            previous.next = previous.next.next;
        }
        size--;
        return removedElement;
    }

    public E removeFirst() {
        return removePos(0);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("[]");
            return;
        }
    
        Element<E> current = head;
        System.out.print("[");
        do {
            System.out.print(current.data);
            current = current.next;
            if (current != head) {
                System.out.print(", ");
            }
        } while (current != head);
        System.out.println("]");
    }
    

}
   
