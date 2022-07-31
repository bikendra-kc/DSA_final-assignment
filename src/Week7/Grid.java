//Question 7 :

package Week7;

class Grid {

    //creating a helper function 
    static int UniquePathHelper(int i, int j, int m, int n,
                                int[][] A)
    {
        // boundary condition or constraints
        if (i == m || j == n) {
        return 0;
        }
        // if the current cell is already visited
        if (A[i][j] == 1) {
        return 0;
        }
    
        // base case
        if (i == m - 1 && j == n - 1) {
        return 1;
        }
        
        return UniquePathHelper(i + 1, j, m, n, A)
        + UniquePathHelper(i, j + 1, m, n, A);
    }
    
    // function to find the unique paths in a grid
    static int uniquePathsWithObstacles(int[][] A)
    {
        
        int m = A.length, n = A[0].length;
        //calling the helper function
        return UniquePathHelper(0, 0, m, n, A);
    }
    
    // Driver Code
    public static void main(String[] args)
    {
        // initializing the 2d array
        int[][] A
        = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };

        //printing the number of unique paths in the grid
        System.out.print(uniquePathsWithObstacles(A));
    }
}
