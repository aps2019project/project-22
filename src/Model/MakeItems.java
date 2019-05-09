package Model;

public class MakeItems {
    public static void make() {
        Item[] items = new Item[20];
        items[0] = new Item(71, "taje danaii", 300, "increase one unit mana in 3 turns ");
        items[1] = new Item(72, "namus separ", 4000, "active 12 holy buff in insider hero");
        items[2] = new Item(73, "kaman damul", 30000,
                "only for ranged or hybrid:disarm enemy power by insider hero");
        items[3] = new Item(74, "nushdaru", -1, "increase 6 unit ap of random power");
        items[4] = new Item(75, "tire 2 shakh", -1, "increase 2 unit ap of random ranged or hybrid ");
        items[5] = new Item(76, "pare simorq", 3500,
                "for ranged or hybrid: decrease 2 unit of ap of enemy ");
        items[6] = new Item(77, "eksir", -1,
                "increase 3 unit ap and power buff with increase 3 unit ap for random minion ");
        items[7] = new Item(78, "majun mana", -1, "increase 3 unit mana in next turn");
        items[8] = new Item(79, "majun roiin tani", -1,
                "active 10 holy buff for 2 turn in random insider power");
        items[9] = new Item(80, "nefrine marg", -1,
                "for random minion: 8 random strike to the closest person in death time");
        items[10] = new Item(81, "Random damage", -1, "2 power strike for random power");
        items[11] = new Item(82, "Terror Hood", 5000,
                "apply weakness buff with decrease 2 units for 1 turn to random enemy power in strike time");
        items[12] = new Item(83, "Blades of agility", -1, "increase 6 unit ap to random power");
        items[13] = new Item(84, "King Wisdom", 9000, "increase manapoint in all turn");
        items[14] = new Item(85, "Assassination Dagger", 15000,
                "strike 1 unit when putting insider power ");
        items[15] = new Item(86, "Poisonous Dagger", 7000,
                "apply posion buff on random power when strike insider power for once");
        items[16] = new Item(87, "Shock Hammer", 15000,
                "disarm enemy power by insider hero in strike time");
        items[17] = new Item(88, "Soul Eater", 25000,
                "apply 1 power buff with 1 unit ap on insider power in death time");
        items[18] = new Item(89, "qosle tamid", 20000, "every minion when spawn get 2 holy buff ");
        items[19] = new Item(90, "shamshir chini", -1, "for melee's power: give 5 strike power");

        for (int i = 0; i < 20; i++) {
            Item.addItem(items[i]);
            Shop.addItem(items[i]);
        }
    }
}
