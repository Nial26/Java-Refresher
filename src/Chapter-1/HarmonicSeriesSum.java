import java.util.Scanner;

public class HarmonicSeriesSum{
  public static void main(String[] args){
    int n;
    Scanner in = new Scanner(System.in);
    
    System.out.print("Enter n: ");
    n = in.nextInt();
    
    double sum = 0;
    
    for (int i = 1; i <= n; i++){
      sum += 1.0/i;
    }
    
    System.out.println("Sum of Harmonic series upto "+ n + " terms = " + sum);
    
  }
}