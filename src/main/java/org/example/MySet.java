package org.example;

// Объявление класса MySet с использованием дженериков для параметризации типа данных
public class MySet<T> {
    private Node<T> head; // Указатель на начало множества
    private int size; // Переменная для хранения размера множества

    // Вложенный класс Node для представления элемента множества
    private static class Node<T> {
        T data; // Данные элемента
        Node<T> next; // Ссылка на следующий элемент

        // Конструктор для создания узла с заданными данными
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Метод для добавления элемента в множество
    public void add(T element) {
        if (!contains(element)) { // Проверяем, что элемент отсутствует в множестве
            Node<T> newNode = new Node<>(element); // Создаем новый узел для элемента
            if (head == null) { // Если множество пустое,
                head = newNode; // делаем новый узел началом множества
            } else {
                Node<T> current = head; // Иначе находим последний узел
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode; // и добавляем новый узел в конец множества
            }
            size++; // Увеличиваем размер множества
        }
    }

    // Метод для удаления элемента из множества
    public void remove(T element) {
        if (head == null) { // Если множество пустое, выходим из метода
            return;
        }
        if (head.data.equals(element)) { // Если удаляемый элемент находится в начале множества,
            head = head.next; // переопределяем начало множества
            size--; // Уменьшаем размер множества
            return;
        }
        Node<T> current = head;
        while (current.next != null) { // Иначе ищем узел с удаляемым элементом
            if (current.next.data.equals(element)) {
                current.next = current.next.next; // Пропускаем узел с удаляемым элементом
                size--; // Уменьшаем размер множества
                return;
            }
            current = current.next;
        }
    }

    // Метод для проверки наличия элемента в множестве
    public boolean contains(T element) {
        Node<T> current = head;
        while (current != null) { // Перебираем все элементы множества
            if (current.data.equals(element)) { // Если нашли искомый элемент
                return true; // возвращаем true
            }
            current = current.next;
        }
        return false; // Если элемент не найден, возвращаем false
    }

    // Метод для получения размера множества
    public int size() {
        return size; // Возвращаем значение переменной size
    }
    // Метод для печати элементов множества
    public void printSet() {
        System.out.print("Множество: ");
        Node<T> current = head;
        while (current != null) { // Перебираем все элементы множества
            System.out.print(current.data + " "); // и печатаем их значения
            current = current.next;
        }
        System.out.println();
    }
}