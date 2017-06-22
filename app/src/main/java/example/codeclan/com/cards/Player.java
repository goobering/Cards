package example.codeclan.com.cards;

import java.util.ArrayList;

/**
 * Created by user on 22/06/2017.
 */

public class Player
{
    private String name;
    private ArrayList<Card> cards;

    public Player(String name)
    {
        this.name = name;
        this.cards = new ArrayList<Card>();
    }

    public String getName()
    {
        return name;
    }

    public ArrayList<Card> getCards()
    {
        return cards;
    }

    public void addCard(Card card)
    {
        cards.add(card);
    }

    public int sumCardValue()
    {
        int sum = 0;
        for(Card c : cards)
        {
            sum += c.getValue();
        }
        return sum;
    }
}
