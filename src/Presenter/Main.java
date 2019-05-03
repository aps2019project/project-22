package Presenter;

import Model.Account;
import View.Show;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        mainMenu(scanner);
    }

    public static void mainMenu(Scanner scanner) {
        String input = scanner.nextLine().trim();
        System.out.println("1. Collection\n2. Shop\n3. Battle\n4. Exit\n5. Help");
        switch (input) {
            case "Enter collection":
                collectionMenu(scanner, account);
                break;
            case "Enter shop":
                shopMenu(scanner, account);
                break;
            case "Enter battle":
                battleMenu(scanner, account);
                break;
            case "Exit":
                return;
            case "Help":
                mainMenu(scanner);
                break;
        }
    }

    private static void helpInMainMenu() {
    }

    private static void battleMenu(Scanner scanner, Account account) {
    }

    private static void shopMenu(Scanner scanner,Account account) {
    }

    private static void collectionMenu(Scanner scanner, Account account) {
        String input = scanner.nextLine().trim();
        String[] partsOfInput = input.split("\\s+");
        if ("exit".equals(input)) {
            return;
        } else if ("show".equals(input)) {
            Show.showCollection(account);
        } else if (partsOfInput[0].equals("search")) {
            if (account.getCollection().search(partsOfInput[1]) != -1)
                System.out.println(account.getCollection().search(partsOfInput[1]));
        } else if("save".equals(input)){
            account.getCollection().save();
        } else if("help".equals(input)){
            Show.helpInCollection();
        }
    }

}
