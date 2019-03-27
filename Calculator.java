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
          //System.out.println("Token: " + val1 + " " + val2 + " "+ temp);
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
      //TIP: PRINT OUT YOUR TOKENS IN EVAL!!!
      //Test strings
      String[] tests = new String[]{
        "3 2 + ", //addition
        "6 8 - ", //subtraction
        "9 12 * ", //multiplication
        "7 3 / ", //division
        "10 6 % ", //mod
        "4 3 - 9 * ", //two operations
        "5 9 * 10 - 8 + 2 * ", //four operations
        // 45 10 - 8 + 2 *
        // 35 8 + 2 *
        // 43 2 *
        // 86
        "8 9 60 10 1 * / 5 - % + " //all operations
        // 8 9 60 10 / 5 - % +
        // 8 9 6 5 - % +
        // 8 9 1 % +
        // 8 0 +
        // 8
      };
      String[] errorMessages = new String[]{
        //addition
        "Check your token making! This is the most basic test for addition. ",
        //subtraction
        "Check your token making! This is the most basic test for subtraction. Your values may also be out of order in eval! (Subtraction is not commutative)",
        //multiplication
        "Check your token making! This is the most basic test for multiplication.",
        //division
        "Check your token making! This is the most basic test for division. Your values may also be out of order in eval! (Division is not commutative)",
        //mod
        "Check your token making! This is the most basic test for mod. Your values may also be out of order in eval! (Mod is not commutative)",
        //two operations
        "Check the order in which you did your operations. There are two operations in this test:\n1) 4 3 - : 1\n2) 1 9 * : 9",
        //four operations
        "Check the order in which you did your operations. Four operations are in this test:\n1) 5 9 * : 45 \n2) 45 10 - : 35 \n3) 35 8 + : 43 \n4) 43 2 * : 86",
        //all operations
        "Check the order in which you did your operations. All five operations are in this test: \n1) 10 1 * \n2) 60 10 / \n3) 6 5 - \n4) 9 1 % \n5) 8 0 +"
      };
      double[] answers = new double[]{
        5.0, //add
        -2.0, //subtract
        108.0, //multiply
        7.0 / 3 , //divide
        4.0, //mod
        9.0, //two operations: s, m
        86.0, //four operations
        8.0 //all operations
      };
      for (int i = 0; i < tests.length; i++){
        if (eval(tests[i])==answers[i]){
          System.out.println("Test PASSED :D");
        }
        else{
          System.out.println("Test FAILED :(");
          System.out.println(errorMessages[i]);
        }
        System.out.println("\nCorrect answer: "+answers[i]+"\n   Your answer: " + eval(tests[i]) + "\n   Test case "+ i + ": " + tests[i] + "\n------------------------------------\n");
      }
    }
}
/*
1. Convert your string into tokens. (A list of values and operators)
1b. Test this by printing each one!
2. Instead of printing each one, decide what to do with them...
*/
