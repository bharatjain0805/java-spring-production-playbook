package filtering;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FilteringStreamSolutions {

    // Streams 1: Remove duplicates without distinct()
    public static List<Integer> removeDuplicatesWithoutDistinct(List<Integer> list) {
        Set<Integer> seen = new HashSet<>();
        return list.stream()
                .filter(seen::add) // add() returns false if already present
                .collect(Collectors.toList());
    }

    // Streams 2: Get only duplicates from a list
    public static List<Integer> getOnlyDuplicates(List<Integer> list) {
        Set<Integer> seen = new HashSet<>();
        return list.stream()
                .filter(i -> !seen.add(i))
                .collect(Collectors.toList());
    }

    // Streams 3: Sort in descending order
    public static List<Integer> sortDescending(List<Integer> list) {
        return list.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    // Streams 4: Practice Questions on Sort
    // 4a. Sort strings by increasing length
    public static List<String> sortByLength(List<String> list) {
        return list.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    // 4b. Sort decimals in reverse order
    public static List<Double> sortDecimalsDescending(List<Double> list) {
        return list.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    // Streams 5: Find Max Number in a list
    public static int findMaxNumber(List<Integer> list) {
        return list.stream()
                .max(Comparator.naturalOrder())
                .orElse(0);
    }

    // Streams 6: Check if all numbers are even
    public static boolean checkAllEven(List<Integer> list) {
        return list.stream().allMatch(i -> i % 2 == 0);
    }

    // Streams 7: Find numbers starting with '1'
    public static List<Integer> numbersStartingWithOne(List<Integer> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .filter(i -> String.valueOf(i).startsWith("1"))
                .toList();
    }

    // Streams 8: Find Palindrome Strings
    public static List<String> findPalindromes(List<String> words) {
        return words.stream()
                .filter(s -> s.equalsIgnoreCase(new StringBuilder(s).reverse().toString()))
                .toList();
    }

    // Streams 9: Find the longest word in a list
    public static Optional<String> findLongestWord(List<String> words) {
        return words.stream().max(Comparator.comparingInt(String::length));
    }

    // Streams 10: Practice on filter
    // 10a. First even number
    public static Optional<Integer> firstEven(List<Integer> list) {
        return list.stream().filter(n -> n % 2 == 0).findFirst();
    }

    // 10b. Cube elements and filter those > 50
    public static List<Integer> cubeAndFilter(List<Integer> list) {
        return list.stream()
                .map(n -> n * n * n)
                .filter(n -> n > 50)
                .toList();
    }

    // Streams 11: Merge two unsorted arrays into a single sorted array
    public static int[] mergeAndSortArrays(int[] a, int[] b) {
        return Stream.concat(Arrays.stream(a).boxed(), Arrays.stream(b).boxed())
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    // Streams 11 (Variant): Get top 3 elements from list
    public static List<Integer> getTopThree(List<Integer> list) {
        return list.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .toList();
    }

    // Streams 12: Get 3rd highest element from list
    public static int getThirdHighest(List<Integer> list) {
        return list.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(2)
                .findFirst()
                .orElse(-1);
    }

    // Streams 13: Check if two strings are anagrams
    public static boolean checkAnagrams(String s1, String s2) {
        String sorted1 = Stream.of(s1.replaceAll("\\s", "").split(""))
                .map(String::toLowerCase)
                .sorted()
                .collect(Collectors.joining());
        String sorted2 = Stream.of(s2.replaceAll("\\s", "").split(""))
                .map(String::toLowerCase)
                .sorted()
                .collect(Collectors.joining());
        return sorted1.equals(sorted2);
    }

    // Streams 14: Sum of all digits in a number
    public static int sumOfDigits(int number) {
        return Arrays.stream(String.valueOf(number).split(""))
                .mapToInt(Integer::parseInt)
                .sum();
    }

    // Streams 15: Find common elements between two lists/arrays
    public static List<Integer> findCommonElements(List<Integer> list1, List<Integer> list2) {
        return list1.stream()
                .filter(list2::contains)
                .toList();
    }

    // Streams 16: Reverse each word of a string
    public static String reverseEachWord(String sentence) {
        return Arrays.stream(sentence.split(" "))
                .map(word -> new StringBuilder(word).reverse())
                .collect(Collectors.joining(" "));
    }

    // Streams 17: Count occurrences of a target word across sentences
    public static long countWordOccurrences(List<String> sentences, String targetWord) {
        return sentences.stream()
                .flatMap(s -> Arrays.stream(s.split("\\s+")))
                .filter(w -> w.equalsIgnoreCase(targetWord))
                .count();
    }

    // Streams 18: Convert list of sentences into unique words
    public static Set<String> getUniqueWords(List<String> sentences) {
        return sentences.stream()
                .flatMap(s -> Arrays.stream(s.split("\\s+")))
                .map(String::toLowerCase)
                .collect(Collectors.toSet());
    }

    // Streams 19: Flatten a List<List<Integer>> into a single List<Integer>
    public static List<Integer> flattenListOfLists(List<List<Integer>> nested) {
        return nested.stream()
                .flatMap(Collection::stream)
                .toList();
    }

    // Streams 20: Find all the longest words in a list (in case of length ties)
    public static List<String> findAllLongestWords(List<String> words) {
        int maxLength = words.stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);

        return words.stream()
                .filter(s -> s.length() == maxLength)
                .toList();
    }

    // Streams 21: Reduce questions - Sum of numbers
    public static int sumWithReduce(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }

    // Streams 22: Longest common prefix using reduce
    public static String longestCommonPrefix(List<String> strings) {
        return strings.stream().reduce((s1, s2) -> {
            int length = Math.min(s1.length(), s2.length());
            int i = 0;
            while (i < length && s1.charAt(i) == s2.charAt(i)) {
                i++;
            }
            return s1.substring(0, i);
        }).orElse("");
    }

    // Streams 23: Max Product of two elements in a given array
    public static int maxProduct(int[] nums) {
        int[] sorted = Arrays.stream(nums)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(i -> i)
                .toArray();
        // Product of two largest positive vs two smallest negative
        int n = sorted.length;
        return Math.max(sorted[0] * sorted[1], sorted[n - 1] * sorted[n - 2]);
    }

    // Streams 24: First non-repeating character in a String using Streams
    public static Character firstNonRepeatingChar(String s) {
        return s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1L)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    // Streams 25: Frequency of each word in a string
    public static Map<String, Long> wordFrequency(String sentence) {
        return Arrays.stream(sentence.trim().split("\\s+"))
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
    }
}
