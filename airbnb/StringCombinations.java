import java.io.*;
import java.util.*;
/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class StringCombinations {


  /*
  input > output
  a > a, A
  ab > ab, aB, Ab, AB
  abc > abc, abC, aBc, Abc, aBC ...
  ...
  */

    private static final int TO_UPPERCASE = 'A' - 'a';

    private static char toUppercase ( char c){
        return (char) (c + TO_UPPERCASE);
    }

    public static void printCombinations(char[] inputArray){
        int totalCombinations = (int) Math.pow(2, inputArray.length);
        int len = inputArray.length - 1;

        for (int i = 0; i < totalCombinations; ++i){
            for (int j = 0; j < inputArray.length; ++j){
                System.out.print( (i & (1<<(len-j))) != 0 ? toUppercase(inputArray[j]) : inputArray[j]);
            }
            System.out.println();
        }
    }

    public static void printCombinationsRecursive(char[] inputArray, int index){
        boolean lastChar = index == inputArray.length;
        if (lastChar){
          System.out.println(inputArray);
        } else {
          char C = inputArray[index];
          printCombinationsRecursive(inputArray, index + 1);
          inputArray[index] = toUppercase(C);
          printCombinationsRecursive(inputArray, index + 1);
          inputArray[index] = C;
        }
    }

    public static void printCombinationsRecursive(char[] inputArray){
      printCombinationsRecursive(inputArray, 0);
    }

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("a");
        strings.add("ab");
        strings.add("abc");
//        strings.add("abcdefghijklmnopqrstuvwxyz");

        for (String string : strings) {
            System.out.println("Iterative:");
            printCombinations(string.toLowerCase().toCharArray());

            System.out.println("\nRecursive:");
            printCombinationsRecursive(string.toLowerCase().toCharArray());
            System.out.println();
        }
    }
}
