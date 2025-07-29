package Problem_Of_The_Day_Streak;

import java.util.*;

public class ASCII_Range_Sum {

    class Solution {
        public ArrayList<Integer> asciirange(String s) {
            ArrayList<Integer> result = new ArrayList<>();
            int[] firstIndex = new int[26];
            int[] lastIndex = new int[26];
            Arrays.fill(firstIndex, -1);
            Arrays.fill(lastIndex, -1);

            // Track first and last occurrence for each character
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                int idx = ch - 'a';
                if (firstIndex[idx] == -1) {
                    firstIndex[idx] = i;
                }
                lastIndex[idx] = i;
            }

            // For each character that occurs more than once, calculate ASCII sum
            for (int i = 0; i < 26; i++) {
                if (firstIndex[i] != -1 && lastIndex[i] != firstIndex[i]) {
                    int sum = 0;
                    for (int j = firstIndex[i] + 1; j < lastIndex[i]; j++) {
                        sum += (int) s.charAt(j);
                    }
                    if (sum > 0) {
                        result.add(sum);
                    }
                }
            }

            return result;
        }
    }

}

// The code defines a class `ASCII_Range_Sum` with a nested class `Solution`
// that contains a method `asciirange`.
// This method takes a string `s` and calculates the ASCII sum of characters
// that occur more than once in the string.
// It uses two arrays to track the first and last occurrence of each character
// in the string.
// The method iterates through the string, updating the first and last indices
// for each character.
// Finally, it calculates the ASCII sum for characters that have multiple
// occurrences and returns a list of
