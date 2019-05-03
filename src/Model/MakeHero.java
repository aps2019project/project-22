package Model;

public class MakeHero {

    public void make() {

        Hero[] heroes = new Hero[10];

        heroes[0] = new Hero(61, "dive sefid", 8000, 50, 4, "Melee", -1, 1, 2);
        heroes[1] = new Hero(62, "simorq", 9000, 50, 4, "Melee", -1, 5, 8);
        heroes[2] = new Hero(63, "ejdehaye 7sar", 8000, 50, 4, "Melee", -1, 0, 1);
        heroes[3] = new Hero(64, "rakhsh", 8000, 50, 4, "Melee", -1, 1, 2);
        heroes[4] = new Hero(65, "zahak", 10000, 50, 2, "Melee", -1, -1, -1);
        heroes[5] = new Hero(66, "kaveh", 8000, 50, 4, "Melee", -1, 1, 3);
        heroes[6] = new Hero(67, "arash", 10000, 30, 2, "ranged", 6, 2, 2);
        heroes[7] = new Hero(68, "afsane", 11000, 40, 3, "ranged", 3, 1, 2);
        heroes[8] = new Hero(69, "esfandiar", 12000, 35, 3, "hybrid", 3, -1, -1);
        heroes[9] = new Hero(70, "rostam", 8000, 55, 7, "hybrid", 4, -1, -1);

        for (int i = 0; i < 10; i++) {
            Hero.addHero(heroes[i]);
            Card.addCard(heroes[i]);
        }

    }
}
