
// We have a wooden plank of length n units. Some ants are walking on the plank, each ant moves with a speed of 1 unit per second, with some moving left and others right.
// When two ants moving in two different directions meet at some point, they change their directions and continue moving again. Assume changing directions does not take any additional time. When an ant reaches one end of the plank at a time t, it falls out of the plank immediately.

// Given an integer n and two integer arrays left[] and right[], the positions of the ants moving to the left and the right, return the time when the last ant(s) fall out of the plank.

// Examples :

// Input: n = 4, left[] = [2], right[] = [0, 1, 3]
// Output: 4

// Explanation: As seen in the above image, the last ant falls off the plank at t = 4.
// Input:  n = 4, left[] = [], right[] = [0, 1, 2, 3, 4]
// Output: 4

// Explanation: All ants are going to the right, the ant at index 0 needs 4 seconds to fall.
// Input: n = 3, left[] = [0], right[] = [3]
// Output: 0
// Explanation: The ants will fall off the plank as they are already on the end of the plank.
// Constraints:
// 1 ≤ n ≤ 105
// 0 ≤ left.length, right.length ≤ n + 1
// 0 ≤ left[i], right[i] ≤ n
// 1 ≤ left.length + right.length ≤ n + 1
// All values of left and right are unique, and each value can appear only in one of the two arrays.

package Problem_Of_The_Day_Streak;

public class Last_Moment_Before_All_Ants_Fall_Out {
    public int getLastMoment(int n, int[] left, int[] right) {
        int maxTime = 0;

        // Calculate the time for ants moving left
        for (int pos : left) {
            maxTime = Math.max(maxTime, pos);
        }

        // Calculate the time for ants moving right
        for (int pos : right) {
            maxTime = Math.max(maxTime, n - pos);
        }

        return maxTime;
    }

}

// Time Complexity: O(n), where n is the maximum of the lengths of the left and
// right arrays.
// Space Complexity: O(1), as we are using a constant amount of space for
// variables.
// The function iterates through both arrays to find the maximum time it takes
// for any ant to fall off the plank, either from the left or the right end.
// The maximum time is determined by the furthest ant in either direction, which
// is either at the left end or the right end of the plank.
// This solution efficiently computes the last moment before all ants fall out
// of the plank by considering the positions of ants moving in both directions.
// The function returns the maximum time calculated, which represents the last
// moment before all ants fall out
// of the plank.
// This solution is optimal and works within the constraints provided, ensuring
// that it handles the maximum possible input sizes efficiently.
// The function is designed to handle edge cases, such as when there are no ants
// moving in one direction or when all ants are already at the ends of the
// plank.
// The implementation is straightforward and leverages the properties of the
// problem to arrive at the solution in
// a single pass through the input arrays, making it both time-efficient and
// space-efficient.
// The solution is robust and can handle various scenarios, including cases
// where all ants are moving in one direction or when there are no ants at all.
// The function is easy to understand and maintain, making it suitable for
// inclusion in larger codebases or for use in competitive programming contexts.
// The implementation is clean and adheres to best practices, ensuring
// readability and maintainability.
// The solution is designed to be efficient and effective, providing a clear and
// concise answer to the problem of determining the last moment before all ants
// fall out of the plank.
