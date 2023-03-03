package pk;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class game {
    private static final Logger logger = LogManager.getLogger(game.class);

    private static final DecimalFormat df = new DecimalFormat("0.00");
    public static void printRoll(Faces [] roll){
        logger.trace("Roll: ");
        for (int i=0; i<roll.length; i++){ logger.trace(roll[i] + " ");}
        logger.trace("\n");
    }
    public static int rollScore(player player){
        player.rollScore = 0;
        int monkeyCount=0, parrotCount=0, goldCount=0, diamondCount=0, saberCount=0, jungleCount=0;
        for(int i = 0; i< player.roll.length; i++){
            switch (player.roll[i]){
                case MONKEY -> {
                    monkeyCount++;
                }
                case PARROT -> {
                    parrotCount++;
                }
                case SABER -> {
                    saberCount++;
                }
                case DIAMOND -> {
                    diamondCount++;
                    player.rollScore += 100;
                }
                case GOLD -> {
                    goldCount++;
                    player.rollScore += 100;
                }
            }
        }
        switch (player.card){
            case TWOSWORDSEABATTLE:
                if (saberCount>=2){
                    player.rollScore+=300;
                    break;
                }
                else return player.rollScore=0;
            case THREESWORDSEABATTLE:
                if (saberCount>=3){
                    player.rollScore+=500;
                    break;
                }
                else return player.rollScore=0;
            case FOURSWORDSEABATTLE:
                if (saberCount>=4){
                    player.rollScore+=1000;
                    break;
                }
                else return player.rollScore=0;
            case MONKEYBUSINESS:
                jungleCount = monkeyCount + parrotCount;
                monkeyCount = 0;
                parrotCount = 0;
            case NOP:
                break;
        }
        //could replace swtich statements by using ArrayList and collections to count frequency.
        switch (jungleCount){
            case 3: player.rollScore+=100;break;
            case 4: player.rollScore+=200;break;
            case 5: player.rollScore+=500;break;
            case 6: player.rollScore+=1000;break;
            case 7: player.rollScore+=2000;break;
            case 8: player.rollScore+=4000;break;
        }
        switch (monkeyCount){
            case 3: player.rollScore+=100;break;
            case 4: player.rollScore+=200;break;
            case 5: player.rollScore+=500;break;
            case 6: player.rollScore+=1000;break;
            case 7: player.rollScore+=2000;break;
            case 8: player.rollScore+=4000;break;
        }
        switch (parrotCount){
            case 3: player.rollScore+=100;break;
            case 4: player.rollScore+=200;break;
            case 5: player.rollScore+=500;break;
            case 6: player.rollScore+=1000;break;
            case 7: player.rollScore+=2000;break;
            case 8: player.rollScore+=4000;break;
        }
        switch (saberCount){
            case 3: player.rollScore+=100;break;
            case 4: player.rollScore+=200;break;
            case 5: player.rollScore+=500;break;
            case 6: player.rollScore+=1000;break;
            case 7: player.rollScore+=2000;break;
            case 8: player.rollScore+=4000;break;
        }
        switch (diamondCount){
            case 3: player.rollScore+=100;break;
            case 4: player.rollScore+=200;break;
            case 5: player.rollScore+=500;break;
            case 6: player.rollScore+=1000;break;
            case 7: player.rollScore+=2000;break;
            case 8: player.rollScore+=4000;break;
        }
        switch (goldCount){
            case 3: player.rollScore+=100;break;
            case 4: player.rollScore+=200;break;
            case 5: player.rollScore+=500;break;
            case 6: player.rollScore+=1000;break;
            case 7: player.rollScore+=2000;break;
            case 8: player.rollScore+=4000;break;
        }
        return player.rollScore;
    }
    public static void checkWinner(player player1, player player2){
        if (player1.totalScore>player2.totalScore){
            logger.trace("Player 1 wins\n");
            player1.wins++;
        }
        else if (player1.totalScore<player2.totalScore){
            logger.trace("Player 2 wins\n");
            player2.wins++;
        }
        else {
            logger.trace("Tie");
        }
        logger.trace("\n");
    }
    public static void randRoll(player player){
        Dice die = new Dice();
        Random random = new Random();
        int randDice = random.nextInt(player.usableDice);
        if (randDice==0){
            player.usableDice=0;
            return;
        }
        for (int i=0; i<randDice; i++) {
            if (player.roll[i]!=Faces.SKULL)player.roll[i] = die.roll();
        }
        printRoll(pk.player.roll);
    }
    public static void fullRoll(player player){
        Dice die = new Dice();
        player.roll = new Faces[8];
        for (int i=0; i<8; i++) player.roll[i] = die.roll();
        printRoll(pk.player.roll);
    }
    public static void comboSkullCheck(player player){
        player.skulls=0;
        player.usableDice=8;
        for (int i = 0; i< player.roll.length; i++){
            if (player.roll[i] == Faces.SKULL){
                player.skulls++;
                player.usableDice--;
            }
            else if (player.roll[i] == player.maxFace){
                player.usableDice--;
            }
        }
    }
    public static void randSkullCheck(player player){
        player.skulls=0;
        if (player.usableDice==0){ return;}
        else{player.usableDice=8;}
        for (int i = 0; i< player.roll.length; i++){
            if (player.roll[i] == Faces.SKULL){
                player.skulls++;
                player.usableDice--;
            }
        }
    }
    public static void cardSkullCheck(player player){
        player.skulls=0;
        player.usableDice=8;

        if (player.card==cards.MONKEYBUSINESS){
            for (int i = 0; i< player.roll.length; i++){
                if (player.roll[i] == Faces.SKULL){
                    player.skulls++;
                    player.usableDice--;
                }
                else if (player.roll[i]==Faces.PARROT){player.usableDice--;}
                else if (player.roll[i]==Faces.MONKEY){player.usableDice--;}
            }
        }
        else if (player.card== cards.TWOSWORDSEABATTLE|player.card==cards.THREESWORDSEABATTLE|player.card==cards.FOURSWORDSEABATTLE){
            for (int i = 0; i< player.roll.length; i++){
                if (player.roll[i] == Faces.SKULL){
                    player.skulls++;
                    player.usableDice--;
                }
                else if (player.roll[i]==Faces.SABER){player.usableDice--;}
            }
        }
        else {
            comboSkullCheck(player);
        }
    }
    public static void gameEnd(player player1, player player2){
        player1.rollScore = 0;
        player1.usableDice = 8;
        player1.skulls = 0;
        player2.rollScore = 0;
        player2.usableDice = 8;
        player2.skulls = 0;
        player1.totalScore = 0;
        player2.totalScore = 0;
        logger.trace("****Game End****\n");
    }
    public static Faces indexToEnum(int index){
        switch (index){
            case 1: return Faces.MONKEY;
            case 2: return Faces.PARROT;
            case 3: return Faces.SABER;
            case 4: return Faces.GOLD;
            case 5: return Faces.DIAMOND;
        }
        return null;
    }
    public static void comboRoll(player player){
        Dice die = new Dice();
        int[] counter = new int[7];
        int max=0, index=0;

        for (int j=0; j<8; j++){
            if (player.roll[j] == Faces.MONKEY) counter[1]++;
            else if (player.roll[j] == Faces.PARROT) counter[2]++;
            else if (player.roll[j] == Faces.SABER) counter[3]++;
            else if (player.roll[j] == Faces.GOLD) counter[4]++;
            else if (player.roll[j] == Faces.DIAMOND) counter[5]++;
        }
        if (player.card==cards.MONKEYBUSINESS){
            counter[6] = counter[1] + counter[2];
            counter[1] = 0;
            counter[2] = 0;
        }
        for (int k=1; k<counter.length;k++){
            if (counter[k]>max){
                max = counter[k];
                index = k;
            }
        }
        if (max == counter[4]){index = 4;}
        else if (max == counter[5]){index=5;}
        player.max = max;
        player.maxFace = indexToEnum(index);
        for (int i=0; i<8; i++){
            if (player.roll[i]==Faces.SKULL){}
            else if (player.roll[i]==player.maxFace){}
            else{
                player.roll[i] = die.roll();
            }
        }
        printRoll(pk.player.roll);
    }
    public static void cardRoll(player player){
        Dice die = new Dice();

        if (player.card==cards.TWOSWORDSEABATTLE||player.card==cards.THREESWORDSEABATTLE||player.card==cards.FOURSWORDSEABATTLE){
            for (int i=0; i<8; i++){
                if (player.roll[i]==Faces.SKULL){}
                else if (player.roll[i]==Faces.SABER){}
                else{player.roll[i] = die.roll();}
            }
            printRoll(pk.player.roll);
        }
        else if (player.card==cards.MONKEYBUSINESS){
            for (int i=0; i<8; i++){
                if (player.roll[i]==Faces.SKULL){}
                else if (player.roll[i]==Faces.MONKEY){}
                else if (player.roll[i]==Faces.PARROT){}
                else{player.roll[i] = die.roll();}
            }
            printRoll(pk.player.roll);
        }
        else {
            comboRoll(player);
        }
    }
    public static void takeTurn(player player){
        fullRoll(player);
        comboSkullCheck(player);
        while (player.skulls<3 && player.usableDice>=2){
            switch (player.strategy){
                case "random":
                    randRoll(player);
                    randSkullCheck(player);
                    break;
                case "combo":
                    comboRoll(player);
                    comboSkullCheck(player);
                    break;
                case "card":
                    cardRoll(player);
                    cardSkullCheck(player);
                    break;
            }
        }
        player.totalScore+=rollScore(player);
    }
    public static void playGames(player player1, player player2){
        System.out.println("How many games would you like to play?");
        Scanner input = new Scanner(System.in);
        int games = input.nextInt();
        while (games>1000){
            System.out.print("Too many games to simulate!!!\nEnter a number from 1-1000: ");
            games = input.nextInt();
        }
        cardDeck deck = new cardDeck();
        deck.fillDeck();
        deck.shuffleDeck();
        for (int i=0; i<games;){
            player1.card = deck.drawCard();
            logger.trace("Player 1...\tCard: " + player1.card + "\tStrategy: " + player1.strategy);
            takeTurn(player1);

            player2.card = deck.drawCard();
            logger.trace("Player 2...\tCard: " + player2.card + "\tStrategy: " + player2.strategy);
            takeTurn(player2);

            if(player1.totalScore>6000 | player2.totalScore>6000){
                logger.trace("Total Score1: " + player1.totalScore + " Total Score2: " + player2.totalScore);
                checkWinner(player1,player2);
                gameEnd(player1,player2);
                i++;
            }
        }

        System.out.println("\n----------SIMULATION END----------");
        player1.winPercentage = player1.wins*100.0/games;
        player2.winPercentage = player2.wins*100.0/games;
        double tiePercentage = 100-player1.winPercentage-player2.winPercentage;
        System.out.println("\nPlayer1 -->\tWin%: " + df.format(player1.winPercentage) + "\tTotal Wins: " + player1.wins + "\tStrategy: " + player1.strategy + "\nPlayer2 -->\tWin%: " + df.format(player2.winPercentage) + "\tTotal Wins: " + player2.wins + "\tStrategy: " + player2.strategy);
        System.out.println("Overall --> \tTie%: " + df.format(tiePercentage) + "\tTotal Ties: " + (games-player1.wins-player2.wins) + "\tTotal Games: " + games);
    }
}
