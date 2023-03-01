import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/*
 * Пусть дан список сотрудников: Иван, Пётр, Антон и так далее. Написать программу, 
 * которая найдет и выведет повторяющиеся имена с количеством повторений.
 *  Отсортировать по убыванию популярности.
 */

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> employees = new HashMap<>();

        System.out.println("How many employees do you want to add?");
        int numNames = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numNames; i++) {
            System.out.println("Enter name:");
            String name = scanner.nextLine();
           

            

            if (employees.containsKey(name)) {
                employees.put(name, employees.get(name) + 1);
            } else {
                employees.put(name, 1);
            }

        }
        
        scanner.close();
        
        List<String> sortedNames = new ArrayList<>(employees.keySet());
        Collections.sort(sortedNames, (name1, name2) -> employees.get(name2) - employees.get(name1));
        

        for (String name : sortedNames) {
            if (employees.get(name) > 1) {
                System.out.println("\n" + name + " - " + employees.get(name) + " occurences");
            }
        }
    }
}

    

