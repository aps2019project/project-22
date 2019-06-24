package Model;

public class MakeItems {
    public static void make() {
        Item[] items = new Item[20];
        items[0] = new Item(71, "tajeDanaii", 300, "increase one unit mana in 3 turns ");
        items[1] = new Item(72, "namusSepar", 4000, "active 12 holy buff in insider hero");
        items[2] = new Item(73, "kamanDamul", 30000,
                "only for ranged or hybrid:disarm enemy power by insider hero");
        items[3] = new Item(74, "nushdaru", -1, "increase 6 unit ap of random power");
        items[4] = new Item(75, "tire2shakh", -1, "increase 2 unit ap of random ranged or hybrid ");
        items[5] = new Item(76, "pareSimorq", 3500,
                "for ranged or hybrid: decrease 2 unit of ap of enemy ");
        items[6] = new Item(77, "eksir", -1,
                "increase 3 unit ap and power buff with increase 3 unit ap for random minion ");
        items[7] = new Item(78, "majunMana", -1, "increase 3 unit mana in next turn");
        items[8] = new Item(79, "majunRoiinTani", -1,
                "active 10 holy buff for 2 turn in random insider power");
        items[9] = new Item(80, "nefrineMarg", -1,
                "for random minion: 8 random strike to the closest person in death time");
        items[10] = new Item(81, "RandomDamage", -1, "2 power strike for random power");
        items[11] = new Item(82, "TerrorHood", 5000,
                "apply weakness buff with decrease 2 units for 1 turn to random enemy power in strike time");
        items[12] = new Item(83, "BladesOfAgility", -1, "increase 6 unit ap to random power");
        items[13] = new Item(84, "KingWisdom", 9000, "increase manapoint in all turn");
        items[14] = new Item(85, "AssassinationDagger", 15000,
                "strike 1 unit when putting insider power ");
        items[15] = new Item(86, "PoisonousDagger", 7000,
                "apply posion buff on random power when strike insider power for once");
        items[16] = new Item(87, "ShockHammer", 15000,
                "disarm enemy power by insider hero in strike time");
        items[17] = new Item(88, "SoulEater", 25000,
                "apply 1 power buff with 1 unit ap on insider power in death time");
        items[18] = new Item(89, "qosleTamid", 20000, "every minion when spawn get 2 holy buff ");
        items[19] = new Item(90, "shamshirChini", -1, "for melee's power: give 5 strike power");

        for (int i = 0; i < 20; i++) {
            Item.addItem(items[i]);
            Shop.addItem(items[i]);
        }
    }
}
