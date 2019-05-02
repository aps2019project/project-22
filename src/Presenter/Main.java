package Presenter;

import Model.Account;
import View.Show;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        menu(scanner);
    }

    public static void menu(Scanner scanner) {
        String input = scanner.nextLine().trim();
        if (input.equals("enter collection"))
            collectionMenu(scanner, account);

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
