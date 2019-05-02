package Model;

public class MakeItems {
    public void make() {
        Item[] items = new Item[20];
        items[0] = new Item(71, "taje danaii", 300);
        items[1] = new Item(72, "namus separ", 4000);
        items[2] = new Item(73, "kaman damul", 30000);
        items[3] = new Item(74, "nushdaru", -1);
        items[4] = new Item(75, "tire 2 shakh", -1);
        items[5] = new Item(76, "pare simorq", 3500);
        items[6] = new Item(77, "eksir", -1);
        items[7] = new Item(78, "majun mana", -1);
        items[8] = new Item(79, "majun roiin tani", -1);
        items[9] = new Item(80, "nefrine marg", -1);
        items[10] = new Item(81, "Random damage", -1);
        items[11] = new Item(82, "Terror Hood", 5000);
        items[12] = new Item(83, "Blades of agility", -1);
        items[13] = new Item(84, "King Wisdom", 9000);
        items[14] = new Item(85, "Assassination Dagger", 15000);
        items[15] = new Item(86, "Poisonous Dagger", 7000);
        items[16] = new Item(87, "Shock Hammer", 15000);
        items[17] = new Item(88, "Soul Eater", 25000);
        items[18] = new Item(89, "qosle tamid", 20000);
        items[19] = new Item(90, "shamshir chini", -1);

        for (int i = 0; i < 20; i++) {
            Item.addItem(items[i]);
        }
    }
}
