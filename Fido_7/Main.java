class Node<T> {
    public T data;//дані
    public Node<T> next;//посилання на наступний вагончик

    public Node(T data) {
        this.data = data;//призначення даних
        this.next = null;//костиль для нормального створення звязку
                         // (я не здогадався як зробити без нього)
    }
}

class TwoThirdsOfLinkedList {
    public <T> Node<T> getTwoThirdsNode(Node<T> head) {

        //у випадку, якщо у нас 0 елементів
        if (head == null) {
            return null;
        }

        Node<T> current = head;
        int length = 0;

        //вираховуємо загальну кількість елементів
        while (current != null) {
            current = current.next;
            length++;
        }
        //вираховуємо порядковий номер елемента, необхідного нам
        int numberOfNeededElement =((length*2/3)-1);

        current = head;

        //визначаємо значення елемента, знаючи його номер
        for (int i = 0; i < numberOfNeededElement; i++) {
            if (current != null) {
                current = current.next;
            }
        }
        //повертаємо значення елемента, необхідного нам
        return current;
    }
}

public class Main {
    public static void main(String[] args) {

        Node<Integer> head = new Node<>(1);


        //елементи для тесту
        //head.next = new Node<>(3);
        //head.next.next = new Node<>(5);
        //head.next.next.next = new Node<>(7);
        //head.next.next.next.next = new Node<>(9);
        //head.next.next.next.next.next = new Node<>(11);
        //head.next.next.next.next.next.next = new Node<>(13);
        //head.next.next.next.next.next.next.next = new Node<>(15);
        //head.next.next.next.next.next.next.next.next = new Node<>(17);

        

        //використання наших класів для вище заданих елементів
        TwoThirdsOfLinkedList solver = new TwoThirdsOfLinkedList();
        Node<Integer> result = solver.getTwoThirdsNode(head);

        //виводимо результат
        if (result == null || head.next == null) {
            System.out.println("Список порожній або елемент не знайдено.");
        } 
        else {
            System.out.println("Знайдений елемент: " + result.data);
        }
    }
}