// Nicholas Nelson, David Henderson, Christopher Calderon
// Nathan Mauga, Haley Dimapilis
// CST338-30_SU17: Software Design
// Module 5
// (M5) Write a Java program (GUI Cards) (4 hrs)

import java.awt.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.*;

public class Phase2
{
   static int NUM_CARDS_PER_HAND = 7;
   static int  NUM_PLAYERS = 2;
   static JLabel[] computerLabels = new JLabel[NUM_CARDS_PER_HAND];
   static JLabel[] humanLabels = new JLabel[NUM_CARDS_PER_HAND];  
   static JLabel[] playedCardLabels  = new JLabel[NUM_PLAYERS]; 
   static JLabel[] playLabelText  = new JLabel[NUM_PLAYERS]; 
   
   public static void main(String[] args)
   {
      int k;
      Icon tempIcon;
      
      // establish main frame in which program will run
      CardTable myCardTable 
         = new CardTable("CardTable", NUM_CARDS_PER_HAND, NUM_PLAYERS);
      myCardTable.setSize(800, 600);
      myCardTable.setLocationRelativeTo(null);
      myCardTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // show everything to the user
      //myCardTable.setVisible(true);

      // CREATE LABELS ----------------------------------------------------
      JLabel lblComputerHand = new JLabel("Computer Hand");
      JLabel lblPlayArea = new JLabel("Play Area");
      JLabel lblHumanHand = new JLabel("Computer Hand");
  
      // ADD LABELS TO PANELS -----------------------------------------
      myCardTable.pnlComputerHand.add(lblComputerHand);
      myCardTable.pnlPlayArea.add(lblPlayArea);
      myCardTable.pnlHumanHand.add(lblHumanHand);
      
      // and two random cards in the play region (simulating a computer/hum ply)
      //code goes here ...

      // show everything to the user
      myCardTable.setVisible(true);
   }
}

class CardTable extends JFrame 
{
   static int MAX_CARDS_PER_HAND = 56;
   static int MAX_PLAYERS = 2;  // for now, we only allow 2 person games
   
   private int numCardsPerHand;
   private int numPlayers;

   public JPanel pnlComputerHand, pnlHumanHand, pnlPlayArea;
   
   CardTable(String title, int numCardsPerHand, int numPlayers)
   {
      setLayout(new GridLayout(3,0));
      
      pnlComputerHand = new JPanel();
      add(pnlComputerHand);
      
      pnlPlayArea = new JPanel();
      add(pnlPlayArea);
      
      pnlHumanHand = new JPanel();
      add(pnlHumanHand);
   }
}

class GUICard
{
   private static Icon[][] iconCards = new ImageIcon[14][4]; // 14 = A thru K + joker
   private static Icon iconBack;
   static boolean iconsLoaded = false;
  
   static String turnIntIntoCardValue(int k) // Helper Method
   {
      String[] cardValues =
      { "A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "X"};
      return cardValues[k];
   }
   
   static String turnIntIntoCardSuit(int j) //Helper Method
   {
      String[] cardSuits = {"C", "D", "H", "S"};
      return cardSuits[j];
   }
   
   static void loadCardIcons()
   {
      //check if array is loaded... if not load it
      if (!iconsLoaded)
      {
         String fileExt = ".gif";
         
         for (int i = 0; i < 4; i++)
         {
            for (int j = 0; j < 14; j++)
            {
               iconCards[j][i] = new ImageIcon("images/" + turnIntIntoCardValue(j) + turnIntIntoCardSuit(i) + fileExt);
               System.out.println(turnIntIntoCardValue(j) + turnIntIntoCardSuit(i) + fileExt);
            }
         }
         iconBack = new ImageIcon("images/BK.gif"); //Back of card (Last)
         iconsLoaded = true;
      }
   }
}





/*
 * 
 * public class main
{
   static final int NUM_CARD_IMAGES = 57; //Every typical card and back of card
   static Icon[] icon = new ImageIcon[NUM_CARD_IMAGES];
   
   static void loadCardIcons()
   {
      String fileExt = ".gif";
      int index = 0;
      
      for (int i = 0; i < 4; i++)
      {
         for (int j = 0; j < 14; j++)
         {
            icon[index] = new ImageIcon("images/" + turnIntIntoCardValue(j) + turnIntIntoCardSuit(i) + fileExt);
            System.out.println(turnIntIntoCardValue(j) + turnIntIntoCardSuit(i) + fileExt);
            index++;
         }
      }
      icon[index] = new ImageIcon("BK.gif"); //Back of card (Last)
   }
   
   static String turnIntIntoCardValue(int k) // Helper Method
   {
      String[] cardValues =
      { "A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "X"};
      return cardValues[k];
   }
   
   static String turnIntIntoCardSuit(int j) //Helper Method
   {
      String[] cardSuits = {"C", "D", "H", "S"};
      return cardSuits[j];
   }

   public static void main(String[] args)
   {
      loadCardIcons();
      
      JFrame frmMyWindow = new JFrame("Card Room");
      frmMyWindow.setSize(1150,650);
      frmMyWindow.setLocationRelativeTo(null);
      frmMyWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 5, 20);
      frmMyWindow.setLayout(layout);
      
      JLabel[] labels = new JLabel[NUM_CARD_IMAGES];
      for (int i = 0; i < NUM_CARD_IMAGES; i++)
      {
         labels[i] = new JLabel(icon[i]);
      }
      
      for (int i = 0; i < NUM_CARD_IMAGES; i++)
      {
         frmMyWindow.add(labels[i]);
      }
      
      frmMyWindow.setVisible(true);
   }
}

 * 
 */


/*
 * This class is a simple representation of a card object. It carries only a
 * suit and a value, as well as an internal error flag.
 */
class Card
{
   public enum Suit
   {
      clubs, diamonds, hearts, spades
   }

