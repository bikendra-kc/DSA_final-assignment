//Question 5 :

package Week5;

public class Target {

    static void findSubset(String targetWord, String[] texts) {

        //declaring a string to store the subset
        String isVisited = "";

        //declaring a variable to store the no of times the word is found in the text
        int value = 0;

        
        for (int i = 0; i < targetWord.length(); i++) {
            for (int j = 0; j < texts.length; j++) {
                for (int k = 0; k < texts[j].length(); k++) {

                    //changing all the letters to lower case
                    if (targetWord.toLowerCase().charAt(i) == texts[j].toLowerCase().charAt(k)
                            && !isVisited.contains(targetWord.charAt(i) + "")) {
                        isVisited += targetWord.charAt(i);

                        if (value <= j + 1) {
                            value++;
                        }

                    }
                }
            }
        }

        //displaying the length of subset required
        System.out.println("The length of subset required to form targeted word is: " + value);
    }


    //calling the main function
    public static void main(String[] args) {

        //target word
        String targetWord = "frog";

        //array containing set of different words in the form of string 
        String[] texts = { "programming", "for", "developers"};

        //calling the subset function
        findSubset(targetWord, texts);
    }
}

// Output: 3