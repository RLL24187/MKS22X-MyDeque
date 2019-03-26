import java.util.Scanner;
public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
      Scanner scan = new Scanner(s);
      MyDeque<Double> m = new MyDeque<Double>(s.length() / 2 + 1); //create a new MyDeque
      @SuppressWarnings("unchecked")
      String temp = "";
      while (scan.hasNext()) {
        temp = scan.next();
        if (isOperator(temp)){
          double val2 = m.removeLast();
          double val1 = m.removeLast();
          m.addLast(operate(temp, val1, val2));
          //Print the token
          System.out.println("Token: " + val1 + " " + val2 + " "+ temp);
        }
        else{
          m.addLast(Double.parseDouble(temp));
        }
      }
      /*
      for (int i = 0; i < s.length(); i++){ //loop through the string
        if (isOperator(s.charAt(i))){
          double val2 = m.removeLast();
          double val1 = m.removeLast();
          m.addLast(operate(s.charAt(i), val1, val2));
          //Print the token
          System.out.println("Token: " + val1 + " " + val2 + " "+ s.charAt(i));
        }
        else{
          m.addLast(s.charAt(i)+0.0); //makes this a double
        }
      }
      */
      return m.getLast();
    }

    /* Notes on deque
    Add: (push / en-queue)
    Get: return but NOT remove the element. (peek)
    Remove: return AND remove the element. (pop / de-queue)
    */
    //helper method to divide up the string
    //public static MyDeque tokenize(String s){

    //}

    //helper method for determining whether or not something is an operator
    public static boolean isOperator(String temp){
      return (temp.equals("+") ||temp.equals("-") || temp.equals("*") || temp.equals("/") || temp.equals("%"));
    }

    public static double operate(String operater, double i1, double i2){
      if (operater.equals("+")){
        return i1 + i2;
      }
      else if (operater.equals("-")){
        return i1 - i2;
      }
      else if (operater.equals("*")){
        return i1 * i2;
      }
      else if (operater.equals("/")){
        return i1 / i2;
      }
      else if (operater.equals("%")){
        return i1 % i2;
      }
      return 0; //dummy
    }

    //testing

    public static void main(String[] args){
      //Test strings
      String[] tests = new String[]{
        "3 2 + ",
        "4 3 - 9 * ",
        "8 9 60 10 1 * / 5 - % + ",
        // 8 9 60 10 / 5 - % +
        // 8 9 6 5 - % +
        // 8 9 1 % +
        // 8 0 +
        // 8
        "5 9 * 10 - 8 + 2 * "
        // 45 10 - 8 + 2 *
        // 35 8 + 2 *
        // 41 2 *
        // 82
      };
      int[] answers = new int[]{
        5,
        9,
        8,
        82
      };
      for (int i = 0; i < tests.length; i++){
        if (eval(tests[i])==answers[i]){
          System.out.println("Test PASSED :D");
        }
        else{
          System.out.println("Test FAILED :(");
        }
        System.out.println(tests[i] + ": "+answers[i] + "\n------------------------------------\n");
      }
    }
}
/*
1. Convert your string into tokens. (A list of values and operators)
1b. Test this by printing each one!
2. Instead of printing each one, decide what to do with them...
*/
