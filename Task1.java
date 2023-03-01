import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/*
 * Реализуйте структуру телефонной книги с помощью HashMap, учитывая, 
 * что один человек может иметь несколько телефонов.
 */

/**
 * Task1
 */
public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, List<String>> phoneBook = new HashMap<String, List<String>>();

        System.out.println("How many names do you want to add?");
        int numNames = scanner.nextInt();
        scanner.nextLine();
        

        for (int i = 0; i < numNames; i++) {
            System.out.println("Enter name:");
        
            String name = scanner.nextLine();

            System.out.println("Enter phone number:");
            String phoneNumber = scanner.nextLine();

            add(phoneBook, name, phoneNumber);

            while (true) {
                System.out.println("Add another phone number? (y/n)");
                String answer = scanner.nextLine();
                if (answer.equals("y")) {
                    System.out.println("Enter phone number:");
                    phoneNumber = scanner.nextLine();
                    scanner.close();

                    add(phoneBook, name, phoneNumber);
                } else if (answer.equals("n")) {
                    break;
                } else {
                    System.out.println("Invalid answer, please enter 'y' or 'n'");
                }
            }
        }

        System.out.println(phoneBook);
    }

    public static void add(HashMap<String, List<String>> phoneBook, String name, String phoneNumber) {
        List<String> numbers = phoneBook.getOrDefault(name, new ArrayList<String>());
        
        numbers.add(phoneNumber);
        phoneBook.put(name, numbers);
    }
}

