//Question 2 :

package Week2;

class SubsetFinder {

    //declaring a varriable
    int realArrLen;
    //declaring an array
    int[] a;

    //constructor
    SubsetFinder(int realArrLen, int[] a) {
        //initializing the variables
        this.realArrLen = realArrLen;
        // this.a = a;
        int len = 0;
        
        int[] passer = new int[a.length];

        //iterating through the array
        for (int i = 0; i < a.length; i++) {
            //declaraing a variable false
            boolean push = false;
            //iterating through the array
            for (int j = 0; j < a.length; j++) {
                //checking if the element is equal to or greater than the element in the array
                if (i >= j) {
                    if (i == a.length - 1) {
                        //if the index is eaual to the one less than length of the array change push to true
                        push = true;
                        break;
                    }
                    continue;
                }
                //if the two arraya are equal change push to false
                if (a[i] == a[j]) {
                    push = false;
                    break;
                } 
                //if the two arraya are not equal change push to true
                else if (a[i] != a[j]) {
                    push = true;
                }
            }
            //if push is true add the element to the array
            if (push) {
                passer[len] = a[i];//add the element to the array
                push = false;//reset push to false
                len++;//increment the length of the array
            }
        }
        //declaring a variable to store the length of the array
        int[] originalPasser = new int[len];

        //iterating through the array
        for (int i = 0; i < len; i++) {
            originalPasser[i] = passer[i];
            // System.out.println(passer[i]);
        }


        this.a = originalPasser;

    }
    //method to find the number of subsets
    void resultFinder() {

        // Compilation of whole required functions or steps

        int[][] outputValues = findPrime(a);
        int[] primeValues = outputValues[0];
        int primeItterator = outputValues[1][0];
        // System.out.println(primeItterator);
        if (primeItterator == realArrLen) {
            //if the prime iterator is greater than the element of the array print the prime values
            for (int i = 0; i < primeItterator; i++) {
                System.out.println(primeValues[i]);
            }
        } else {
            int[] extra = extrasSearch(primeValues, primeItterator);
            // System.out.println(extra[0]);
            for (int i = 0; i < realArrLen; i++) {
                //if the element is greater or equal to the prime iterator print the extra values
                if (i >= primeItterator) {
                    int num = i - primeItterator;
                    System.out.println(extra[num]);
                } else {
                    //else print the prime values
                    System.out.println(primeValues[i]);
                }
            }
        }
    }
    //method to find the prime numbers
    int[] extrasSearch(int[] primes, int primeItterator) {
        //declaring a variable to store the length of the array
        int[] extras = new int[realArrLen];
        int extrasin = 0;
        boolean skip = false;
        //iterating through the array
        for (int i = 0; i < a.length; i++) {
            //iterating through the array
            for (int ext = 0; ext < primes.length; ext++) {
                //checking if the array element is equal to the prime array element
                if (a[i] == primes[ext]) {
                    skip = true;
                    break;
                }
            }

            if (skip) {
                skip = false;
                continue;
            }

            boolean push = true;
            //iterating through the array
            for (int j = 0; j < primeItterator; j++) {
                //checking if the element of prime array is 1
                if (primes[j] == 1) {
                    continue;
                } else {
                    // System.out.println(a[i]);
                    //floating point number to store the remainder
                    float checkval = (float) a[i] / (float) primes[j];
                    if (checkval == Math.floorDiv(a[i], primes[j])) {
                        push = false;
                    }
                }
            }

            //if push is true add the element to the array
            if (push) {
                extras[extrasin] = a[i];//add the element to the array
                extrasin++;//increment the length of the array
            }

        }

        return extras;

    }

    int[][] findPrime(int[] arr) {
        // Findout Prime numbers among element of given array arr

        int[] ourPrimeElements = new int[realArrLen];
        int primeItterator = 0;

        // iterating through the array
        for (int i = 0; i < arr.length; i++) {
            //checking if the element is 0
            if (arr[i] == 0) {
                continue;
            } 
            //checking if the element is 1
            else if (arr[i] == 1) {
                ourPrimeElements[primeItterator] = 1;
                primeItterator++;

            } 
            //checking if the element is 2
            else if (arr[i] == 2) {
                ourPrimeElements[primeItterator] = 2;
                primeItterator++;
            }
            //checking if the element is 3 
            else if (arr[i] == 3) {
                ourPrimeElements[primeItterator] = 3;
                primeItterator++;
            }
            else {
                boolean prime = true;
                // int element = Math.floorDiv(arr[i], 2);
                int divideLimit = Math.floorDiv(arr[i], 2);
                for (int j = 2; j <= divideLimit; j++) {
                    //float number to store the remainder
                    float check = (float) a[i] / j;
                    if (check == Math.floorDiv(a[i], j)) {
                        prime = false;
                    }
                }
                //if prime is true add the element to the array
                if (prime == true) {
                    ourPrimeElements[primeItterator] = a[i];
                    primeItterator++;//increment the length of the array
                }

            }

        }

        int[][] returner = { ourPrimeElements, { primeItterator } };

        return returner;

    }
    //Driver Code
    public static void main(String[] args) {
        //providing input to the array
        int[] input = { 10, 10, 5, 0, 2, 1, 2, 5 };
        //creating an object of the class
        SubsetFinder sub = new SubsetFinder(3, input);
        //calling the method to find the number of subsets
        sub.resultFinder();
    }
}
