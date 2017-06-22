package example.codeclan.com.cards;

import java.util.Scanner;

/**
 * Created by user on 22/06/2017.
 */

public class Runner
{
    public static void main(String[] args)
    {
        Deck deck = new Deck();
        deck.makeDeck();
        deck.shuffle();

        Game game = new Game(4, deck);

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < game.getNumPlayers(); i++)
        {
            System.out.println(String.format("Player %d name: ", i + 1));
            Player newPlayer = new Player(sc.nextLine());
            game.addPlayer(newPlayer);
        }

        for (Player p : game.getPlayers())
        {
            p.addCard(deck.drawFirstCard());
            System.out.print(String.format("Player %s", p.getName()));
            for (Card c : p.getCards())
            {
                System.out.println(String.format(" plays %s of %s.", c.getName(), c.getSuit()));
            }
        }

        game.displayWinners(game.getWinners());
    }
}
