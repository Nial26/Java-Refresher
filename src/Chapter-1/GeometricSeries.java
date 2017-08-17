import java.util.Scanner;


class GeometricSeries{
  public static void main(String[] args){
    int a, n;
    double r;
    Scanner in = new Scanner(System.in);
    
    System.out.print("Enter the starting number of the Geometric Series: ");
    a = in.nextInt();
    System.out.print("Enter the constand ratio of the series: ");
    r = in.nextFloat();
    System.out.print("Enter the number of terms of the series to generate: ");
    n = in.nextInt();
    
    int count = 1;
    while (count != n + 1){
      double term = a * Math.pow(r, count - 1);
      System.out.println(count + " : " + term);
      count++;
    }
    
  }
}