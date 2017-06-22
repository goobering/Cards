package example.codeclan.com.cards;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by user on 22/06/2017.
 */

public class Game
{
    private int numPlayers;
    private ArrayList<Player> players;

    public Game(int numPlayers, Deck deck)
    {
        this.numPlayers = numPlayers;
        players = new ArrayList<Player>();
    }

    public int getNumPlayers()
    {
        return numPlayers;
    }

    public void addPlayer(Player player)
    {
        players.add(player);
    }

    public ArrayList<Player> getPlayers()
    {
        return players;
    }

    public ArrayList<Player> getWinners()
    {
        int highestScore = 0;
        ArrayList<Player> winners = new ArrayList<Player>();

        //Just the clumsiest thing I've done all day. Sort feature not available (?) in this API version.
        for(Player p : players)
        {
            if(p.sumCardValue() > highestScore)
            {
                highestScore = p.sumCardValue();
            }
        }

        for(Player p : players)
        {
            if(p.sumCardValue() >= highestScore)
            {
                winners.add(p);
            }
        }

        return winners;
    }

    public void displayWinners(ArrayList<Player> winners)
    {
        for(Player p : winners)
        {
            System.out.println("Winners are:");
            System.out.println(p.getName());
        }
    }
}
