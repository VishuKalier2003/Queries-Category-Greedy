/* The minimum absolute difference of an array a is defined as the minimum value of |a[i] - a[j]|, where 0 <= i < 
j < a.length and a[i] != a[j]. If all elements of a are the same, the minimum absolute difference is -1. For example,
the minimum absolute difference of the array [5,2,3,7,2] is |2 - 3| = 1. Note that it is not 0 because a[i] and a[j]
must be different. You are given an integer array nums and the array queries where queries[i] = [li, ri]. For each 
query i, compute the minimum absolute difference of the subarray nums[li...ri] containing the elements of nums 
between the 0-based indices li and ri (inclusive). Return an array ans where ans[i] is the answer to the ith query. 
A subarray is a contiguous sequence of elements in an array.
* Eg 1 :  nums = [1,3,4,8]         queries = [[0,1],[1,2],[2,3],[0,3]]          Output = [ 2, 1, 4, 1]
* Eg 2 :  nums = [4,5,2,2,7,10]    queries = [[2,3],[0,2],[0,5],[3,5]]          Output = [-1, 1, 1, 3]
*/
import java.util.*;
public class Queries
{
      public int[] MinimumDifference(int nums[], int queries[][])
      {
            int[] ans = new int[queries.length];         // Answer array...  //* Array -> O(N)
            int greedy[] = new int[nums.length - 1];     // Greedy Array...  //* Greedy Array -> O(N)
            for(int i = 0; i < nums.length - 1; i++)    //! Greedy Array Evaluation -> O(N)
            {
                  if(Math.abs(nums[i] - nums[i + 1]) == 0)
                        greedy[i] = Integer.MIN_VALUE;     // If two numbers are same, we give value negative...
                  else
                        greedy[i] = Math.abs(nums[i] - nums[i + 1]);    // Otherwise take the absolute...
            }
            for(int i = 0; i < queries.length; i++)     //! Query Iteration -> O(M)
            {
                  int min = Integer.MAX_VALUE;     // Taking the minimum value...  //* Variable -> O(1)
                  for(int j = queries[i][0]; j < queries[i][1]; j++)    //! Greedy Array Comparison -> O(N)
                  {
                        if(greedy[j] == Integer.MIN_VALUE)
                              min = greedy[j];    // If the values are same...
                        if(greedy[j] < min)
                              min = greedy[j];    // if values are not same...
                  }
                  if(min == Integer.MIN_VALUE)
                        ans[i] = -1;     // Give the answer as -1...
                  else
                        ans[i] = min;    // Otherwise return the minimum absolute difference...
            }
            return ans;     // Returning the output array...
      }
      public static void main(String args[])
      {
            Scanner sc = new Scanner(System.in);
            int x;
            System.out.print("Enter length of the Array : ");
            x = sc.nextInt();
            int nums[] = new int[x];
            for(int i = 0; i < nums.length; i++)
            {
                  System.out.print("Enter value : ");
                  nums[i] = sc.nextInt();
            }
            System.out.print("Enter number of queries : ");
            x = sc.nextInt();
            int query[][] = new int[x][2];
            for(int i = 0; i < query.length; i++)
            {
                  System.out.print("Enter start index of "+(i+1)+" query : ");
                  query[i][0] = sc.nextInt();
                  System.out.print("Enter end index of "+(i+1)+" query : ");
                  query[i][1] = sc.nextInt();
            }
            Queries querie = new Queries();     // Object creation...
            int value[] = new int[query.length];
            System.out.println("The Output array is : ");
            value = querie.MinimumDifference(nums, query);      // Function calling...
            for(int i = 0; i < value.length; i++)
                  System.out.print(value[i]+", ");
            sc.close();
      }
}



//! Time Complexity -> O(N x M)
//* Space Complexity -> O(N)

/** //? DEDUCTIONS -
 * ? The absolute differences of the adjacent indices are stored in a greedy array...
 * ? The queries are checked on the basis of the Greedy Array...
 */