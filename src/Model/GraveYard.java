package Model;

import java.util.ArrayList;

public class GraveYard {
    private static ArrayList<Card> cards = new ArrayList<>();
    private static ArrayList<Hero> heroes = new ArrayList<>();
    private static ArrayList<Spell> spells = new ArrayList<>();
    private static ArrayList<Minion> minions = new ArrayList<>();

    public static void addHero(Hero hero) {
        heroes.add(hero);
        cards.add(hero);
    }

    public static void addSpell(Spell spell) {
        spells.add(spell);
        cards.add(spell);
    }

    public static void addMinion(Minion minion) {
        minions.add(minion);
        cards.add(minion);
    }


    public static ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public static ArrayList<Spell> getSpells() {
        return spells;
    }

    public static ArrayList<Minion> getMinions() {
        return minions;
    }


    public static ArrayList<Card> getCards() {
        return cards;
    }

    public void addCards(Card card) {
        this.cards.add(card);
    }
}