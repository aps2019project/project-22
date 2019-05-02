package Model;

public class MakeMinions {
    public void make() {
        Minion[] minions = new Minion[40];
        minions[0] = new Minion(1, 300, 2, 6, 4, "ranged", 7, "not");
        minions[1] = new Minion(2, 400, 2, 6, 4, "melee", -1, "On Attack");
        minions[2] = new Minion(3, 500, 1, 5, 3, "hibrid", 3, "not");
        minions[3] = new Minion(4, 200, 4, 10, 6, "melee", -1, "not");
        minions[4] = new Minion(5, 600, 9, 24, 6, "melee", -1, "On Attack");
        minions[5] = new Minion(6, 800, 7, 12, 4, "melee", -1, "combo");
        minions[6] = new Minion(7, 500, 1, 3, 4, "ranged", 5, "not");
        minions[7] = new Minion(8, 600, 1, 4, 2, "ranged", 7, "not");
        minions[8] = new Minion(9, 600, 1, 4, 4, "hybrid", 3, "not");
        minions[9] = new Minion(10, 700, 4, 6, 6, "melee", -1, "On Attack");
        minions[10] = new Minion(11, 450, 2, 3, 10, "melee", -1, "not");
        minions[11] = new Minion(12, 800, 6, 6, 10, "melee", -1, "combo");
        minions[12] = new Minion(13, 300, 9, 14, 10, "hybrid", 7, "not");
        minions[13] = new Minion(14, 300, 9, 12, 12, "ranged", 7, "not");
        minions[14] = new Minion(15, 200, 2, 0, 2, "ranged", 3, "passive");
        minions[15] = new Minion(16, 300, 6, 16, 8, "melee", -1, "not");
        minions[16] = new Minion(17, 500, 7, 12, 11, "hybrid", 3, "On Death");
        minions[17] = new Minion(18, 300, 4, 5, 6, "ranged", 4, "On Attack");
        minions[18] = new Minion(19, 250, 5, 9, 5, "ranged", 4, "not");
        minions[19] = new Minion(20, 600, 2, 1, 8, "melee", -1, "On Attack");
        minions[20] = new Minion(21, 500, 8, 14, 7, "ranged", 5, "On Spawn");
        minions[21] = new Minion(22, 400, 5, 8, 2, "melee", -1, "On Attack");
        minions[22] = new Minion(23, 400, 4, 6, 2, "melee", -1, "On Attack");
        minions[23] = new Minion(24, 400, 3, 6, 1, "melee", -1, "On Attak");
        minions[24] = new Minion(25, 550, 4, 5, 4, "ranged", 3, "passive");
        minions[25] = new Minion(26, 550, 6, 6, 6, "ranged", 5, "passive");
        minions[26] = new Minion(27, 500, 5, 10, 4, "ranged", 4, "On Turn");
        minions[27] = new Minion(28, 500, 6, 10, 14, "melee", -1, "On Defend");
        minions[28] = new Minion(29, 400, 8, 20, 12, "melee", -1, "On Defend");
        minions[29] = new Minion(30, 450, 4, 5, 7, "ranged", 5, "On Defend");
        minions[30] = new Minion(31, 450, 8, 16, 9, "melee", -1, "On Spawn");
        minions[31] = new Minion(32, 400, 7, 14, 8, "melee", -1, "On Defend");
        minions[32] = new Minion(33, 500, 4, 6, 20, "ranged", 3, "not");
        minions[33] = new Minion(34, 600, 9, 30, 8, "hybrid", 2, "not");
        minions[34] = new Minion(35, 550, 4, 10, 4, "melee", -1, "On Attack");
        minions[35] = new Minion(36, 500, 3, 3, 4, "ranged", 5, "On Spawn");
        minions[36] = new Minion(37, 350, 3, 1, 1, "melee", -1, "passive");
        minions[37] = new Minion(38, 350, 4, 8, 5, "melee", -1, "On Death");
        minions[38] = new Minion(39, 600, 5, 10, 4, "melee", -1, "combo");
        minions[39] = new Minion(40, 600, 3, 6, 6, "melee", -1, "combo");
        for (int i = 0; i < 40; i++) {
            Minion.addMinion(minions[i]);

        }

    }
}

