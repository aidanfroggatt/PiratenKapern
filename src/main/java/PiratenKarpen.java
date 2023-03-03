import pk.*;
import static pk.game.playGames;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PiratenKarpen {
    private static final Logger logger = LogManager.getLogger(PiratenKarpen.class);
    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!\n");
        if (args.length!=2) throw new RuntimeException("\nRequires 2 strategies. 1 for each pk.player.\nUsage: mvn exec:java -Dexec.args=\"random combo\"");
        player player1 = new player();
        player player2 = new player();
        player1.strategy = args[0];
        player2.strategy = args[1];
        if (player1.strategy.equals("combo") | player1.strategy.equals("random") | player1.strategy.equals("card")){}
        else {throw new RuntimeException("\nPlayer1 does not have a valid strategy.\nChoose one of the following:\ncombo\nrandom\ncard");}
        if (player2.strategy.equals("combo") | player2.strategy.equals("random") | player2.strategy.equals("card")){}
        else {throw new RuntimeException("\nPlayer2 does not have a valid strategy.\nChoose one of the following:\ncombo\nrandom\ncard");}

        playGames(player1,player2);
    }
}
