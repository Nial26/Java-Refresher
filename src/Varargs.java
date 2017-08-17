public class Varargs{
  static int varArgFunc(int i, int... args){
    int sum = i;
    for (int val : args){
      sum += val;
    }
    return sum;
  }
  
  public static void main(String[] args){
    System.out.println(varArgFunc(1, 2, 3, 4));
  }
}