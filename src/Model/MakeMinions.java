package Model;

public class MakeMinions {
    public static void make() {
        Minion[] minions = new Minion[40];
        minions[0] = new Minion("file:1/breathing.GIF", "file:1/attack.GIF", "file:1/run.GIF",
                1, "kamandareFars", 300, 2, 6, 4,
                "ranged", 7, "not", "Nothing");
        minions[1] = new Minion("file:1 (2)/breathing.GIF", "file:1 (2)/attack.GIF", "file:1 (2)/run.GIF",
                2, "shamshirzaneFars", 400, 2, 6, 4,
                "melee", -1, "On Attack", "stun power when attack");
        minions[2] = new Minion("file:1 (3)breathing.GIF", "file:1 (3)attack.GIF", "file:1 (3)run.GIF",
                3, "neyzedareFars", 500, 1, 5, 3,
                "hibrid", 3, "not", "Nothing");
        minions[3] = new Minion("file:1 (4)/breathing.GIF", "file:1 (4)/attack.GIF", "file:1 (4)/run.GIF", 4, "asbsavareFars", 200, 4, 10, 6,
                "melee", -1, "not", "Nothing");
        minions[4] = new Minion("file:1 (5)/breathing.GIF", "file:1 (5)/attack.GIF", "file:1 (5)/run.GIF",
                5, "pahlevaneFars", 600, 9, 24, 6,
                "melee", -1, "On Attack", "5 unit more for attack power");
        minions[5] = new Minion("file:1 (6)/breathing.GIF", "file:1 (6)/attack.GIF", "file:1 (6)/run.GIF",
                6, "sepahsalareFars", 800, 7, 12, 4,
                "melee", -1, "combo", "Combo");
        minions[6] = new Minion("file:1 (7)/breathing.GIF", "file:1 (7)/attack.GIF", "file:1 (7)/run.GIF",
                7, "kamandareTurani", 500, 1, 3, 4,
                "ranged", 5, "not", "Nothing");
        minions[7] = new Minion("file:1 (8)/breathing.GIF", "file:1 (8)/attack.GIF", "file:1 (8)/run.GIF", 8, "qolabSangdare", 600, 1, 4, 2,
                "ranged", 7, "not", "Nothing");
        minions[8] = new Minion("file:1 (9)/breathing.GIF", "file:1 (9)/attack.GIF", "file:1 (9)/run.GIF", 9, "neyzedareTurani", 600, 1, 4, 4,
                "hybrid", 3, "not", "Nothing");
        minions[9] = new Minion("file:1 (10)/breathing.GIF", "file:1 (10)/attack.GIF", "file:1 (10)/run.GIF", 10, "jasuseTurani", 700, 4, 6, 6,
                "melee", -1, "On Attack", "disarm power of enemy and 4 poison");
        minions[10] = new Minion("file:1 (11)/breathing.GIF", "file:1 (11)/attack.GIF", "file:1 (11)/run.GIF",
                11, "gorzdareTurani", 450, 2, 3, 10,
                "melee", -1, "not", "Nothing");
        minions[11] = new Minion("file:1 (12)/breathing.GIF", "file:1 (12)/attack.GIF", "file:1 (12)/run.GIF",
                12, "shahzadeYeTurani", 800, 6, 6, 10,
                "melee", -1, "combo", "Combo");
        minions[12] = new Minion("file:1 (13)/breathing.GIF", "file:1 (13)/attack.GIF", "file:1 (13)/run.GIF", 13, "divSiah", 300, 9, 14, 10,
                "hybrid", 7, "not", "Nothing");
        minions[13] = new Minion("file:1 (14)/breathing.GIF", "file:1 (14)/attack.GIF", "file:1 (14)/run.GIF",
                14, "quleSangandaz", 300, 9, 12, 12,
                "ranged", 7, "not", "Nothing");
        minions[14] = new Minion("file:1 (15)/breathing.GIF", "file:1 (15)/attack.GIF", "file:1 (15)/run.GIF",
                15, "oqab", 200, 2, 0, 2,
                "ranged", 3, "passive", "10 unit power buff with increase your hurt");
        minions[15] = new Minion("file:1 (16)/breathing.GIF", "file:1 (16)/attack.GIF", "file:1 (16)/run.GIF",
                16, "DiveGorazsavar", 300, 6, 16,
                8, "melee", -1, "not", "Nothing");
        minions[16] = new Minion("file:1 (17)/breathing.GIF", "file:1 (17)/attack.GIF", "file:1 (17)/run.GIF",
                17, "quleTakCheshm", 500, 7, 12, 11,
                "hybrid", 3, "On Death", "attack to minions of 8 cell by 2 unit power");
        minions[17] = new Minion("file:1 (18)/breathing.GIF", "file:1 (18)/attack.GIF", "file:1 (18)/run.GIF",
                18, "mareSammi", 300, 4, 5, 6,
                "ranged", 4, "On Attack", "posion power of enemy for 3 turns");
        minions[18] = new Minion("file:1 (19)/breathing.GIF", "file:1 (19)/attack.GIF", "file:1 (19)/run.GIF",
                19, "ejdehayeAtashandaz", 250, 5, 9,
                5, "ranged", 4, "not", "Nothing");
        minions[19] = new Minion("file:1 (20)/breathing.GIF", "file:1 (20)/attack.GIF", "file:1 (20)/run.GIF",
                20, "shireDarandeh", 600, 2, 1, 8,
                "melee", -1, "On Attack", "no effect holy buff on");
        minions[20] = new Minion("file:1 (21)/breathing.GIF", "file:1 (21)/attack.GIF", "file:1 (21)/run.GIF", 21, "mareQulpeykar", 500, 8, 14, 7,
                "ranged", 5, "On Spawn", "Opposite holy buff");
        minions[21] = new Minion("file:1 (22)/breathing.GIF", "file:1 (22)/attack.GIF", "file:1 (22)/run.GIF",
                22, "gorgeSefid", 400, 5, 8, 2,
                "melee", -1, "On Attack", "decrease 6 and 4 unit health point for attack to minion");
        minions[22] = new Minion("file:1 (23)/breathing.GIF", "file:1 (23)/attack.GIF", "file:1 (23)/run.GIF",
                23, "palang", 400, 4, 6, 2,
                "melee", -1, "On Attack", "decrease 8unit health point from minion");
        minions[23] = new Minion("file:1 (24)/breathing.GIF", "file:1 (24)/attack.GIF", "file:1 (24)/run.GIF",
                24, "gorg", 400, 3, 6, 1,
                "melee", -1, "On Attak", "decrease 8unit health point from minion in next turn");
        minions[24] = new Minion("file:1 (25)/breathing.GIF", "file:1 (25)/attack.GIF", "file:1 (25)/run.GIF",
                25, "jadugar", 550, 4, 5, 4,
                "ranged", 3, "passive", "1 power by 2 unit of power and 1 weakness by 1 unit of healthy point");
        minions[25] = new Minion("file:1 (26)/breathing.GIF", "file:1 (26)/attack.GIF", "file:1 (26)/run.GIF",
                26, "jadugareAzam", 550, 6, 6, 6,
                "ranged", 5, "passive",
                "1 power by 2unit attack power and 1 holy buff with contius");
        minions[26] = new Minion("file:1 (27)/breathing.GIF", "file:1 (27)/attack.GIF", "file:1 (27)/run.GIF", 27, "jen", 500, 5, 10, 4,
                "ranged", 4, "On Turn",
                "add power buff by 1 unit attack power with continuous for all minions");
        minions[27] = new Minion("file:1 (28)/breathing.GIF", "file:1 (28)/attack.GIF", "file:1 (28)/run.GIF",
                28, "gorazeVahshi", 500, 6, 10, 14,
                "melee", -1, "On Defend", "not disarm");
        minions[28] = new Minion("file:1 (29)/breathing.GIF", "file:1 (29)/attack.GIF", "file:1 (29)/run.GIF",
                29, "piran", 400, 8, 20, 12,
                "melee", -1, "On Defend", "not posion");
        minions[29] = new Minion("file:1 (30)/breathing.GIF", "file:1 (30)/attack.GIF", "file:1 (30)/run.GIF",
                30, "giv", 450, 4, 5, 7,
                "ranged", 5, "On Defend", "not negative buff");
        minions[30] = new Minion("file:1 (31)/breathing.GIF", "file:1 (31)/attack.GIF", "file:1 (31)/run.GIF",
                31, "bahman", 450, 8, 16, 9,
                "melee", -1, "On Spawn", "decrease 16 health point from a random minion");
        minions[31] = new Minion("file:1 (32)/breathing.GIF", "file:1 (32)/attack.GIF", "file:1 (32)/run.GIF",
                32, "ashkbus", 400, 7, 14, 8,
                "melee", -1, "On Defend", "not attack from powers with less attack power");
        minions[32] = new Minion("file:1 (33)/breathing.GIF", "file:1 (33)/attack.GIF", "file:1 (33)/run.GIF",
                33, "iraj", 500, 4, 6, 20,
                "ranged", 3, "not", "Nothing");
        minions[33] = new Minion("file:1 (34)/breathing.GIF", "file:1 (34)/attack.GIF", "file:1 (34)/run.GIF",
                34, "quleBozorg", 600, 9, 30, 8,
                "hybrid", 2, "not", "Nothing");
        minions[34] = new Minion("file:1 (35)/breathing.GIF", "file:1 (35)/attack.GIF", "file:1 (35)/run.GIF",
                35, "qule2sar", 550, 4, 10, 4,
                "melee", -1, "On Attack", "not apply positive buffs");
        minions[35] = new Minion("file:1 (36)/breathing.GIF", "file:1 (36)/attack.GIF", "file:1 (36)/run.GIF", 36, "naneSarma", 500, 3, 3, 4,
                "ranged", 5, "On Spawn", "stun minions of 8 cell around");
        minions[36] = new Minion("file:1 (37)/breathing.GIF", "file:1 (37)/attack.GIF", "file:1 (37)/run.GIF",
                37, "fuladZereh", 350, 3, 1, 1,
                "melee", -1, "passive", "have 12 holy buff by continuous");
        minions[37] = new Minion("file:1 (38)/breathing.GIF", "file:1 (38)/attack.GIF", "file:1 (38)/run.GIF",
                38, "siavash", 350, 4, 8, 5,
                "melee", -1, "On Death", "6 attack power when attack to enemy");
        minions[38] = new Minion("file:1 (39)/breathing.GIF", "file:1 (39)/attack.GIF", "file:1 (39)/run.GIF",
                39, "shahqul", 600, 5, 10, 4,
                "melee", -1, "combo", "Combo");
        minions[39] = new Minion("file:1 (40)/breathing.GIF", "file:1 (40)/attack.GIF", "file:1 (40)/run.GIF",
                40, "arjhangDiv", 600, 3, 6, 6,
                "melee", -1, "combo", "Combo");

        for (int i = 0; i < 40; i++) {
            Minion.addMinion(minions[i]);
            Card.addCard(minions[i]);
            //  Shop.addMinion(minions[i]);
        }
    }
}

