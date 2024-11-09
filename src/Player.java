/**
 * Players Variables and Info.
 */

import java.util.ArrayList;

public class Player {

//    Importing Card and GameMaster class file
    private static final Card c = new Card();

//    Players Variable
    public static String getP1Name;
    public static String getP2Name;
    public static int currentCard1;
    public static int currentCard2;
    public static final int maxCard = 5;

    public static int token1;

    public static int token2;

//    Displaying Players info
    public static String player1Info(){
        String indicator;
        if(currentCard1 == maxCard) {
            indicator = "Yes";
        } else {
            indicator ="No";
        }

        return "Player 1: " + getP1Name +
                "\nCards: " + currentCard1 + "/" + maxCard +
                "\nComplete Card: " + indicator +
                "\nToken: " + token1;
    }

    public static String player2Info(){
        String indicator;
        if(currentCard2 == maxCard) {
            indicator = "Yes";
        } else {
            indicator ="No";
        }

        return "Player 2: " + getP2Name +
                "\nCards: " + currentCard2 + "/" + maxCard +
                "\nComplete Card: " + indicator +
                "\nToken: " + token2;
    }

//    Giving Card for player
    public static ArrayList<Integer> playerCard() {

        ArrayList<Integer> playerCards = new ArrayList<>();

        for(int i = 0; i < 10 ; i++) {
            int random = c.cardRandom();
            while(playerCards.contains(random) || GameConsole.player1Cards.contains(random) || GameConsole.player2Cards.contains(random)) {
                random = 0;
                random = c.cardRandom();
            }
            playerCards.add(random);
        }

        return playerCards;
    }
}
