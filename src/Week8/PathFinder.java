//Question 8 :

package Week8;

class PathFinder {

    //declaring an array to store the strings
    String[] input;
    //declaring rows of the matrix
    int rows;
    //declaring columns of the matrix
    int columns;

    //constructor to initialize the variables
    PathFinder(String[] input) {
        this.input = input;
        this.rows = input.length;
        this.columns = input[0].length();
    }
    //function to process the input and find the path
    int processor() {

        //declaring a variable to store the keys number finder function
        int keys = keysNumberFinder();
        //declaring different variables
        int totalTravelled = 0;
        int keysFound = 0;
        boolean run = true;
        int x = 0;
        int travelledRow = 0;
        int adder = 1;
        //declaring a char array to store the path
        char[] foundK = new char[2];

        //iterating through the rows of the matrix
        while (run) {
            //iterating to find the keys
            if (input[travelledRow].charAt(x + adder) != '#') {
                //
                if (input[travelledRow].charAt(x + adder) == '*') {
                    x += adder;//incrementing the x value
                    totalTravelled++;//incrementing the total travelled value
                    continue;
                } 
                else {
                    //adding the character to the path
                    if (input[travelledRow].charAt(x + adder) != input[travelledRow].toUpperCase().charAt(x + adder)) {
                        totalTravelled++;
                        foundK[keysFound] = input[travelledRow].charAt(x + adder);//adding the character to the path
                        x += adder;//incrementing the x value
                        keysFound++;//incrementing the keys found
                        //checking if the keys are found
                        if (keysFound == keys) {
                            run = false;//breaking the loop
                            break;
                        } else {
                            continue;
                        }

                    } 
                    else {
                        boolean yes = false;//declaring a boolean to check if the character is found
                        //checking if the character is already in the path
                        for (int l = 0; l < foundK.length; l++) {
                            if (foundK[l] == input[travelledRow].toLowerCase().charAt(x + adder)) {
                                yes = true;//if yes, then break the loop
                            }
                        }
                        //if the character is not in the path, adding it to the path
                        if (yes) {
                            // keysFound++;
                            totalTravelled++;//adding the count of the character to the total travelled
                            x += adder;//incrementing the x
                            continue;
                        } else {
                            adder *= -1;
                            continue;
                        }

                    }
                }

            }
            //checking if the character matches to the input
            if (input[travelledRow + 1].charAt(x) != '#') {
                if (input[travelledRow + 1].charAt(x) == '*') {

                    travelledRow += 1;//incrementing the travelled row
                    totalTravelled++;//incrementing the total travelled
                    continue;
                } else {
                    if (input[travelledRow + 1].charAt(x) != input[travelledRow + 1].toUpperCase().charAt(x)) {
                        totalTravelled++;//incrementing the total travelled
                        foundK[keysFound] = input[travelledRow + 1].charAt(x);//adding the character to the path
                        travelledRow += 1;//incrementing the travelled row
                        keysFound++;//incrementing the keys found

                        //checking if the keys are found
                        if (keysFound == keys) {
                            run = false;//breaking the loop
                            break;
                        } else {
                            continue;
                        }

                    } else {
                        boolean yes = false;//declaring a boolean variable to check if the character is already in the path
                        //checking if the character is already in the path
                        for (int l = 0; l < foundK.length; l++) {
                            if (foundK[l] == input[travelledRow + 1].toLowerCase().charAt(x)) {

                                yes = true;
                            }
                        }
                        //if the character is not in the path, adding it to the path
                        if (yes) {
                            totalTravelled++;//incrementing the total travelled
                            travelledRow++;//incrementing the travelled row
                            continue;//continuing the loop
                        }
                    }
                }

            }
        }

        return totalTravelled;
    }

    //function to find the number of keys
    int keysNumberFinder() {
        int alphabets = 0;
        //iterating through the rows of the matrix
        for (int i = 0; i < rows; i++) {
            //iterating through the columns of the matrix
            for (int j = 0; j < columns; j++) {
                //checking if the character is a letter
                if (input[i].charAt(j) == '@' || input[i].charAt(j) == '#'
                        || input[i].charAt(j) == '*') {
                    continue;
                } else {
                    alphabets++;//incrementing the alphabets
                }
            }
        }
        //declaring a variable to store the keys
        int keys = alphabets / 2;

        return keys; //returning the number of keys

    }

    //Driver Code
    public static void main(String[] args) {

        //string inputs to be processed
        String[] value = { "@*a*#", "###*#", "b*A*B" };

        //creating an object of the class
        PathFinder pth = new PathFinder(value);
        
        //calling the processor function
        System.out.println(pth.processor());
    }

}
