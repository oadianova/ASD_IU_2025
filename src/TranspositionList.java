public class TranspositionList<T> {

    private Node<T> first;
    private int elementCount;

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    public void insert(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = first;
        first = newNode;
        elementCount++;
    }

    public boolean access(T value) {
        if (first == null) {
            return false;
        }

        if (first.value.equals(value)) {
            return true;
        }

        Node<T> current = first;
        Node<T> previous = null;
        Node<T> prePrevious = null;

        while (current != null && !current.value.equals(value)) {
            prePrevious = previous;
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (prePrevious != null) {
            prePrevious.next = current;
        } else {
            first = current;
        }
        previous.next = current.next;
        current.next = previous;
        return true;
    }

    public boolean contains(T value) {
        return access(value);
    }

    public int getCount() {
        return elementCount;
    }

    public boolean isEmpty() {
        return elementCount == 0;
    }

    public void display() {
        Node<T> current = first;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public T getFirst() {
        return first != null ? first.value : null;
    }

    public void clear() {
        first = null;
        elementCount = 0;
    }
}