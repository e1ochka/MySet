package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MySet<Integer> mySet = new MySet<>();
        mySet.add(10);
        mySet.add(20);
        mySet.add(30);
        mySet.add(20); // Дубликат, не будет добавлен
        mySet.remove(10);
        mySet.printSet();
        System.out.println("Размер множества: " + mySet.size());
    }
}