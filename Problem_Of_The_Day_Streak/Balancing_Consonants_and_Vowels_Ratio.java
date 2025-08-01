// You are given an array of strings arr[], where each arr[i] consists of
// lowercase english alphabets. You need to find the number of balanced strings
// in arr[] which can be formed by concatinating one or more contiguous strings
// of arr[].
// A balanced string contains the equal number of vowels and consonants.

// Examples:

// Input: arr[] = ["aeio", "aa", "bc", "ot", "cdbd"]
// Output: 4
// Explanation: arr[0..4], arr[1..2], arr[1..3], arr[3..3] are the balanced
// substrings with equal consonants and vowels.
// Input: arr[] = ["ab", "be"]
// Output: 3
// Explanation: arr[0..0], arr[0..1], arr[1..1] are the balanced substrings with
// equal consonants and vowels.
// Input: arr[] = ["tz", "gfg", "ae"]
// Output: 0
// Explanation: There is no such balanced substring present in arr[] with equal
// consonants and vowels.
// Constraints:
// 1 ≤ arr.size() ≤ 105
// 1 ≤ arr[i].size() ≤ 105
// Total number of lowercase english characters in arr[] is lesser than 105.

package Problem_Of_The_Day_Streak;

import java.util.HashMap;

public class Balancing_Consonants_and_Vowels_Ratio {
    public int countBalanced(String[] arr) {
        int n = arr.length;
        int[] diff = new int[n + 1]; // prefix difference of vowels - consonants
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        freqMap.put(0, 1); // empty prefix has diff = 0
        int count = 0;

        for (int i = 0; i < n; i++) {
            String s = arr[i];
            int vowels = 0, consonants = 0;
            for (char ch : s.toCharArray()) {
                if (isVowel(ch))
                    vowels++;
                else
                    consonants++;
            }

            // difference of vowels - consonants for this string
            diff[i + 1] = diff[i] + vowels - consonants;

            // if we have seen this diff before, it means there exists a subarray with equal
            // number of vowels and consonants
            count += freqMap.getOrDefault(diff[i + 1], 0);

            // update the frequency map
            freqMap.put(diff[i + 1], freqMap.getOrDefault(diff[i + 1], 0) + 1);
        }

        return count;
    }

    private boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) != -1;
    }
}

// Time Complexity: O(n * m), where n is the number of strings in arr[] and m is
// the
// average length of the strings. We iterate through each string and count the
// number of vowels and consonants.
// Space Complexity: O(n), where n is the number of unique prefix differences.
// We use a HashMap to store the frequency of each prefix difference.
// The function counts the number of balanced substrings in the given array of
// strings by maintaining a prefix difference of the number of vowels and