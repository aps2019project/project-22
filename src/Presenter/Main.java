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
        switch (input) {
            case "exit":
                return;
            case "show":
                Show.showCollection(account);
                break;
        }
    }

}
