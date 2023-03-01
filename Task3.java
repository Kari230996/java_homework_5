/*
 * Реализовать алгоритм пирамидальной сортировки (HeapSort)
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> randomNumbers = new ArrayList<>();

        // Сгенерируем 10 случайных чисел от 1 до 20
        for (int i = 0; i < 10; i++) {
            int randomNumb = random.nextInt(20) + 1;
            randomNumbers.add(randomNumb);
        }

        System.out.println("Unsorted list of random numbers:");
        System.out.println(randomNumbers);

        heapSort(randomNumbers);

        System.out.println("Sorted list of random numbers: ");
        System.out.println(randomNumbers);
    }

    public static void heapSort(List<Integer> list) {
        int n = list.size();

        // создадим макс кучу с неотсортированного списка

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(list, n, i);

        // Извлекаем элементы из кучи один за другим
        for (int i = n - 1; i >= 0; i--) {
            // Меняем местами первый (максимальный) элемент с последним элементом
            int temp = list.get(0);
            list.set(0, list.get(i));
            list.set(i, temp);

            // Уменьшаем размер кучи на единицу и увеличиваем несортированный список
            heapify(list, i, 0);

        }
    }

    public static void heapify(List<Integer> list, int n, int i) {
        int largest = i; // Инициализируем наибольший как root
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Если левый дочерний элемент больше, чем корень
        if (left < n && list.get(left) > list.get(largest))
            largest = left;

        // Если правый ребенок больше, чем самый большой на данный момент
        if (right < n && list.get(right) > list.get(largest))
            largest = right;

        // Если самый большой не корень
        if (largest != i) {
            // Меняем местами наибольший элемент с корневым элементом
            int temp = list.get(i);
            list.set(i, list.get(largest));
            list.set(largest, temp);

            heapify(list, n, largest);
        }
    }

}
