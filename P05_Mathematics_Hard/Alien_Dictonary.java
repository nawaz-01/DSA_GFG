
// A new alien language uses the English alphabet, but the order of letters is unknown. You are given a list of words[] from the alien language’s dictionary, where the words are claimed to be sorted lexicographically according to the language’s rules.

// Your task is to determine the correct order of letters in this alien language based on the given words. If the order is valid, return a string containing the unique letters in lexicographically increasing order as per the new language's rules. If there are multiple valid orders, return any one of them.

// However, if the given arrangement of words is inconsistent with any possible letter ordering, return an empty string ("").

// A string a is lexicographically smaller than a string b if, at the first position where they differ, the character in a appears earlier in the alien language than the corresponding character in b. If all characters in the shorter word match the beginning of the longer word, the shorter word is considered smaller.

// Note: Your implementation will be tested using a driver code. It will print true if your returned order correctly follows the alien language’s lexicographic rules; otherwise, it will print false.

// Examples:

// Input: words[] = ["baa", "abcd", "abca", "cab", "cad"]
// Output: true
// Explanation: A possible corrct order of letters in the alien dictionary is "bdac".
// The pair "baa" and "abcd" suggests 'b' appears before 'a' in the alien dictionary.
// The pair "abcd" and "abca" suggests 'd' appears before 'a' in the alien dictionary.
// The pair "abca" and "cab" suggests 'a' appears before 'c' in the alien dictionary.
// The pair "cab" and "cad" suggests 'b' appears before 'd' in the alien dictionary.
// So, 'b' → 'd' → 'a' → 'c' is a valid ordering.
// Input: words[] = ["caa", "aaa", "aab"]
// Output: true
// Explanation: A possible corrct order of letters in the alien dictionary is "cab".
// The pair "caa" and "aaa" suggests 'c' appears before 'a'.
// The pair "aaa" and "aab" suggests 'a' appear before 'b' in the alien dictionary. 
// So, 'c' → 'a' → 'b' is a valid ordering.
// Input: words[] = ["ab", "cd", "ef", "ad"]
// Output: ""
// Explanation: No valid ordering of letters is possible.
// The pair "ab" and "ef" suggests "a" appears before "e".
// The pair "ef" and "ad" suggests "e" appears before "a", which contradicts the ordering rules.
// Constraints:
// 1 ≤ words.length ≤ 500
// 1 ≤ words[i].length ≤ 100
// words[i] consists only of lowercase English letters.

package P05_Mathematics_Hard;

import java.util.*;

public class Alien_Dictonary {

    class Solution {
        public String findOrder(String[] words) {
            Map<Character, Set<Character>> graph = new HashMap<>();
            Map<Character, Integer> indegree = new HashMap<>();

            // Step 1: Initialize graph and indegree map
            for (String word : words) {
                for (char c : word.toCharArray()) {
                    graph.putIfAbsent(c, new HashSet<>());
                    indegree.putIfAbsent(c, 0);
                }
            }

            // Step 2: Build the graph
            for (int i = 0; i < words.length - 1; i++) {
                String w1 = words[i];
                String w2 = words[i + 1];
                int minLen = Math.min(w1.length(), w2.length());
                boolean foundDifference = false;

                for (int j = 0; j < minLen; j++) {
                    char c1 = w1.charAt(j);
                    char c2 = w2.charAt(j);
                    if (c1 != c2) {
                        if (!graph.get(c1).contains(c2)) {
                            graph.get(c1).add(c2);
                            indegree.put(c2, indegree.get(c2) + 1);
                        }
                        foundDifference = true;
                        break;
                    }
                }

                // Invalid case: word2 is a prefix of word1 (e.g., "abc" and "ab")
                if (!foundDifference && w1.length() > w2.length()) {
                    return "";
                }
            }

            // Step 3: Topological sort using BFS (Kahn's Algorithm)
            Queue<Character> queue = new LinkedList<>();
            for (char c : indegree.keySet()) {
                if (indegree.get(c) == 0) {
                    queue.offer(c);
                }
            }

            StringBuilder sb = new StringBuilder();
            while (!queue.isEmpty()) {
                char current = queue.poll();
                sb.append(current);
                for (char neighbor : graph.get(current)) {
                    indegree.put(neighbor, indegree.get(neighbor) - 1);
                    if (indegree.get(neighbor) == 0) {
                        queue.offer(neighbor);
                    }
                }
            }

            // If not all characters are in the result, a cycle exists
            if (sb.length() != indegree.size()) {
                return "";
            }

            return sb.toString();
        }
    }

}

// The above code defines a class `Alien_Dictonary` with a nested class
// `Solution` that implements the method `findOrder`.
// This method takes an array of strings `words` and determines the order of
// characters in an
// alien language based on the lexicographical order of the words. It constructs
// a directed graph representing the relationships between characters and
// performs a topological sort to find a valid character order.
// If a valid order exists, it returns a string containing the characters in the
// correct order; otherwise, it returns an empty string.
// The code handles cases where the words are inconsistent with any possible
// letter ordering by checking for cycles in the graph and ensuring that no word
// is a prefix of another in a way that contradicts the character order.
// The solution uses Kahn's algorithm for topological sorting, which is
// efficient and suitable for this problem.
// The code is structured to handle the constraints provided, ensuring that it
// can process up to 500 words with lengths up to 100 characters efficiently.

// The `findOrder` method initializes a graph and an indegree map, builds the
// graph based on the relationships between characters in the words, and then
// performs a topological sort using a queue to determine the order of
// characters.
// If the length of the resulting string does not match the number of unique
// characters, it indicates