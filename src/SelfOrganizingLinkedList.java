public class SelfOrganizingLinkedList<T> {

    private Node<T> first;
    private int count;

    private static class Node<T> {
        T item;
        Node<T> next;

        Node(T item) {
            this.item = item;
            this.next = null;
        }
    }

    public void insert(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = first;
        first = newNode;
        count++;
    }

    public boolean access(T item) {
        if (first == null) {
            return false;
        }

        if (first.item.equals(item)) {
            return true;
        }

        Node<T> current = first;
        Node<T> previous = null;

        while (current != null && !current.item.equals(item)) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        previous.next = current.next;
        current.next = first;
        first = current;
        return true;
    }

    public boolean contains(T item) {
        return access(item);
    }

    public int getCount() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void display() {
        Node<T> current = first;
        while (current != null) {
            System.out.print(current.item + " ");
            current = current.next;
        }
        System.out.println();
    }

    public T getFirst() {
        return first != null ? first.item : null;
    }

    public void clear() {
        first = null;
        count = 0;
    }
}