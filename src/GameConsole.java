/**
 * This is the main program initialize.
 * This is where almost all the Logic and Battles Calculate.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;


public class GameConsole {

//    Initializing Scanner
    private static final Scanner sc = new Scanner(System.in);

//    Importing Card and GameMaster class file
    private static final Card c = new Card();
    private static final GameMaster gm = new GameMaster();

//    Global Variables

    public static ArrayList<Integer> player1Cards = new ArrayList<>();

    public static ArrayList<Integer> player2Cards = new ArrayList<>();

    public static ArrayList<Integer> eliminatedCards = new ArrayList<>();

//    Active Card Declarations
    public static String aCName1;
    public static String aCName2;
    public static String aCType1;
    public static String aCType2;
    public static float aCCHp1;
    public static float aCCHp2;
    public static float aCMHp1;
    public static float aCMHp2;
    public static float aAtk1;
    public static float aAtk2;

//    Condition for Strong and Resistant type (TypeBeats).
    public static float typeBeats1() {
        float typeBeatCH;
        if((Objects.equals(aCType1, "Dragon" ) && Objects.equals(aCType2, "Ghost")) ||
                (Objects.equals(aCType1, "Ghost" ) && Objects.equals(aCType2, "Fairy")) ||
                (Objects.equals(aCType1, "Fairy" ) && Objects.equals(aCType2, "Dragon"))){
            typeBeatCH = aCCHp2 - (aAtk1 * 2);
            System.out.println(aCName1 + " damaged " + aCName2 + " for " + (aAtk1 * 2) + ".\n");
        } else if((Objects.equals(aCType1, "Ghost" ) && Objects.equals(aCType2, "Dragon")) ||
                (Objects.equals(aCType1, "Fairy" ) && Objects.equals(aCType2, "Ghost")) ||
                (Objects.equals(aCType1, "Dragon" ) && Objects.equals(aCType2, "Fairy"))) {
            typeBeatCH = aCCHp2 - (aAtk1 / 2);
            System.out.println(aCName1 + " damaged " + aCName2 + " for " + (aAtk1 / 2) + ".\n");
        } else{
            typeBeatCH = aCCHp2 - aAtk1;
            System.out.println(aCName1 + " damaged " + aCName2 + " for " + aAtk1 + ".\n");
        }
        return typeBeatCH;
    }

    public static float typeBeats2() {
        float typeBeatCH;
        if((Objects.equals(aCType2, "Dragon" ) && Objects.equals(aCType1, "Ghost")) ||
                (Objects.equals(aCType2, "Ghost" ) && Objects.equals(aCType1, "Fairy")) ||
                (Objects.equals(aCType2, "Fairy" ) && Objects.equals(aCType1, "Dragon"))){
            typeBeatCH = aCCHp1 - (aAtk2 * 2);
            System.out.println(aCName2 + " damaged " + aCName1 + " for " + (aAtk2 * 2) + ".\n");
        } else if((Objects.equals(aCType2, "Ghost" ) && Objects.equals(aCType1, "Dragon")) ||
                (Objects.equals(aCType2, "Fairy" ) && Objects.equals(aCType1, "Ghost")) ||
                (Objects.equals(aCType2, "Dragon" ) && Objects.equals(aCType1, "Fairy"))) {
            typeBeatCH = aCCHp1 - (aAtk2 / 2);
            System.out.println(aCName2 + " damaged " + aCName1 + " for " + (aAtk2 / 2) + ".\n");
        } else{
            typeBeatCH = aCCHp1 - aAtk2;
            System.out.println(aCName2 + " damaged " + aCName1 + " for " + aAtk2 + ".\n");
        }
        return typeBeatCH;
    }

//    Active Cards Info
    private static String activeCard1() {
        return "Name: " + aCName1 +
                "\nType: " + aCType1 +
                "\nHP: " + aCCHp1 + "/" + aCMHp1 +
                "\nAtk: " + aAtk1 + "\n";
    }

    private static String activeCard2() {
        return "Name: " + aCName2 +
                "\nType: " + aCType2 +
                "\nHP: " + aCCHp2 + "/" + aCMHp2 +
                "\nAtk: " + aAtk2 + "\n";
    }

    private static int swapCalc1() {
        int strongest = 0;
        float powerRating = 0;
        for(int i = 1; i < player1Cards.size() ; i++) {
            int cardNum = player1Cards.get(i);
            float newPowerRating = c.cardCurrentHp().get(cardNum) + c.cardAtkPow().get(cardNum);
            if(powerRating < newPowerRating) {
                powerRating = newPowerRating;
                strongest = i;
            }
        }
        return strongest;
    }

    private static int swapCalc2() {
        int strongest = 0;
        float powerRating = 0;
        for(int i = 1; i < player1Cards.size() ; i++) {
            int cardNum = player1Cards.get(i);
            float newPowerRating = c.cardCurrentHp().get(cardNum) + c.cardAtkPow().get(cardNum);
            if(powerRating < newPowerRating) {
                powerRating = newPowerRating;
                strongest = i;
            }
        }
        return strongest;
    }

//    Program Start Here

    public static void main(String[] args) {
//        Greetings
        System.out.println(gm.greetings());
//        Entering names for players.
        System.out.print(gm.enterP1());
        String setP1Name = sc.next();
        System.out.print(gm.enterP2());
        String setP2Name = sc.next();
//        Getting value of setName input
        String newP1 = String.valueOf(setP1Name);
        String newP2 = String.valueOf(setP2Name);
        Player.getP1Name = newP1;
        Player.getP2Name = newP2;
        System.out.println(gm.recognizingPlayers());
        System.out.println(gm.drawTxt());
//        Rules/Mechanics
        System.out.println(gm.rules());


//        Distributing Card Alternately
        for(int i = 0; i < 10 ; i++) {
            if(i % 2 == 0) {
                player1Cards.add(Player.playerCard().get(i));
            } else {
                player2Cards.add(Player.playerCard().get(i));
            }
        }
        aCCHp1 = c.cardCurrentHp().get(player1Cards.getFirst());
        aCCHp2 = c.cardCurrentHp().get(player2Cards.getFirst());

//        Running Battle
        while(Player.token1 != 3 && Player.token2 != 3) {
//            Initialization of Active Card
            aCName1 = String.valueOf(Card.cardName().get(player1Cards.getFirst()));
            aCName2 = String.valueOf(Card.cardName().get(player2Cards.getFirst()));
            aCType1 = c.cardType().get(player1Cards.getFirst());
            aCType2 = c.cardType().get(player2Cards.getFirst());
            aCMHp1 = c.cardMaxHp().get(player1Cards.getFirst());
            aCMHp2 = c.cardMaxHp().get(player2Cards.getFirst());
            aAtk1 = c.cardAtkPow().get(player1Cards.getFirst());
            aAtk2 = c.cardAtkPow().get(player2Cards.getFirst());
            Player.currentCard1 = player1Cards.size();
            Player.currentCard2 = player2Cards.size();
            System.out.println(GameMaster.turnTxt());
            System.out.println();
            System.out.println(Player.player1Info());
            System.out.println(player1Cards);
            System.out.println(activeCard1());
            System.out.println(Player.player2Info());
            System.out.println(player2Cards);
            System.out.println(activeCard2());
//            Choosing Attack or Swap
            boolean as = true;
            while (as) {
                System.out.println(gm.atkSwap());
                String atkSwp = sc.next().toUpperCase().trim();
                switch (atkSwp) {
//                Attack
                    case "A" -> {
                        System.out.println("You choose to attack.\n");
//                    Attack Turn of Player 2
                        if (GameMaster.turn % 2 == 0) {
                            aCCHp1 = Float.valueOf(typeBeats2());
                            if (aCCHp1 <= 0) {
                                System.out.println(aCName1 + " is eliminated!\n");
                                int elimi = player1Cards.removeFirst();
                                eliminatedCards.add(elimi);
                                player1Cards.add(c.singleDraw());
                                Player.token2++;
                                if (Player.token2 != 3){
                                    System.out.println(gm.battleDraw());
                                }
                                System.out.println(Player.getP2Name + " acquired a 1 token for eliminating " + aCName1 + ".\n");
                            }
                            System.out.println(activeCard1());
                            if (aCCHp1 <= 0) {
                                aCCHp1 = c.cardCurrentHp().get(player1Cards.getFirst());
                            }
                            as = false;

                        } else {
//                        Attack Turn of Player 1
                            aCCHp2 = Float.valueOf(typeBeats1());
                            if (aCCHp2 <= 0) {
                                System.out.println(aCName2 + " is eliminated!\n");
                                int elimi = player2Cards.removeFirst();
                                eliminatedCards.add(elimi);
                                player2Cards.add(c.singleDraw());
                                Player.token1++;
                                if (Player.token1 != 3){
                                    System.out.println(gm.battleDraw());
                                }
                                System.out.println(Player.getP1Name + " acquired a 1 token for eliminating " + aCName2 + ".\n");

                            }
                            System.out.println(activeCard2());
                            if (aCCHp2 <= 0) {
                                aCCHp2 = c.cardCurrentHp().get(player2Cards.getFirst());
                            }
                            as = false;
                        }
                    }
//                Swap
                    case "S" -> {
                        System.out.println("You choose to swap.\n");
                        if (GameMaster.turn % 2 == 0){
                            Collections.swap(player2Cards,0, swapCalc2());
                            System.out.println(gm.swapCard());
                            aCCHp2 = c.cardCurrentHp().get(player2Cards.getFirst());
                        } else {
                            Collections.swap(player1Cards,0, swapCalc1());
                            System.out.println(gm.swapCard());
                            aCCHp2 = c.cardCurrentHp().get(player1Cards.getFirst());
                        }
                        as = false;
                    }
                    default -> as = true;
                };
            }
        }
        System.out.println(Player.player1Info());
        System.out.println();
        System.out.println(Player.player2Info());
        System.out.println();
        System.out.println(gm.winner());
    }
}