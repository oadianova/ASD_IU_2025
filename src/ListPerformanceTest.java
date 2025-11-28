public class ListPerformanceTest {
    public static void main(String[] args) {
        System.out.println("=== Move-to-Front List Test ===");
        testMoveToFrontList();

        System.out.println("\n=== Transpose List Test ===");
        testTransposeList();

        System.out.println("\n=== Frequency Count List Test ===");
        testFrequencyCountList();
    }

    private static void testMoveToFrontList() {
        SelfOrganizingLinkedList<Integer> list = new SelfOrganizingLinkedList<>();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);

        System.out.print("Initial: ");
        list.display();

        System.out.println("Access 3: " + list.access(3));
        System.out.print("After accessing 3: ");
        list.display();

        System.out.println("Access 2: " + list.access(2));
        System.out.print("After accessing 2: ");
        list.display();

        System.out.println("Access 4: " + list.access(4));
        System.out.print("After accessing 4: ");
        list.display();

        System.out.println("Access 1: " + list.access(1));
        System.out.print("After accessing 1: ");
        list.display();

        System.out.println("Access 10: " + list.access(10));
        System.out.print("After accessing 10: ");
        list.display();

        System.out.println("Total elements: " + list.getCount());
    }

    private static void testTransposeList() {
        TranspositionList<Integer> list = new TranspositionList<>();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);

        System.out.print("Initial: ");
        list.display();

        System.out.println("Access 3: " + list.access(3));
        System.out.print("After accessing 3: ");
        list.display();

        System.out.println("Access 2: " + list.access(2));
        System.out.print("After accessing 2: ");
        list.display();

        System.out.println("Access 3: " + list.access(3));
        System.out.print("After accessing 3: ");
        list.display();

        System.out.println("Access 1: " + list.access(1));
        System.out.print("After accessing 1: ");
        list.display();

        System.out.println("Access 10: " + list.access(10));
        System.out.print("After accessing 10: ");
        list.display();

        System.out.println("Total elements: " + list.getCount());
    }

    private static void testFrequencyCountList() {
        FrequencyOrderedList<Integer> list = new FrequencyOrderedList<>();

        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);

        System.out.print("Initial: ");
        list.display();

        System.out.println("Access 3: " + list.search(3));
        System.out.print("After accessing 3: ");
        list.display();

        System.out.println("Access 2: " + list.search(2));
        System.out.print("After accessing 2: ");
        list.display();

        System.out.println("Access 3: " + list.search(3));
        System.out.print("After accessing 3: ");
        list.display();

        System.out.println("Access 1: " + list.search(1));
        System.out.print("After accessing 1: ");
        list.display();

        System.out.println("Access 4: " + list.search(4));
        System.out.print("After accessing 4: ");
        list.display();

        System.out.println("Access 10: " + list.search(10));
        System.out.print("After accessing 10: ");
        list.display();

        System.out.println("Total elements: " + list.getSize());
    }
}