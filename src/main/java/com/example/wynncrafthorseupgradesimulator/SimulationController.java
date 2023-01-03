package com.example.wynncrafthorseupgradesimulator;

public class SimulationController {

    static int purchasedHorses = 0;
    static int totalPurchasedHorses = 0;

    public static void main(String[] args) {
        // 20% Higher
        // 50% Same
        // 30% Lower
        // Cost: 24 EB
        // Tiers: Brown, Black, Chestnut, White

//        launch();
        for(int i = 0; i < 1000000; i++) {
            getWhiteHorse();
            if(i % 100000 == 0) {
                System.out.println( i/10000 + "%");
            }
        }
        System.out.println("100%");
        System.out.println("Average Horses per White Horse:" + totalPurchasedHorses/1000000);
    }

    public static void getWhiteHorse() {
        int currentTier = 3;

        getChestnutHorse(false);

        while(!(currentTier == 4)) {
            double rng2 = Math.random();
            getChestnutHorse(false);
            if(rng2 > .8) {
                currentTier++;
                //System.out.println("Higher Tier (Chestnut -> White)");
            }
            else if(rng2 < .3) {
                //System.out.println("Lower Tier (Chesnut -> Black)");
                getChestnutHorse(true);
                //System.out.println(purchasedHorses);
            }
            else {
                //System.out.println("Same Tier (Chestnut -> Chestnut)");
            }

            totalPurchasedHorses += purchasedHorses;
            purchasedHorses = 0;

        }
    } // end getWhiteHorse()

    public static void getChestnutHorse(boolean hasBlack) {
        int currentTier = 2;
        if(hasBlack == false) {
            getBlackHorse();
        }

        while(!(currentTier == 3)) {
            double rng1 = Math.random();
            getBlackHorse();
            if(rng1 > .8) {
                currentTier++;
                //System.out.println("Higher Tier (Black -> Chestnut)");
            }
            else if(rng1 < .3) {
                //System.out.println("Lower Tier (Black -> Brown)");
                getBlackHorse();
                purchasedHorses--;
                //System.out.println(purchasedHorses);
            }
            else {
                //System.out.println("Same Tier (Black -> Black)");
            }
        }
    } // end getChestnutHorse()

    public static void getBlackHorse() {
        int currentTier = 1;
        purchasedHorses++; // Initial purchase
        //System.out.println(purchasedHorses);

        while(!(currentTier == 2)) {
            double rng = Math.random();
            purchasedHorses++;
            //System.out.println(purchasedHorses);
            if(rng > .8) {
                currentTier++;
                //System.out.println("Higher Tier (Brown -> Black)");
            }
            else {
                //System.out.println("Same/Lower Tier (Brown -> Brown)");
            }
        }
    } // end getBlackHorse()
}
