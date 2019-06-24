package Model;

public class MakeHero {

    public static void make() {

        Hero[] heroes = new Hero[10];

        heroes[0] = new Hero("file:C:\\Users\\MS\\Desktop\\project-22-master\\1 (41)\\breathing.GIF",
                "file:C:\\Users\\MS\\Desktop\\project-22-master\\1 (41)\\attack.GIF",
                "file:C:\\Users\\MS\\Desktop\\project-22-master\\1 (41)\\run.GIF",
                61, "diveSefid", 8000, 50, 4, "melee",
                -1, 1, 2);
        heroes[1] = new Hero("file:C:\\Users\\MS\\Desktop\\project-22-master\\1 (42)\\breathing.GIF",
                "file:C:\\Users\\MS\\Desktop\\project-22-master\\1 (42)\\attack.GIF",
                "file:C:\\Users\\MS\\Desktop\\project-22-master\\1 (42)\\run.GIF",
                62, "simorq", 9000, 50, 4, "melee",
                -1, 5, 8);
        heroes[2] = new Hero("file:C:\\Users\\MS\\Desktop\\project-22-master\\1 (43)\\breathing.GIF",
                "file:C:\\Users\\MS\\Desktop\\project-22-master\\1 (43)\\attack.GIF",
                "file:C:\\Users\\MS\\Desktop\\project-22-master\\1 (43)\\run.GIF",
                63, "ejdehaye7sar", 8000, 50, 4, "melee",
                -1, 0, 1);
        heroes[3] = new Hero("file:C:\\Users\\MS\\Desktop\\project-22-master\\1 (44)\\breathing.GIF",
                "file:C:\\Users\\MS\\Desktop\\project-22-master\\1 (44)\\attack.GIF",
                "file:C:\\Users\\MS\\Desktop\\project-22-master\\1 (44)\\run.GIF",
                64, "rakhsh", 8000, 50, 4, "melee",
                -1, 1, 2);
        heroes[4] = new Hero("file:C:\\Users\\MS\\Desktop\\project-22-master\\1 (45)\\breathing.GIF",
                "file:C:\\Users\\MS\\Desktop\\project-22-master\\1 (45)\\attack.GIF",
                "file:C:\\Users\\MS\\Desktop\\project-22-master\\1 (45)\\run.GIF",
                65, "zahak", 10000, 50, 2, "melee",
                -1, -1, -1);
        heroes[5] = new Hero("file:C:\\Users\\MS\\Desktop\\project-22-master\\1 (46)\\breathing.GIF",
                "file:C:\\Users\\MS\\Desktop\\project-22-master\\1 (46)\\attack.GIF",
                "file:C:\\Users\\MS\\Desktop\\project-22-master\\1 (46)\\run.GIF",
                66, "kaveh", 8000, 50, 4, "melee",
                -1, 1, 3);
        heroes[6] = new Hero("file:C:\\Users\\MS\\Desktop\\project-22-master\\1 (49)\\breathing.GIF",
                "file:C:\\Users\\MS\\Desktop\\project-22-master\\1 (49)\\attack.GIF",
                "file:C:\\Users\\MS\\Desktop\\project-22-master\\1 (49)\\run.GIF",
                67, "arash", 10000, 30, 2, "ranged",
                6, 2, 2);
        heroes[7] = new Hero("file:C:\\Users\\MS\\Desktop\\project-22-master\\1 (47)\\breathing.GIF",
                "file:C:\\Users\\MS\\Desktop\\project-22-master\\1 (47)\\attack.GIF",
                "file:C:\\Users\\MS\\Desktop\\project-22-master\\1 (47)\\run.GIF",
                68, "afsane", 11000, 40, 3, "ranged",
                3, 1, 2);
        heroes[8] = new Hero("file:C:\\Users\\MS\\Desktop\\project-22-master\\1 (48)\\breathing.GIF",
                "file:C:\\Users\\MS\\Desktop\\project-22-master\\1 (48)\\attack.GIF",
                "file:C:\\Users\\MS\\Desktop\\project-22-master\\1 (48)\\run.GIF",
                69, "esfandiar", 12000, 35, 3, "hybrid",
                3, -1, -1);
        heroes[9] = new Hero("file:C:\\Users\\MS\\Desktop\\project-22-master\\1 (50)\\breathing.GIF",
                "file:C:\\Users\\MS\\Desktop\\project-22-master\\1 (50)\\attack.GIF",
                "file:C:\\Users\\MS\\Desktop\\project-22-master\\1 (50)\\run.GIF",
                70, "rostam", 8000, 55, 7, "hybrid",
                4, -1, -1);

        for (int i = 0; i < 10; i++) {
            Hero.addHero(heroes[i]);
            Card.addCard(heroes[i]);
            //Shop.addHero(heroes[i]);
        }

    }
}
