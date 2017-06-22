package example.codeclan.com.cards;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import example.codeclan.com.cards.enums.Suit;
import example.codeclan.com.cards.enums.Value;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 22/06/2017.
 */

public class TestGame
{
    private Game game, spyGame;
    private Deck deck, spyDeck;
    private ArrayList<Player> players, spyPlayers;


    //Deck is deterministic/ordered/unshuffled at creation, so Mockito is unnecessary here.
    //Mockito elements have been added because homework, but jings I would not do this.
    @Before
    public void before()
    {
        deck = new Deck();
        deck.makeDeck();
        // Deck is unshuffled - deck[0-3] is 2, 3, 4, 5 of spades

        game = new Game(4, deck);

        for (int i = 0; i < 4; i++)
        {
            Player newPlayer = new Player(String.format("player%d", i));

            for (int j = 0; j < 2; j++)
            {
                newPlayer.addCard(deck.drawFirstCard());
            }

            game.addPlayer(newPlayer);
        }

        players = game.getPlayers();

        ///
        //Fairly demented Mockito nonsense ahead:
        ///
        spyDeck = Mockito.spy(deck);

        Suit[] suits = Suit.values();
        Value[] values = Value.values();
        ArrayList<Card> testCards = new ArrayList<Card>();

        for (int i = 0; i < 8; i++)
        {
            Card newCard = new Card(suits[i % 4].getSuit(), values[i].getName(), values[i].getValue());
            testCards.add(newCard);
        }

        spyGame = new Game(4, spyDeck);

        for (int i = 0; i < 4; i++)
        {
            Player newSpyPlayer = new Player(String.format("spyPlayer%d", i));
            //Reasonably sneaky:
            Mockito.when(spyDeck.drawFirstCard()).thenReturn(testCards.get(i));
            newSpyPlayer.addCard(spyDeck.drawFirstCard());
            spyGame.addPlayer(newSpyPlayer);
        }

        spyPlayers = spyGame.getPlayers();
    }

    //How the test should look:
    @Test
    public void testGetWinners()
    {
        assertEquals(1, game.getWinners().size());
        assertEquals(true, game.getWinners().get(0) == players.get(3));
    }

    //...and with Mockito:
    @Test
    public void testGetSpyWinners()
    {
        assertEquals(1, spyGame.getWinners().size());
        assertEquals(true, spyGame.getWinners().get(0) == spyPlayers.get(3));
    }
}
