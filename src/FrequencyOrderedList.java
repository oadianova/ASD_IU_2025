public class FrequencyOrderedList<T> {

    private ListNode<T> first;
    private int elementCount;

    private static class ListNode<T> {
        final T value;
        ListNode<T> next;
        int accessFrequency;

        ListNode(T value) {
            this.value = value;
            this.next = null;
            this.accessFrequency = 0;
        }
    }

    public void append(T element) {
        if (element == null) {
            throw new IllegalArgumentException("List elements cannot be null");
        }

        ListNode<T> newNode = new ListNode<>(element);
        newNode.next = first;
        first = newNode;
        elementCount++;
    }

    public boolean search(T target) {
        ListNode<T> current = first;
        ListNode<T> previous = null;
        boolean elementFound = false;

        while (current != null) {
            if (current.value.equals(target)) {
                current.accessFrequency++;
                elementFound = true;

                if (previous != null) {
                    previous.next = current.next;
                    repositionNode(current);
                }
                break;
            }
            previous = current;
            current = current.next;
        }
        return elementFound;
    }

    private void repositionNode(ListNode<T> node) {
        if (first == null || node.accessFrequency > first.accessFrequency) {
            node.next = first;
            first = node;
            return;
        }

        ListNode<T> current = first;
        while (current.next != null && current.next.accessFrequency >= node.accessFrequency) {
            current = current.next;
        }

        node.next = current.next;
        current.next = node;
    }

    public boolean contains(T element) {
        return search(element);
    }

    public int getSize() {
        return elementCount;
    }

    public boolean isEmpty() {
        return elementCount == 0;
    }

    public void display() {
        ListNode<T> current = first;
        StringBuilder output = new StringBuilder();

        while (current != null) {
            output.append(current.value)
                    .append("[")
                    .append(current.accessFrequency)
                    .append("] ");
            current = current.next;
        }

        System.out.println(output.toString().trim());
    }

    public T getFirst() {
        return first != null ? first.value : null;
    }

    public void clear() {
        first = null;
        elementCount = 0;
    }
}