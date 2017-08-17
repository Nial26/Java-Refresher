import java.util.Scanner;

public class Factorial{

  static int factorial(int n){
	  if (n == 0 || n == 1){
		  return 1;
	  }
	  else{
		  return n * factorial(n-1);
	  }
  }

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    System.out.print("Enter N: ");
    int n = in.nextInt();
    System.out.println("Factorial of " + n + " is: " + factorial(n));
    in.close();
  }
}