   public static char[] values =
   { 'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K' };
   private char value;
   private Suit suit;
   private boolean errorFlag;

   /*
    * The basic constructor for the card class. It initializes the card to the
    * Ace of Spades
    */
   Card()
   {
      value = 'A';
      suit = Suit.spades;
      errorFlag = false;
   }

   /*
    * Card constructor for creating a deep copy. All of the internal types for
    * this class are scalers and do not require any deep copy mechanisms.
    */
   Card(Card copyCard)
   {
      value = copyCard.getValue();
      suit = copyCard.getSuit();
      errorFlag = copyCard.getErrorFlag();
   }

   /*
    * Another Constructor for the Card class which can be called with a suit
    * and a value. This constructor checks for errors and returns a card
    * initiated with "error=True" if either value is bad. The settings for
    * the value and suit are undefined when a bad values are given, so the
    * errorFlag should be checked when you make a new card to ensure that a
    *  valid object was returned.
    */
   Card(char value, Suit suit)
   {
      boolean goodCard;
      goodCard = set(value, suit);
      if (goodCard)
      {
         errorFlag = false;
      } 
      else
      {
         errorFlag = true;
      }
   }

   // Simple Accessor for value
   public char getValue()
   {
      return value;
   }

   // Simple Accessor for suit
   public Suit getSuit()
   {
      return suit;
   }

   // Simple Accessor for errorFlag
   public boolean getErrorFlag()
   {
      return errorFlag;
   }

   /*
    * This Method sets the value and suit for the card. It checks the arguments
    * and returns true when they are correct, false otherwise. It also sets the
    * errorFlag based on the correctness of the arguments. Returns: boolean
    */
   public boolean set(char newValue, Suit newSuit)
   {
      if (isValid(newValue, newSuit))
      {
         value = newValue;
         suit = newSuit;
         errorFlag = false;
      } 
      else
      {
         errorFlag = true;
         suit = newSuit;
      }
      return !errorFlag;
   }

   /*
    * This method generates, then returns a string representation of the card.
    */
   public String toString()
   {
      if (errorFlag == true)
      {
         return "[Invalid]";
      }
      return getValue() + " of " + getSuit() + " ";
   }

   /*
    * This method takes an argument for value and suit and returns true if they
    * are acceptable. Returns: boolean
    */
   private boolean isValid(char value, Suit suit)
   {
      for (int i = 0; i < values.length; i++)
      {
         if (value == values[i])
         {
            return true;
         }
      }
      return false;
   }
}

/*
 * The Hand class is a simple representation of a user's hand of cards. It
 * Enforces some limit of cards, and has simple methods to add and remove cards
 * from the hand.
 */
class Hand
{
   public static int MAX_CARDS = 50;
   private Card[] myCards;
   private int numCards;

   /*
    * Simple Constructor for Hand class. It creates an empty array to hold
    * cards, as well as setting the number of held cards to 0
    */
   Hand()
   {
      numCards = 0;
      myCards = new Card[MAX_CARDS];
   }

   /*
    * This method clears the hand (removes all cards)
    */
   public void resetHand()
   {
      for (int i = 0; i < numCards; i++)
      {
         myCards[i] = null;
      }
      numCards = 0;
   }

   /*
    * This accepts a card as an argument. It then duplicates the card and adds
    * it to the hand.
    */
   public boolean takeCard(Card card)
   {
      if (numCards != MAX_CARDS)
      {
         Card newCard = new Card(card);
         myCards[numCards] = newCard;
         numCards++;
         return true;
      }
      return false;
   }

   /*
    * This method plays the top card from the hand. It removes references to the
    * last Card in the array, and returns that object.
    */
   public Card playCard()
   {
      Card retCard;
      if (numCards > 0)
      {
         retCard = myCards[numCards - 1];
         myCards[numCards - 1] = null;
         numCards--;
      }
      else
      {
         retCard = new Card('Z', Card.Suit.spades); // 'z' ensures bad card
      }
      
      return retCard;
   }

