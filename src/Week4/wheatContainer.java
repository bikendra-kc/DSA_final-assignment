//Question 4 :

package Week4;

public class wheatContainer {

    static void forEachVillage(int array[]) {
        // looping through the values of the array
        for (int i = 1; i < array.length; i++) {
            int j = i;
            int a = array[i]; // storing the value of the current element in variable a
            
            // comparing the current element with the previous element
            while ((j > 0) && (array[j - 1] > a)) {
                array[j] = array[j - 1]; // swapping the current element with the previous element
                j--; // decrement j
            }
            array[j] = a;// assigning the current element to the index where the previous element was swapped                       // swapped
        }
    }


    //function to calculate the number of container required
    static void forCurrentVillage(int array[]){
        int a;
        int total_container = 0; // total number of containers required.
        int previous_value = 0; // store previous element of the current element
        int forthisvillage = 0; // store container required for the current village
        
        // looping through the elements of the sorted array
        for (a = 0; a < array.length; a++) {
            // execute if statement if the current element is not same as the previous element
            if (array[a] != previous_value) {
                previous_value = array[a];
                forthisvillage = forthisvillage + 1;
    
                total_container = total_container  + forthisvillage;
            } 
            // execute else statement if the curret element is same as the previous element
            else {
                previous_value = array[a];
                total_container = total_container + forthisvillage;
            }
        }

        //printing the no of containers required
        System.out.println("The minimum number of containers required to distribute wheat to each village is: " + total_container);
    }

    //calling the main function
    public static void main(String[] args) {

        // initializing an array
        int array[] = { 5,2,6 };

        // sorting the array
        forEachVillage(array);

        //calling the function to calculate the no of containers required
        forCurrentVillage(array);
    }
}

