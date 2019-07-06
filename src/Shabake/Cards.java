package Shabake;

public class Cards {
    public static String[] spellName = new String[20];
    public static int[] spellNumber = new int[20];
    public static String[] minionName = new String[40];
    public static int[] minionNumber = new int[40];
    public static String[] heroName = new String[10];
    public static int[] heroNumber = new int[10];
    public static String[] itemName = new String[20];
    public static int[] itemNumber = new int[20];
    public static void make(){
        spellName[0] = new String("TotalDisarm");
        spellName[1] = new String( "AreaDispel");
        spellName[2] = new String( "EMPOWER");
        spellName[3] = new String( "FIREBALL");
        spellName[4] = new String( "GodStrength");
        spellName[5] = new String( "HellFire");
        spellName[6] = new String( "LightingBolt");
        spellName[7] = new String( "PoisonLake");
        spellName[8] = new String("Maddness");
        spellName[9] = new String( "AllDisarm");
        spellName[10] = new String("AllPoison");
        spellName[11] = new String("Dispel");
        spellName[12] = new String("HealthWithProfit");
        spellName[13] = new String("PowerUp");
        spellName[14] = new String("AllPower");
        spellName[15] = new String("AllAttack");
        spellName[16] = new String("Weakening");
        spellName[17] = new String("Sacrifice");
        spellName[18] = new String("KingsGuard");
        spellName[19] = new String( "Shock");
        for (int i = 0; i < 20; i++){
            spellNumber[i] = 5;
        }
        minionName[0] = new String("kamandareFars");
        minionName[1] = new String( "shamshirzaneFars");
        minionName[2] = new String("neyzedareFars");
        minionName[3] = new String( "asbsavareFars");
        minionName[4] = new String("pahlevaneFars");
        minionName[5] = new String("sepahsalareFars");
        minionName[6] = new String("kamandareTurani");
        minionName[7] = new String("qolabSangdare");
        minionName[8] = new String("neyzedareTurani");
        minionName[9] = new String("jasuseTurani");
        minionName[10] = new String("gorzdareTurani");
        minionName[11] = new String("shahzadeYeTurani");
        minionName[12] = new String("divSiah");
        minionName[13] = new String("quleSangandaz");
        minionName[14] = new String("oqab");
        minionName[15] = new String("DiveGorazsavar");
        minionName[16] = new String("quleTakCheshm");
        minionName[17] = new String("mareSammi");
        minionName[18] = new String("ejdehayeAtashandaz");
        minionName[19] = new String("shireDarandeh");
        minionName[20] = new String("mareQulpeykar");
        minionName[21] = new String("gorgeSefid");
        minionName[22] = new String("palang");
        minionName[23] = new String("gorg");
        minionName[24] = new String("jadugar");
        minionName[25] = new String("jadugareAzam");
        minionName[26] = new String("jen");
        minionName[27] = new String("gorazeVahshi");
        minionName[28] = new String("piran");
        minionName[29] = new String("ranged");
        minionName[30] = new String("bahman");
        minionName[31] = new String("ashkbus");
        minionName[32] = new String("iraj");
        minionName[33] = new String("quleBozorg");
        minionName[34] = new String("qule2sar");
        minionName[35] = new String("naneSarma");
        minionName[36] = new String("fuladZereh");
        minionName[37] = new String("siavash");
        minionName[38] = new String("shahqul");
        minionName[39] = new String("arjhangDiv");
        for (int i = 0; i < 40; i++){
            minionNumber[i] = 5;
        }
        heroName[0] = new String("diveSefid");
        heroName[1] = new String("simorq");
        heroName[2] = new String("ejdehaye7sar");
        heroName[3] = new String("rakhsh");
        heroName[4] = new String("zahak");
        heroName[5] = new String("kaveh");
        heroName[6] = new String("arash");
        heroName[7] = new String("afsane");
        heroName[8] = new String("esfandiar");
        heroName[9] = new String("rostam");
        for (int i = 0; i < 10; i++){
            heroNumber[i] = 5;
        }
        itemName[0] = new String( "tajeDanaii");
        itemName[1] = new String("namusSepar");
        itemName[2] = new String( "kamanDamul");
        itemName[3] = new String( "nushdaru");
        itemName[4] = new String( "tire2shakh");
        itemName[5] = new String( "pareSimorq");
        itemName[6] = new String( "eksir");
        itemName[7] = new String( "majunMana");
        itemName[8] = new String( "majunRoiinTani");
        itemName[9] = new String( "nefrineMarg");
        itemName[10] = new String( "RandomDamage");
        itemName[11] = new String( "TerrorHood");
        itemName[12] = new String( "BladesOfAgility");
        itemName[13] = new String( "KingWisdom");
        itemName[14] = new String( "AssassinationDagger");
        itemName[15] = new String( "PoisonousDagger");
        itemName[16] = new String( "ShockHammer");
        itemName[17] = new String( "SoulEater");
        itemName[18] = new String("qosleTamid");
        itemName[19] = new String( "shamshirChini");

        for (int i = 0; i < 20; i++){
            itemNumber[i] = 5;
        }
    }
    public boolean valid(String name){
        for (int i = 0; i < 40; i++){
            if( name.matches(minionName[i])){
                if (minionNumber[i] > 0)
                minionNumber[i]--;
                return true;
            }
        }
        for (int i = 0; i < 10; i++){
            if (name.matches(heroName[i])){
                if (heroNumber[i] > 0)
                heroNumber[i]--;
                return true;
            }
        }
        for (int i = 0; i < 20; i++){
            if (name.matches(itemName[i])){
                if (itemNumber[i] > 0)
                itemNumber[i]--;
                return true;
            }else if (name.matches(spellName[i])){
                if (spellNumber[i] > 0)
                spellNumber[i]--;
                return true;
            }
        }
        return false;
    }

    public static String[] getSpellName() {
        return spellName;
    }

    public static String[] getMinionName() {
        return minionName;
    }

    public static String[] getHeroName() {
        return heroName;
    }

    public static String[] getItemName() {
        return itemName;
    }

    public static int[] getHeroNumber() {
        return heroNumber;
    }

    public static int[] getMinionNumber() {
        return minionNumber;
    }

    public static int[] getItemNumber() {
        return itemNumber;
    }

    public static int[] getSpellNumber(){
        return spellNumber;
    }
}
