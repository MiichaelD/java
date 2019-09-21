/*
  Description:  Prints all the string combinations possible given a input string.
  From:         https://javahungry.blogspot.com/2014/02/algorithm-for-combinations-of-string-java-code-with-example.html
  Programmer:   Michael Duarte
  Date:         Sep 20, 2019.  
*/
public class StringCombinations {
  private StringBuilder output = new StringBuilder();
  private final String inputstring;

  public StringCombinations(final String str){
    inputstring = str;
    System.out.println("The input string  is: " + inputstring);
  }
  
  private void combine(int start) {
    for( int i = start; i < inputstring.length(); ++i ){
      output.append(inputstring.charAt(i));
      System.out.println(output);
      if ((i + 1) < inputstring.length()) {
        combine(i + 1);
      }
      output.setLength(output.length() - 1);
    }
  }

  public static void main (String args[]) {
    StringCombinations combos= new StringCombinations(args.length == 0 ? "wxyz" : args[0]);
    System.out.println("All possible combinations are: ");
    combos.combine(0);
  }
} 


// a
// ab
// abc
// abcd
// abd
// ac
// acd
// ad
// b
// bc
// bcd
// bd
// c
// cd
// d
