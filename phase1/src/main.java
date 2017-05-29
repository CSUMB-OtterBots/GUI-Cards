// Nicholas Nelson, David Henderson, Christopher Calderon
// Nathan Mauga, Haley Dimapilis
// CST338-30_SU17: Software Design
// Module 5
// (M5) Write a Java program (GUI Cards) (4 hrs)

import javax.swing.*;
import java.awt.*;

public class main
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
