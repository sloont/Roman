/*Program: Chapter8ProgrammingExercise2
   Date: 11/03/20
   Author: Colin Abel
   
   This program create an object of class Roman that is initialized with a setter method that takes
   the user input of a roman numeral. Then the method romanToDecimal converts to roman numeral
   to a decimal number if the valid roman numerals are found. If invalid characters are
   encountered, the program terminates. The method printQuestion prompts the user for the 
   number format they would like to see. The print method uses two getters to display the data.   
   Fall 2020
*/

import java.util.*;

public class Roman
{
   private String roman = "";
   private int decimal = 0;
   
   static Scanner console = new Scanner(System.in);
   
   
   public Roman()
   {
      this.setRoman();
   }
   
   public void setRoman()
   {
      System.out.print("Enter a Roman Numeral:  ");
      this.roman = console.next().toUpperCase();
      System.out.println();
   }
   
   public String getRoman()
   {
      return roman;
   }
   
   public boolean validRoman()
   {
      int leng = this.roman.length();   
      char num = ' ';
      char nextNum = ' ';
      int count = 0;
      
      for (int i = 0; i <= leng - 2; i++)
      {
         num = this.roman.charAt(i);
         nextNum = this.roman.charAt(i + 1);
         

               
         if (num == nextNum)
         {
            switch (num)
            {
         	case 'V':
         	case 'L':
         	case 'D':
         		System.out.print("Invalid Input Found");
         		System.exit(0);
         	case 'I':
         	case 'X':
         	case 'C':
         	case 'M': 
                       
               count++;
               
               if (count > 2)
               
                  return false;
         
               else
               
                  continue;
            } 
         }
         
         else
         
            count = 0;
            
         
      
      }//end for
      return true;
   }
   
   public int romanToDecimal()
   {
      int leng = this.roman.length();
      int num = 0;
      int numBefore = 0;
      
      if (this.validRoman())
      {
      
      
         for (int i = leng - 1; i >= 0; i--)
         {
            char single = this.roman.charAt(i);
            
               switch (single)
               {
                  
                  case 'I':
                     numBefore = num;
                     num = 1;
                     break;
                     
                  case 'V':
                     numBefore = num;
                     num = 5;
                     break;
                  
                  case 'X':
                     numBefore = num;
                     num = 10;
                     break;
                     
                  case 'L':
                     numBefore = num;
                     num = 50;
                     break;
                     
                  case 'C':
                     numBefore = num;
                     num = 100;
                     break;
                     
                  case 'D':
                     numBefore = num;
                     num = 500;
                     break;
                     
                  case 'M':
                     numBefore = num;
                     num = 1000;
                     break;
                     
                  default:
                     System.out.print("Invalid Input Found");
                     System.exit(0);
                     
                  
                 }
            
            if (num < numBefore)
               
               decimal -= num;
            
            else
               
               decimal += num;
         }//end for
            
         
      }
         
      else
      {
         System.out.print("Invalid Input Found");
         System.exit(0);
      }
      
      return decimal;

   }
   
   public int getDecimal()
   {
      return decimal;
   }
   
   public void selection(int choice)
   {      
      if (choice == 1)
      {
         System.out.print(this.getRoman() + " is equal to the Decimal number " + this.getDecimal() + "\n\n");
         return;
      }   
      
      if (choice == 2)
      {
         System.out.print(this.getDecimal() + " is equal to the Roman numeral " + this.getRoman() + "\n\n");
         return;
      }   
      
      System.out.print("Invalid input. Please enter (1) for Roman or (2) for Decimal.\n\n");
      this.printQuestion();               //This is so the program doesn't exit on invalid input e.g. pressing 3
   }
   
   public void printQuestion()
   {
      System.out.print("Would you like to see the number as a (1)Roman Numeral or a (2)Decimal Number?  ");
      int choice = console.nextInt();
      System.out.println("\n");
      this.selection(choice);
   }
   
   public static void main(String[] args)
   {
      Roman user = new Roman();
      
      user.romanToDecimal();
      user.printQuestion();
      
   }
}