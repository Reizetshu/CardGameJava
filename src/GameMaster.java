/**
 * Game Master Announcement
 */

public class GameMaster {

//    Declaration of Turn
    public static int turn;

    public final String greetings(){

        return "Game Master: Hello Players!";
    }

    public final String enterP1() {

        return "\t\t\t Player1, enter your name: ";
    }

    public final String enterP2() {

        return "\t\t\t Player2, enter your name: ";
    }

    public final String recognizingPlayers() {
        return "\t\t\t Okay players " + Player.getP1Name + " and " + Player.getP2Name + ", let's play!";
    }

    public final String drawTxt() {

        return "\t\t\t I'll give each of you a 5 cards.\n";
    }

//    Incrementing and Displaying turns
    public static String turnTxt() {
        turn++;
        String turnStr;
        if(turn % 2 == 0) {
            turnStr = "Turn: " + turn + " \nPlayer '" + Player.getP2Name + "' turns.\n";
        } else {
            turnStr = "Turn: " + turn + " \nPlayer '" + Player.getP1Name + "' turns.\n";
        }
        return turnStr;
    }

    public String rules() {
        return """
                Attack Rules:
                Dragon cards are strong against Ghost cards.
                Ghost cards are strong against Fairy cards.
                Dragon cards are strong against Ghost cards.
                Effect: 2x Damage
                
                Defend Rules:
                Dragon cards are resistant against Ghost cards.
                Ghost cards are resistant against Fairy cards.
                Dragon cards are resistant against Ghost cards.
                """;
    }

    public String atkSwap() {
        return "Game Master: Choose 'A' to Attack or 'S' to Swap Cards.";
    }

    public String battleDraw() {
        return "Game Master: Your enemy is drawing a card.";
    }

    public String swapCard() {
        return "Game Master: You swapped card! Enemy's turn!\n";
    }

//    Condition for Winning and Displaying Text
    public String winner() {
        String winnerTxt = "";

        if(Player.token1 == 3) {
            winnerTxt = "Game Master: " + Player.getP1Name + " have 3 tokens, " + Player.getP1Name + " wins!";
        } else if(Player.token2 == 3) {
            winnerTxt = "Game Master: " + Player.getP2Name + " have 3 tokens, " + Player.getP2Name + " wins!";
        }

        return winnerTxt;
    }
}