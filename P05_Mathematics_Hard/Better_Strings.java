
// Given a pair of strings s1 and s2 of equal lengths, your task is to find which of the two strings has more distinct subsequences. If both strings have the same number of distinct subsequences, return s1.

// Examples:

// Input: s1 = "gfg", s2 = "ggg"
// Output: "gfg"
// Explanation: "gfg" have 6 distinct subsequences whereas "ggg" have 3 distinct subsequences. 
// Input: s1 = "a", s2 = "b"
// Output: "a"
// Explanation: Both the strings have only 1 distinct subsequence.
// Constraints:
// 1 <= n <= 30

package P05_Mathematics_Hard;

public class Better_Strings {
    public String betterStrings(String s1, String s2) {
        int count1 = countDistinctSubsequences(s1);
        int count2 = countDistinctSubsequences(s2);

        if (count1 >= count2) {
            return s1;
        } else {
            return s2;
        }
    }

    private int countDistinctSubsequences(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // Empty string has one subsequence

        for (int i = 1; i <= n; i++) {
            dp[i] = 2 * dp[i - 1]; // Each character can either be included or not
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(i - 1) == s.charAt(j)) {
                    dp[i] -= dp[j - 1]; // Remove duplicates
                    break;
                }
            }
        }

        return dp[n] - 1; // Exclude the empty subsequence
    }

}

// from either direction, ensuring that the function returns the correct last
// moment before all ants fall out of the plank, even in cases where some ants
// are already at the edges or when there are no ants moving in one direction.
// from either direction, ensuring that the function returns the correct last
// moment before all ants fall out of the plank, even in cases where some ants
// are already at the edges or when there are no ants moving in one direction.
// moving in one direction.
// moving in one direction.
// moving in one direction.
// moving in one direction.
// moving in one direction.
// moving in one direction.
// moving in one direction.
// moving in one direction.
// moving in one direction.
// moving in one direction.
// moving in one direction.
