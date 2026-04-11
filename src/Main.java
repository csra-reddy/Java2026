import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //sliding window, linked list and tree problems latest
        MyHashMap<String, Integer> map = new MyHashMap<>();

        map.put("A", 1);
        map.put("B", 2);
        map.put("A", 3); // update
        map.put("C", 4);

        System.out.println("A = " + map.get("A")); // 3
        System.out.println("B = " + map.get("B")); // 2
        System.out.println("C = " + map.get("C")); // 4
        System.out.println("D = " + map.get("D")); // null

        map.printMap();




        //given an array nums and value, remove all instance of the value in place and find the new length after removal. Do not allocate new space for another array
        /*int[] array = {1, 2, 3, 4, 5};
        int value = 3;
        int newLength = 0;
        int j = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] != value) {
                array[j] = array[i];
                j++;
            }
        }
        newLength = j;
        System.out.println(Arrays.toString(array));
        System.out.println("New Length is : " + newLength);*/

        /*String s = "abca";
        Map<Character, Integer> map = new HashMap<>();

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Check if all frequencies are same
        int freq = -1;

        for (int count : map.values()) {
            if (freq == -1) {
                freq = count;
            } else if (freq != count) {
                System.out.println("Not same");
                return;
            }
        }

        System.out.println("same");*/

        /*//Given list of integers and target, identify two numbers which add up to the sum?
        int[] numbers = {3,6,7,5,2,1,8};
        int target = 12;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                System.out.println("The two numbers are: " + numbers[i] + " and " + complement);
                break;
            }
            map.put(numbers[i], i);
        }*/
        /*int[] numbers = {3,6,7,5,2,1,8};
        int target = 12;
        for(int i = 0; i < numbers.length-1; i++) {
            int complement = target - numbers[i];
            for(int j = i+1; j < numbers.length; j++) {
                if(complement == numbers[j]) {
                    System.out.println("The two numbers are: " + numbers[i] + " and" + complement);
                }
            }
        }*/

        /*//find the second highest number in an Array
        int[] list = {10,20,15};
        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;
        for(int i: list) {
            if(i > highest) {
                secondHighest = highest;
                highest = i;
            } else if(i > secondHighest && i != highest) {
                secondHighest = i;
            }
        }
        System.out.println("second highest is: " + secondHighest);
*/

        /*//Identify if String is palindrome
        String str = "madam";
        char[] charArray = str.toCharArray();
        boolean isPalindrome = true;
        for(int i=0; i<charArray.length/2; i++) {
            if(charArray[i] != charArray[charArray.length-i-1] ) {
                isPalindrome = false;
                break;
            }
        }
        if(isPalindrome){
            System.out.println(str + " is a palindrome");
        } else {
            System.out.println(str + " is not palindrome");
        }*/
        /*//Given an array of size n with numbers from 1 to n, find which numbers are missing from the array.
        int[] nums = {8, 7, 6, 5, 5, 3, 3, 1};
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            set.add(i);
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i<nums.length; i++) {
            if(!set.contains(i)) {
                result.add(i);
            }
        }
        System.out.println(result);*/

        /*//move all non-zero numbers to the extreme right
        int[] nums = {0, 1 , 2, 10, 3, 0, 0, 4, 7, 0};
        int j = 0;
       for (int i = 0; i < nums.length; i++) {
           if (nums[i] != 0) {
               nums[j] = nums[i];
               j++;
           }
       }
        while (j < nums.length) {
            nums[j] = 0;
            j++;
        }
       System.out.println(Arrays.toString(nums));*/


       /* int num = 236;
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        System.out.println(num);*/

        /// //////////////////
        //Merge two sorted linked lists and return a new sorted list using ListNode????????
////////////////////////////////

        /*//sliding window with Brute Force approach
        int[] nums = {7, -3, 1, -1, 5, 6, 2, 9};
       int k = 3;
       int largest = 0;
       for (int i = 0; i <= nums.length - k; i++) {
           System.out.println("Now we are looking at the subset: " + nums[i] + " , " + nums[i+1] + " , " + nums[i+2]);
           int iLargest = (nums[i] >= nums[i+1] && nums[i] >= nums[i+2]) ? nums[i] : (nums[i+1] >= nums[i] && nums[i+1] >= nums[i+2]) ? nums[i+1] : nums[i+2];
            if (largest < iLargest) {
                largest = iLargest;
            }
       }
        System.out.println("Largest number is " + largest);*/

        /* String s = "cbaebabacd";   // hardcoded
        String p = "abc";          // hardcoded

        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length())
            return;

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Count characters in p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        int windowSize = p.length();

        // Sliding window
        for (int i = 0; i < s.length(); i++) {
            // Add current character
            sCount[s.charAt(i) - 'a']++;

            // Remove character outside window
            if (i >= windowSize) {
                sCount[s.charAt(i - windowSize) - 'a']--;
            }

            // Compare frequency arrays
            if (Arrays.equals(pCount, sCount)) {
                result.add(i - windowSize + 1);
            }
        }

        System.out.println("Anagram indices: " + result);*/


        /*List<String> fruits = Arrays.asList("apple", "alarm", "blueberry", "grapes", "banana");
        List<String> result = fruits.stream()
                .filter(f -> f.length() > 5) // Filter elements with length > 5
                .peek(e -> System.out.println("Filtered value: " + e)) // Log filtered values
                .map(String::toUpperCase) // Transform to uppercase
                .peek(e -> System.out.println("Mapped value: " + e)) // Log mapped values
                .collect(Collectors.toList()); // Terminal operation to trigger execution

        System.out.println("Final Results: " + result);

        HashMap<String, String> map = new HashMap<>();*/
        /*for(Map.Entry<String, String> x: map.entrySet()) {
            System.out.println(x.getKey() + ": " + x.getValue());
        }*/
