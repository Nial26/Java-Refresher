import java.util.Scanner;
import java.io.Console;

public class Scores{
  
  static int getSum(int[] scores){
    int sum = 0;
    for(int i = 0; i < scores.length; i++){
      sum += scores[i];
    }
    return sum;
  }
  
  static float getAverage(int[] scores){
    int sum = 0;
    for (int score: scores){
      sum += score;
    }
    return (float)sum/scores.length;
  }
  
  public static void main(String[] args){
    int n;
    int[] scores;
    Console con = System.console();
    
    n = Integer.parseInt(con.readLine("Enter the number of scores to enter: "));
    
    Scanner in = new Scanner(con.reader());
    
    scores = new int[n];
    
    System.out.println("Enter the Scores: ");
    
    for (int i = 0; i < n; i++){
      scores[i] = in.nextInt();
    }
    
    System.out.println("The sum of the scores is : " + getSum(scores));
    System.out.println("Ther average of the scores is : " + getAverage(scores));
  }
}