public class SelfOrganizingLinkedListTest {

    public static void main(String[] args) {
        System.out.println("=== Тестирование SelfOrganizingLinkedList ===\n");

        // Тест 1: Базовые операции
        SelfOrganizingLinkedList<String> list = new SelfOrganizingLinkedList<>();
        list.insert("A");
        list.insert("B");
        list.insert("C");
        System.out.print("После вставки A,B,C: ");
        list.display(); // C B A

        // Тест 2: Самоорганизация
        System.out.println("Поиск A: " + list.contains("A")); // true
        System.out.print("После поиска A: ");
        list.display(); // A C B

        System.out.println("Поиск C: " + list.contains("C")); // true
        System.out.print("После поиска C: ");
        list.display(); // C A B

        // Тест 3: Граничные случаи
        SelfOrganizingLinkedList<Integer> emptyList = new SelfOrganizingLinkedList<>();
        System.out.println("Поиск в пустом списке: " + emptyList.contains(1)); // false

        System.out.println("Первый элемент: " + list.getFirst()); // C
        System.out.println("Количество элементов: " + list.getCount()); // 3
    }
}