/*
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next.getKey() + ": " + next.getValue());
        }*/
        /*//reverse a String
        String input = "Chandra";
        char[] chars = input.toCharArray();
        char temp;
        int left;
        int right = chars.length - 1;
        for(left = 0; left<right; left++) {
            temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            right--;
        }
        System.out.println(Arrays.toString(chars));*/

       /* List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream().peek(System.out::println).toList();
        System.out.println(numbers.stream().mapToInt(Integer::intValue).summaryStatistics());*/
        /*System.out.println(numbers.stream().findAny());
        System.out.println(numbers.stream().anyMatch(n->n<0));
        List<List<Integer>> x = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
        System.out.println(x.stream().flatMap(Collection::stream).collect(Collectors.toList()));*/
        /*List<Integer> numbers1 = numbers.stream().filter(n->n%2==0).toList();
        System.out.println(numbers1);
        System.out.println(numbers.stream().sorted().collect(Collectors.toList()));

        System.out.println(numbers.stream().max(Integer::compare));
        System.out.println(numbers.stream().mapToInt(Integer::intValue).sum());

        List<String> names = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h");
        System.out.println(names.stream().map(String::toUpperCase).toList());

        //count the number of elements in a list that are greater than 5
        System.out.println(numbers.stream().filter(n->n>5).count());*/

        //move all zeros to the end in a given an array, ensure the
        /*int[] nums = {1,2,0,5,2,0,1,78,0,34,5,0,5,6,2,0,9};
        int i = 0;
        for(int j=0;j<nums.length;j++){
            if(nums[j] != 0){
                nums[i] = nums[j];
                i++;
            }
        }
        while (i < nums.length){
            nums[i] = 0;
            i++;
        }
        System.out.println("i is " + i);
        System.out.println(Arrays.toString(nums));
*/

        //Merge two already sorted linked lists in to a single linked list ??????????????????????????


/*
        int[] nums = {1,2,3,4,5,6,7,8,9,1,2,1,2,3,4,5,6};
        int val = 2;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));*/
        // so basically we are using 2 pointers, one pointers for looping through array and other pointer to allocate numbers if not equal to val

        //given an array of integers and a target, return or identify indices of 2 numbers that add up to the target
        /*int[] nums = {2,6,12,4,7,1,8};
        int target = 13;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int missingNumber = target - nums[i];
            if(!map.containsKey(missingNumber)){
                map.put(nums[i], i);
            } else {
                System.out.println("Two numbers are: " + nums[i] + " " + missingNumber);
            }
        }*/

        /*int[] nums2 = {1,2,3,4,5,6,7,8,9};
        int target2 = 10;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            int missingNumber = target2 - nums2[i];
            if(!set.contains(missingNumber)){
                set.add(nums2[i]);
            } else  {
                System.out.println("Two numbers are: " + nums2[i] + " " + missingNumber);
            }
        }
*/
        /*//Java program to remove all white spaces from a String without using replace
        String str = "How are you doing?";
        char[] arr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if(c != ' ') {
                sb.append(c);
            }
        }
        System.out.println(sb);*/
        
        //find second-highest number in an array
        /*int[] arr = {10, 5, 20, 8, 25, 15};
        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;
        for (int num : arr) {

            if (num > highest) {
                secondHighest = highest;
                highest = num;
            } else if (num > secondHighest && num < highest) {
                secondHighest = num;
            }
        }
        System.out.println("Second Highest: " + secondHighest);
        }*/


        /*find duplicate characters in a String
        we can use the below same counting words using Hashmap and in the final if value is greater than 1 for any key we can arrive at duplicate keys
        if(wordCount.getValue > 1) -> which means it has duplicates
*/


        // count number of words in a String using HashMap
        /*String str = "Hyderabad is a known place for Biryani";
        String[] words = str.split(" ");
        Map<String, Integer> wordCount = new HashMap<>();
        for(String word : words){
            if(wordCount.containsKey(word)){
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }
        System.out.println(wordCount);*/



        //reverse a String
        /*String str = "Hyderabad";
        String strReversed = "";
        char[] chars = str.toCharArray();
        for (int i = chars.length-1; i >=0; i--) {
            strReversed += chars[i];
        }
        System.out.printf("%s\n", strReversed);*/
    }
}