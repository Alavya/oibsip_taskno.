import java.util.*;
import java.lang.Math;
public class guess_the_num
{
    public static void main(String args[])
    {
        System.out.println("WELCOME TO THE GAME - GUESS THE NUMBER!!!");
        System.out.println("ROUND 1:GUESS A NUMBER BETWEEN 1 TO 100(YOU HAVE 3 ATTEMPTS)");
        int end=4;
        for(int i=0;i<=end;i++)
        {
           int min=1;
           int max=100;
           double a=((Math.random())*(max+min-1))+min;
           int num=(int)a;
           System.out.println("GUESS THE NUMBER!!!"+"("+(end-1)+" ATTEMPTS LEFT!!!)"); 
           Scanner sc=new Scanner(System.in);
           int n=sc.nextInt();
           int score=0;
           if(n==num)
           {
               System.out.println("CONGRATULATIONS!!!YOU WON ROUND 1!!!");
               score=score+((end-1)*100);
               System.out.println("SCORE="+score);
               System.out.println("PROCEED TO ROUND 2!!!");
               System.out.println("WELCOME TO ROUND 2!!!GUESS A NUMBER BETWEEN 1 TO 100!!!(YOU HAVE 2 ATTEMPTS)");
               int last=3;
               for(int j=0;j<=last;j++)
               {
                 int minimum=1;
                 int maximum=100;
                 double x=((Math.random())*(maximum+minimum-1))+minimum;
                 int no=(int)x; 
                 System.out.println("GUESS THE NUMBER!!!"+"("+(last-1)+" ATTEMPTS LEFT!!!)"); 
                 Scanner io=new Scanner(System.in);
                 int number=io.nextInt();
                 if(number==no)
                 {
                    System.out.println("CONGRATULATIONS!!!YOU WON ROUND 2!!!");
                    score=score+(last*100);
                    System.out.println("SCORE="+score);
                    System.out.println("PROCEED TO ROUND 3!!!");
                    System.out.println("WELCOME TO ROUND 3!!!GUESS A NUMBER BETWEEN 1 TO 100!!!(YOU ONLY HAVE 1 ATTEMPT)");
                      int mini=1;
                      int maxi=100;
                      double r=((Math.random())*(maxi+mini-1))+mini;
                      int z=(int)r;
                      System.out.println("GUESS THE NUMBER!!!(1 ATTEMPT LEFT!!!)"); 
                      Scanner in=new Scanner(System.in);
                      int y=in.nextInt();
                      if(y==z)
                      {
                         System.out.println("CONGRATULATIONS!!!YOU WON THE GAME!!!WELL PLAYED!!!");
                         score=score+300;
                         System.out.println("SCORE="+score);
                         break;
                      }
                      else if(y>z)
                      {
                         System.out.println("OOPS!!! YOU MISSED IT. THE NUMBER YOU HAVE ENTERED IS HIGHER THAN THE NUMBER TO BE GUESSED");
                      }
                      else if(y<z)
                      {
                         System.out.println("OOPS!!! YOU MISSED IT. THE NUMBER YOU HAVE ENTERED IS LOWER THAN THE NUMBER TO BE GUESSED");
                      }
                      break;
                 }
                 else if(number>no)
                 {
                    System.out.println("OOPS!!! YOU MISSED IT. THE NUMBER YOU HAVE ENTERED IS HIGHER THAN THE NUMBER TO BE GUESSED");
                 }
                 else if(number<no)
                 {
                    System.out.println("OOPS!!! YOU MISSED IT. THE NUMBER YOU HAVE ENTERED IS LOWER THAN THE NUMBER TO BE GUESSED");
                 }
                 last--;
                }
                break;
            }
           else if(n>num)
           {
               System.out.println("OOPS!!! YOU MISSED IT. THE NUMBER YOU HAVE ENTERED IS HIGHER THAN THE NUMBER TO BE GUESSED");
           }
           else if(n<num)
           {
               System.out.println("OOPS!!! YOU MISSED IT. THE NUMBER YOU HAVE ENTERED IS LOWER THAN THE NUMBER TO BE GUESSED");
           }
           System.out.println("FINAL SCORE="+score);
           end--;
        }
    }
}
