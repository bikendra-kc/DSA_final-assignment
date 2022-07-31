//Question 6 :

package Week6;

//importing the java hashmap class
import java.util.HashMap;

class RandomUniqueEqualizer {
    //declaring an array of strings to store the words
    String[] leftSide;
    String rightSide;
    //declaring a hashmap to store the count of each character in the target word
    HashMap<String, String> mapper = new HashMap<String, String>();

    //constructor to initialize the variables
    RandomUniqueEqualizer(String[] leftSide, String rightSide) {

        this.leftSide = leftSide;
        this.rightSide = rightSide;
    }

    //function to find the subset required to form the targeted word
    boolean processor() {

        //declaring a string to store the subset
        String checkval1 = String.join("", leftSide);
        String checkvalFinal = checkval1 + rightSide;
        // System.out.println(checkval);

        //declaring a string to store the subset
        String uniqueCheck = uniqueFinder(checkvalFinal, checkval1.charAt(checkval1.length() - 1));

        int leftSum = leftItterSum();

        String rightSum = "";

        //iterating through the right side of the target word
        for (int i = 0; i < rightSide.length(); i++) {
            rightSum += mapper.get("" + rightSide.charAt(i));
        }

        // System.out.println(rightSum);
        // System.out.println(leftSum);

        //checking if the sum of the left side is equal to the right side
        if (leftSum == Integer.parseInt(rightSum)) {
            return true;
        }

        return false;
    }
    //function to calculate the sum of the left side of the target word
    int leftItterSum() {
        //declaring a variable to store the sum of the left side
        int unitsItter = 0;
        String[] units = new String[leftSide.length];
        int leftTotal = 0;

        //iterating through the left side of the target word
        for (int i = 0; i < leftSide.length; i++) {
            units[unitsItter] = "";
            for (int j = 0; j < leftSide[i].length(); j++) {

                units[unitsItter] += mapper.get("" + leftSide[i].charAt(j));

            }
            leftTotal += Integer.parseInt(units[unitsItter]);//adding the count of each character in the left side to the left total
            unitsItter++;//incrementing the units itter
        }
        return leftTotal;
    }

    //function to find the unique subset required to form the targeted word
    String uniqueFinder(String a, char leftend) {

        int len = 0;
        char[] passer = new char[a.length()];

        //iterating through the target word
        for (int i = 0; i < a.length(); i++) {
            boolean push = false;
            //iterating through the target word
            for (int j = 0; j < a.length(); j++) {
                if (i >= j) {
                    if (i == a.length() - 1) {
                        push = true;
                        break;
                    }
                    continue;
                }

                //checking if the characters match
                if (a.charAt(i) == a.charAt(j)) {
                    push = false;//set the push to false
                    break;
                }
                //checking if the characters doesn't match
                 else if (a.charAt(i) != a.charAt(j)) {
                    push = true;//set the push to true
                }
            }
            //checking if the push is true
            if (push) {
                passer[len] = a.charAt(i);//adding the character to the passer array
                push = false;//setting the push to false
                len++;//incrementing the len
            }
        }

        String combined = "";
        int itter = 0;

        String[] leftRightSum = new String[2];

        //iterating through the passer array
        for (int i = 0; i < len; i++) {
            combined += passer[i];
            mapper.put("" + passer[i], "" + i);

        }
        return combined;
    }

    //Driver Code
    public static void main(String[] args) {
        //Storing the words in an array
        String[] leftInput = {"THIS","IS","TOO"};

        //prinring the output
        System.out.println(new RandomUniqueEqualizer(leftInput, "FUNNY").processor());
    }

}
