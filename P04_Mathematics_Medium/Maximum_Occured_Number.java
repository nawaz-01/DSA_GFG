// You are given two integer arrays L[] and R[], where each L[i] and R[i] define the start and end of a range respectively. The goal is to find the integer that appears in the most number of these ranges. If multiple integers occur in the same maximum number of ranges, then return the smallest integer among them. 

// The solution involves counting the occurrences of each integer across all ranges and then determining which integer has the maximum count.

package P04_Mathematics_Medium;

public class Maximum_Occured_Number {
    public static int maxOccured(int L[], int R[], int n, int maxx) {
        int[] arr = new int[maxx + 2];

        // Increment the start of the range
        for (int i = 0; i < n; i++) {
            arr[L[i]]++;
        }

        // Decrement the end of the range
        for (int i = 0; i < n; i++) {
            arr[R[i] + 1]--;
        }

        // Find the maximum occurred number
        int maxCount = 0;
        int result = -1;
        int currentCount = 0;

        for (int i = 1; i <= maxx; i++) {
            currentCount += arr[i];
            if (currentCount > maxCount) {
                maxCount = currentCount;
                result = i;
            }
        }

        return result;
    }

}
