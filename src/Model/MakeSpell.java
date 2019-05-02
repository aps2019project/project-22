package Model;

public class MakeSpell {
    public void make() {
        Spell[] spells = new Spell[20];
        spells[0] = new Spell(41, "Total Disarm", 1000, 0, "ENEMY_ONE_CARD",
                "DISARM_ALL_TURNS");

        spells[1] = new Spell(42, "Area Dispel", 1500, 2, "SQUARE(2,2)",
                "ENEMY_DESTROY_POSETIVEBUFFES & SELF_DESTROY_NEGATIVEBUFFS");


        spells[2] = new Spell(43, "EMPOWER", 250, 1, "SELF_ONE_CARD",
                "ATTACKPOWER(+2)");

        spells[3] = new Spell(44, "FIREBALL", 250, 1, "ENEMY_ONE_CARD",
                "DESTROYED(+4)");


        spells[4] = new Spell(45, "God Strength", 450, 2, "SELF_HERO",
                "ATTACKPOWER(+4)");

        spells[5] = new Spell(46, "HellFire", 600, 3, "SQUARE(2,2)",
                "2_TURN_HOMEBURNEDEFFECT");

        spells[6] = new Spell(47, "Lighting Bolt", 1250, 2, "ENEMY_HERO",
                "DESTROYED(+4)");

        spells[7] = new Spell(48, "Poison Lake", 900, 5, "SQUARE(3,3)",
                "1_TURN_HOMEPOISONEDEFFECT");

        spells[8] = new Spell(49, "Maddness", 650, 0, "SELF_ONE_CARD",
                "1_TURN_HOMEPOISONEDEFFECT");

        spells[9] = new Spell(50, "All Disarm", 2000, 9, "ENEMY_ALL_CARD",
                "1_TURN_DISARM");

        spells[10] = new Spell(51, "All Poison", 1500, 8, "ENEMY_ALL_CARD",
                "4_TURN_POISONED");

        spells[11] = new Spell(52, "Dispel", 2100, 0, "ENEMY_OR_SELF_ONE_CARD",
                "ENEMY_DESTROY_POSETIVEBUFFES & SELF_DESTROY_NEGATIVEBUFFS");

        spells[12] = new Spell(53, "Health with profit", 2250, 0, "FRIEND_ONE_CARD",
                "add a weakness buff decrease 6 from health and add 2 holy buff for 3 times");

        spells[13] = new Spell(54, "Power up", 2500, 2, "SELF_ONE_CARD",
                "add a power buff add 6 to attackPower");

        spells[14] = new Spell(55, "All Power", 2000, 4, "SELF_ALL_CARD",
                "add powerBuff with increase 2 to attackPower");

        spells[15] = new Spell(56, "All Attack", 1500, 4, "ENEMY_ALL_CARD_ONE_COLUMN",
                "DESTROYED(+6)");

        spells[16] = new Spell(57, "Weakening", 1000, 1, "ENEMY_ONE_MINION_CARD",
                "add a weakness buff decrease 6 from attackPower");

        spells[17] = new Spell(58, "Sacrifice", 1600, 2, "SELF_ONE_MINION_CARD",
                "add a weakness buff decrease 6 from healthPower & add a power buff increase 8 to attachPower");

        spells[18] = new Spell(59, "Kings Guard", 1750, 9, "ENEMY_ONE_MINION_CARD_IN_8_CELL_AROUND_SELF_HERO",
                "KILL_ENEMY ");

        spells[19] = new Spell(60, "Shock", 1200, 1, "ENEMY_ONE_CARD",
                "2_TURN_STUN ");
        for (int i = 0; i < 20; i++) {
            Spell.addSpell(spells[i]);
        }
    }

}