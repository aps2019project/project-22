package Model;

public class MakeSpell {
    public void make() {
        Spell spell1 = new Spell("Total Disarm", 1000, 0, "ENEMY_ONE_CARD",
                "DISARM_ALL_TURNS");
        Spell.addSpell(spell1);

        Spell spell2 = new Spell("Area Dispel", 1500, 2, "SQUARE(2,2)",
                "ENEMY_DESTROY_POSETIVEBUFFES & SELF_DESTROY_NEGATIVEBUFFS");
        Spell.addSpell(spell2);

        Spell spell3 = new Spell("EMPOWER", 250, 1, "SELF_ONE_CARD",
                "ATTACKPOWER(+2)");
        Spell.addSpell(spell3);

        Spell spell4 = new Spell("FIREBALL", 250, 1, "ENEMY_ONE_CARD",
                "DESTROYED(+4)");
        Spell.addSpell(spell4);

        Spell spell5 = new Spell("God Strength", 450, 2, "SELF_HERO",
                "ATTACKPOWER(+4)");
        Spell.addSpell(spell5);

        Spell spell6 = new Spell("HellFire", 600, 3, "SQUARE(2,2)",
                "2_TURN_HOMEBURNEDEFFECT");
        Spell.addSpell(spell6);

        Spell spell7 = new Spell("Lighting Bolt", 1250, 2, "ENEMY_HERO",
                "DESTROYED(+4)");
        Spell.addSpell(spell7);

        Spell spell8 = new Spell("Poison Lake", 900, 5, "SQUARE(3,3)",
                "1_TURN_HOMEPOISONEDEFFECT");
        Spell.addSpell(spell8);

        Spell spell9 = new Spell("Maddness", 650, 0, "SELF_ONE_CARD",
                "1_TURN_HOMEPOISONEDEFFECT");
        Spell.addSpell(spell9);

        Spell spell10 = new Spell("All Disarm", 2000, 9, "ENEMY_ALL_CARD",
                "1_TURN_DISARM");
        Spell.addSpell(spell10);

        Spell spell11 = new Spell("All Poison", 1500, 8, "ENEMY_ALL_CARD",
                "4_TURN_POISONED");
        Spell.addSpell(spell11);

        Spell spell12 = new Spell("Dispel", 2100, 0, "ENEMY_OR_SELF_ONE_CARD",
                "ENEMY_DESTROY_POSETIVEBUFFES & SELF_DESTROY_NEGATIVEBUFFS");
        Spell.addSpell(spell12);

        Spell spell13 = new Spell("Health with profit", 2250, 0, "FRIEND_ONE_CARD",
                "add a weakness buff decrease 6 from health and add 2 holy buff for 3 times");
        Spell.addSpell(spell13);

        Spell spell14 = new Spell("Power up", 2500, 2, "SELF_ONE_CARD",
                "add a power buff add 6 to attackPower");
        Spell.addSpell(spell14);

        Spell spell15 = new Spell("All Power", 2000, 4, "SELF_ALL_CARD",
                "add powerBuff with increase 2 to attackPower");
        Spell.addSpell(spell15);

        Spell spell16 = new Spell("All Attack", 1500, 4, "ENEMY_ALL_CARD_ONE_COLUMN",
                "DESTROYED(+6)");
        Spell.addSpell(spell16);

        Spell spell17 = new Spell("Weakening", 1000, 1, "ENEMY_ONE_MINION_CARD",
                "add a weakness buff decrease 6 from attackPower");
        Spell.addSpell(spell17);

        Spell spell18 = new Spell("Sacrifice", 1600, 2, "SELF_ONE_MINION_CARD",
                "add a weakness buff decrease 6 from healthPower & add a powerbuff increase 8 to attachPower");
        Spell.addSpell(spell18);

        Spell spell19 = new Spell("Kings Guard", 1750, 9, "ENEMY_ONE_MINION_CARD_IN_8_CELL_AROUD_SELF_HERO",
                "KILL_ENEMY ");
        Spell.addSpell(spell19);

        Spell spell20 = new Spell("Shock", 1200, 1, "ENEMY_ONE_CARD",
                "2_TURB_STUN ");
        Spell.addSpell(spell20);
    }
}
