package View;

import Model.*;

import java.util.Scanner;

public class Show {
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
        } else if ("save".equals(input)) {
            account.getCollection().save();
        } else if ("help".equals(input)) {
            Show.helpInCollection();
        }
    }

    public static void showMainMenu(Scanner scanner) {
        String input = scanner.nextLine().trim();
        Account account = new Account();
        System.out.println("1. Collection\n2. Shop\n3. Battle\n4. Exit\n5. Help");
        switch (input) {
            case "Enter collection":
                collectionMenu(scanner, account);
                break;
            case "Enter shop":
                shopMenu(scanner, account);
                break;
            case "Enter battle":
               showBattleMenu (scanner,);
                break;
            case "Exit":
                return;
            case "Help":
                showMainMenu(scanner);
                break;
        }
    }

//    private static void battleMenu(Scanner scanner, Account account) {
//        System.out.println("1.Single player\n2.Multi player");
//        String input = scanner.nextLine().trim();
//        if (input.equals("Single player") || input.equals("single player")) {
//            singlePlayerMenu(scanner, account);
//        } else if (input.equals("Multi player") || input.equals("multi player")) {
//            multiPlayerMenu(scanner, account);
//        } else if (input.equals("exit") || input.equals("Exit")) {
//            return;
//        } else {
//            battleMenu(scanner, account);
//        }
//    }
//
//    private static void singlePlayerMenu(Scanner scanner, Account account) {
//        System.out.println("1. Story\n2.Custom game");
//        String input = scanner.nextLine().trim();
//        if (input.equals("Story") || input.equals("story")) {
//            story(scanner, account);
//        } else if (input.equals("Custom game") || input.equals("custom game")) {
//            customGame(scanner, account);
//        } else if (input.equals("exit") || input.equals("Exit")) {
//            return;
//        } else {
//            singlePlayerMenu(scanner, account);
//        }
//    }

//    private static void customGame(Scanner scanner, Account account) {
//    }
//
//    private static void story(Scanner scanner, Account account) {
//    }
//
//
//    private static void multiPlayerMenu(Scanner scanner, Account account) {
//        showAllUserNames();
//        while (true) {
//            System.out.println("please enter username");
//            String input = scanner.nextLine().trim();
//            String[] partsOfInput = input.split("\\s+");
//            if (partsOfInput.length > 2 && partsOfInput[0].equals("Select") && partsOfInput[1].equals("user")) {
//                Account enemy = Account.searchByUserName(partsOfInput[2]);
//                if (enemy != null) {
//                    // multi player game
//                    return;
//                }
//            }
//            if(input.equals("exit")||input.equals("Exit")){
//                return;
//            }
//        }
//    }

    private static void showAllUserNames() {
        for (int i = 0; i < Account.getAccounts().size(); i++) {
            System.out.println((i + 1)+".  " + Account.getAccounts().get(i).getUserName());
        }
    }


    private static void shopMenu(Scanner scanner, Account account) {
    }

    public static void showCollection(Account account) {
        Collection collection = account.getCollection();
        int number = 1;
        System.out.println("Heroes :");
        for (int i = 0; i < collection.getHeroes().size(); i++) {
            System.out.println("\t" + number + " : Name : " + collection.getHeroes().get(i).getName() + " - AP : " +
                    collection.getHeroes().get(i).getAttackPower() + " - HP : " + collection.getHeroes().get(i).
                    getHealthPoint() + " - Class : " + collection.getHeroes().get(i).getTypeOfAttack() +
                    " - Special power: " + "attack" + " - price: " + collection.getHeroes().get(i).getPrice());
            //attack nmidunm jash chie!
            number++;
        }
        number = 1;
        System.out.println("Items :");
        for (int i = 0; i < collection.getItems().size(); i++) {
            System.out.println("\t" + number + " : Name : " + collection.getItems().get(i).getName() + " Desc: " +
                    collection.getItems().get(i).getDescription() + " - price: " + collection.getItems().get(i).getPrice());
            number++;
        }
        number = 1;
        System.out.println("Cards :");
        for (int i = 0; i < collection.getSpells().size(); i++) {
            System.out.println("\t" + number + " : Type : Spell - Name : " + collection.getSpells().get(i).getName() +
                    " - MP : " + collection.getSpells().get(i).getMana() + " - " +
                    collection.getSpells().get(i).getDescription() + " - price: " + collection.getSpells().get(i).getPrice());
            number++;
        }
        for (int i = 0; i < collection.getMinions().size(); i++) {
            System.out.println("\t" + number + " : Type : Minion - Name : " + collection.getMinions().get(i).getName()
                    + " - Class: " + collection.getMinions().get(i).getTypeOfAttack() + " - AP : " + collection.
                    getMinions().get(i).getAttackPower() + " - HP : " + collection.getMinions().get(i).getHealthPoint()
                    + " - MP : " + collection.getMinions().get(i).getManaPoint() + " - Special power : " +
                    collection.getMinions().get(i).getSpecialPower() + " - price: " + collection.getMinions().get(i).getPrice());
            number++;
        }
    }

    public static void helpInCollection() {
        System.out.println("-exit\n-show\n-search[card name | item name]\n-save\ncreate deck[deck name]\n-delete deck" +
                "[deck name]\n-add[card id | card id |hero id| to deck [deck name]\n-remove" +
                "[ card id|card id|hero id| lfrom deck[deck name]\n-validate deck[ deck name]\n-selsect deck" +
                " [ deck name]\n-show all decks\n-show deck [deck name]\n-help");
    }

    public static void showBattleMenu(Scanner scanner, Battle battle) {
        System.out.println("1.single player");
        System.out.println("2.multi player");
        int singleOrMulti = scanner.nextInt();
        if (singleOrMulti == 1) {
            battle.setBooleanSinglePlayerTrue();
            System.out.println("1.Story");
            System.out.println("2.Custom game");
            int storyOrCustom = scanner.nextInt();
            if (storyOrCustom == 1) {
                battle = new Story();
                System.out.println("1.level1\n2.level2\n3.level3");
                int level = scanner.nextInt();
                if (level == 1) {
                    ((Story) battle).setLevel(1);
                } else if (level == 2) {
                    ((Story) battle).setLevel(2);
                } else if (level == 3) {
                    ((Story) battle).setLevel(3);
                }
            }
        } else if (singleOrMulti == 2) {
            showAllUserNames();
            battle = new CustomGame();
        }
    }
}
