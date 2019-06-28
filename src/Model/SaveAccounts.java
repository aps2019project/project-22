package Model;

import java.io.*;
import java.util.ArrayList;

public class SaveAccounts {

    public static void save() {
        try {
            FileWriter fileWriter = new FileWriter("Accounts.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < Account.getAccounts().size(); i++) {
                String txt = "" + Account.getAccounts().get(i).getUserName() + " " +
                        Account.getAccounts().get(i).getPassword() + " " + Account.getAccounts().get(i).getID()
                        + " " + Account.getAccounts().get(i).getMoney() + " " + Account.getAccounts().get(i).getWins()
                        + " " + Account.getAccounts().get(i).getStory()+" ";
                for (int l = 0; l < txt.length(); l++)
                    fileWriter.write(txt.charAt(l));
            }
            fileWriter.write("|");
            bufferedWriter.close();
        } catch (Exception name) {
            System.out.println(name);
        }
        System.out.println("saved!");
    }

    public static void read() {
        ArrayList<Account> accounts = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("Accounts.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String[] line = bufferedReader.readLine().split("\\s+");
            for (int i = 0; i < line.length; i++) {
                Account account = new Account(line[i], line[i + 1]);
                account.setID(Integer.parseInt(line[i + 2]));
                account.setMoney(Integer.parseInt(line[i + 3]));
                account.setWins(Integer.parseInt(line[i + 4]));
                account.setStory(Integer.parseInt(line[i + 5]));
                account.setMatchHistory(new ArrayList<MatchHistory>());
                account.setCollection(new Collection());
                accounts.add(account);
                i += 5;
            }
            Account.setAccounts(accounts);
        } catch (Exception name) {
        }
        System.out.println("read");
        for (int i = 0; i < Account.getAccounts().size(); i++)
            System.out.println(Account.getAccounts().get(i).getUserName());
        for (int i = 0; i < accounts.size(); i++)
            System.out.println(accounts.get(i).getUserName());
    }
}
