/**
 * Cards Variables and Info.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Card {

//    Card Names
    public static ArrayList<String> cardName() {
        ArrayList<String> cardNames = new ArrayList<>();

        String[] names = {"Vulcan", "Twinkle", "Sadako", "Dragneel",
                            "Shiva", "Annabelle", "Cryto", "Sevi",
                            "Kogre", "Grandium", "Peter", "Corazon",
                            "Ignum", "Ikin", "Debra", "Stylix",
                            "Woody", "Sachi", "Veldora", "Mochi",
                            "Ai", "Uranus", "Lily", "Felix", "Poinus",
                            "Mimi", "Hakkai"};

        Collections.addAll(cardNames, names);

        return cardNames;
    }

    //    Card Types
    public ArrayList<String> cardType() {
        ArrayList<String> cardTypes = new ArrayList<>();

        String[] types = {"Dragon", "Fairy", "Ghost"};
        int counter = 0;

        // For loop using index
        for(int i = 0; i < cardName().size(); i++) {
            if(counter == 0 || counter == 1) {
                cardTypes.add(types[counter]);
                counter++;
            } else {
                cardTypes.add(types[counter]);
                counter = 0;
            }
        }

        return cardTypes;
    }

//    Card Max HP
    public ArrayList<Float> cardMaxHp() {
        ArrayList<Float> cardMaxHps = new ArrayList<>();

        float[] maxHP = {100, 100, 100, 90, 90, 90, 80, 80, 80, 70, 70, 70,
                85, 85, 85, 100, 100, 100, 70, 70, 70, 95, 95, 95, 75, 75, 75};

        for (float i : maxHP) {
            cardMaxHps.add(i);
        }

        return cardMaxHps;
    }

//    Card Current HP
    public ArrayList<Float> cardCurrentHp() {
        ArrayList<Float> cardCurrentHps = new ArrayList<>();

        float[] currentHP = {100, 100, 100, 90, 90, 90, 80, 80, 80, 70, 70, 70,
                85, 85, 85, 100, 100, 100, 70, 70, 70, 95, 95, 95, 75, 75, 75};

        for (float i : currentHP) {
            cardCurrentHps.add(i);
        }

        return cardCurrentHps;
    }

//    Card Attack Power
    public ArrayList<Float> cardAtkPow() {
        ArrayList<Float> cardAtkPows = new ArrayList<>();

        float[] atkPow = {50, 50, 50, 40, 40, 40, 30, 30, 30, 20, 20, 20,
                45, 45, 45, 35, 35, 35, 50, 50, 50, 25, 25, 25, 37, 37, 37};

        for (float i : atkPow) {
            cardAtkPows.add(i);
        }

        return cardAtkPows;
    }

//    To pick a random card
    public int cardRandom() {
        Random random = new Random();
        return random.nextInt(cardName().size());
    }

//    Single Draw
    public int singleDraw(){
        int random = cardRandom();
        while(GameConsole.player1Cards.contains(random) || GameConsole.player2Cards.contains(random) || GameConsole.eliminatedCards.contains(random)) {
            random = 0;
            random = cardRandom();
        }
        return random;
    }
}