   /*
    * This method creates and returns a string representation of the Hand class
    * object.
    */
   public String toString()
   {
      String hand = "Hand: {";

      for (int i = 0; i < numCards; i++)
      {
         hand += myCards[i].toString() + ", ";
         if ( (i+1) % 6 == 0)
         {
            hand += "\n";
         }
      }

      hand += " } ";

      return hand;
   }

   // Simple Accessor for the numCard variable.
   public int getNumCards()
   {
      return numCards;
   }

   /*
    * This method returns a card from a specified index in the array. It first
    * checks if given index points to a valid location. If it does not, it
    * creates a card with the errorFlag set and returns that.
    */
   public Card inspectCard(int k)
   {
      if (numCards == 0 || k < 0 || k > numCards)
      {
         // Creates illegal card
         return new Card('X', Card.Suit.spades);
      } 
      else
      {
         return myCards[k];
      }
   }
}

/*
 * This class represents a deck of cards, or a shoe of cards. It has simple
 * methods for initialization, shuffling, dealing etc.
 */
class Deck
{
   public final int DECK_SIZE = 52; // the size of a deck in this game
   public final int MAX_CARDS = 6 * DECK_SIZE; // allow a maximum of six packs
   // (6 * 52 cards)
   private static Card[] masterPack;
   private Card[] cards;
   private int topCard;
   private int numPacks;

   /*
    * Default constructor for Deck class. Returns a new deck with only one set
    * of cards.
    */
   Deck()
   {
      numPacks = 1;
      allocateMasterPack();

      cards = new Card[numPacks * DECK_SIZE];
      for (int i = 0; i < DECK_SIZE; i++)
      {
         cards[i] = new Card(masterPack[i]); // duplicate the card into the
         // array.
      }
      topCard = cards.length - 1;
   }

   /*
    * Deck constructor that lets you make a shoe with an arbitrary (bit limited)
    * number of decks.
    */
   Deck(int newNumPacks)
   {
      int numCards = newNumPacks * DECK_SIZE;
      allocateMasterPack();

      if (numCards <= MAX_CARDS && numCards > 0)
      {
         numPacks = newNumPacks;
         cards = new Card[numCards];
         for (int k = 0; k < numCards; k++)
         {
            Card newCard = new Card(masterPack[k % DECK_SIZE]);
            cards[k] = newCard;
         }
         topCard = cards.length - 1;
      }

      else
      {
         System.out.println("Error: Invalid number of decks");
      }
   }

   /*
    * This Method re-initializes the deck. If the deck hasn't been used it
    * returns without touching the deck.
    */
   public void init(int numPacks)
   {
      if (topCard + 1 == numPacks * DECK_SIZE)
      {
         return;
      }

      // if we pass the return then the deck was at least partially used
      for (int x = 0; x < cards.length; ++x)
      {
         cards[x] = null;
         cards[x] = new Card(masterPack[x % DECK_SIZE]);
      }
      topCard = cards.length - 1;
   }

   /*
    * This method shuffles the decks.
    */
   public void shuffle()
   {
      int index;
      Card temp;
      Random random = new Random();
      for (int i = cards.length - 1; i > 0; i--)
      {
         index = random.nextInt(i + 1);
         temp = cards[index];
         cards[index] = cards[i];
         cards[i] = temp;
      }
   }

   // Simple accessor for topCard
   public int topCardAccessor()
   {
      return topCard;
   }

   /*
    * This method takes the top card from the deck and "deals it" thus removing
    * it from the deck.
    */
   public Card dealCard()
   {
      Card retCard;
      if (topCard >= 0)
      {
         retCard = cards[topCard];
         topCard--;
      } 
      else
      {
         retCard = new Card('z', Card.Suit.clubs); // 'z' forces a card with
         // errorFlag set.
      }
      return retCard;
   }

   /*
    * This function returns the card at a specific index. It returns a bad card
    * if an out-of-index argument is made.
    */
   public Card inspectCard(int index)
   {
      if (!(index >= 0 && index < topCard))
      {
         Card badCard = new Card();
         badCard.set('z', Card.Suit.clubs); // this will receive an error flag
         // because of "z"
         return badCard;
      } 
      else
      {
         return cards[index];
      }
   }

   /*
    * This Method creates a masterPack of cards for later use if and only if it
    * wasn't created already.
    */
   private static void allocateMasterPack()
   {
      int index = 0;

      if (masterPack == null)
      {
         masterPack = new Card[52];
         for (int i = 0; i < Card.Suit.values().length; i++)
         {
            for (int j = 0; j < Card.values.length; j++)
            {
               masterPack[index] = new Card(Card.values[j], Card.Suit.values()[i]);
               index++;
            }
         }
      }
   }
}








