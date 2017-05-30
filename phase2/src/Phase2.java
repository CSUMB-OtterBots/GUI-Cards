// Nicholas Nelson, David Henderson, Christopher Calderon
// Nathan Mauga, Haley Dimapilis
// CST338-30_SU17: Software Design
// Module 5
// (M5) Write a Java program (GUI Cards) (4 hrs)

import java.awt.*;
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
         int index = 0;
         
         for (int i = 0; i < 4; i++)
         {
            for (int j = 0; j < 14; j++)
            {
               iconCards[j][i] = new ImageIcon("images/" + turnIntIntoCardValue(j) + turnIntIntoCardSuit(i) + fileExt);
               System.out.println(turnIntIntoCardValue(j) + turnIntIntoCardSuit(i) + fileExt);
               index++;
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















