package leetCode_solutions.arrays;

import java.util.*;

public class ArraysAndStrings {
    public static void main(String[] args) {
        int[] array1 ={ 2,2,1,1,1,1,2,1,9,1,0,1,2,0,1,1,2,2,2};
        int[] array2 = {7,6,4,3,1};
        Integer[] array3 = {-1,1,2,3,1};
        Integer[] array4 = {-6,2,5,-2,-7,-1,3};
        int[] array5 = {4,5,6,7,8,9};
        int[] array6 = {5,5,5};
        System.out.println(maximizeSum(array6,2));
        String[] strArray = {"hello how are you","qwe eqwf ceqcvw qewdf qfqf qq","32e wjcencv cewwe"};
      //  System.out.println(Arrays.toString(decompressRLElist2(new int[]{1,2,3,4})));
        //  System.out.println(arithmeticTriplets2(array5,2));
       // System.out.println((char) ('a'+4));

      //  System.out.println(Arrays.toString(leftRightDifference(array5)));
      //  System.out.println(Arrays.toString(createTargetArray(array5,array6)));
       // System.out.println(numberOfEmployeesWhoMetTarget(array5,6));
       // System.out.println(maxProductDifference(array5));
       // System.out.println(majorityElement4(array1));
       // System.out.println(maxProductDifference());

        // System.out.println(maxProfit2(array1));
       // System.out.println(removeDuplicates(array));
       // System.out.println(Arrays.toString(array));
       // System.out.println(Arrays.toString(plusOne2( new int[]{9,9,9,9,9,9,9,9,9,9})));
    }
    public static int removeDuplicates(int[] nums) {

        if (nums.length==0)
            return 0;

        int j = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length -1;
        int middle;

        while(right>=left){
            middle = left + (right -left) /2;

            if(nums[middle]==target){
                return middle;
            }
            if(target>nums[middle]){
                left = middle+1;
            }
            else right = middle-1;
        }

        return left;
    }

    public static int[] plusOne(int[] digits) {

        for(int i = digits.length-1 ;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;

        }

        int[] biggestArray = new int[digits.length+1];
        biggestArray[0] = 1;

        return biggestArray;
    }
    public static int maxProfit(int[] prices) {

        int maxProfit = 0;

        for(int i = 0; i<prices.length-1; i++){
            for(int j = i+1;j<prices.length;j++){
               if((prices[j]-prices[i])>maxProfit){
                   maxProfit = prices[j] - prices[i];
               }
            }
        }
        return maxProfit;
    }
    public static int maxProfit2(int[] prices){

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i:prices){
            minPrice = Math.min(minPrice, i);
            maxProfit = Math.max(i-minPrice,maxProfit);
        }
        return maxProfit;
    }

    /// easy level///
    public  static int majorityElement(int[] nums) {

        int half = nums.length /2;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i<nums.length;i++ ){
            map.put(nums[i],(map.getOrDefault(nums[i],0)+1));
            if(map.get(nums[i])>half){
                return nums[i];
            }
        }
        return -1;
    }
////   easy level///
    public static int majorityElement2(int[] nums){

        int count = 0;
        int candidate = 0;

        for(int i = 0; i<nums.length;i++){
            if(count==0){
                candidate = nums[i];
            }
            if(candidate == nums[i]){
                count ++;
            }
            else count --;
        }
        return candidate;
    }
    //// medium level
    public static List<Integer> majorityElement3(int[] nums) {
        int count = nums.length / 3;
        Set<Integer> added = new HashSet<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

            if (map.get(num) > count) {
                added.add(num);
            }
        }

        return new ArrayList<>(added);
    }

    public static List<Integer> majorityElement4(int[] nums) {
        int thirdOfTheLength = nums.length / 3;

        List<Integer> list = new ArrayList<>();

        int count1 = 0, count2 = 0;
        int candidate1 = 0, candidate2 = 0;

        for (int i = 0; i<nums.length; i++){
            if(count1 == 0 && candidate2 != nums[i]){
                count1 = 1;
                candidate1 = nums[i];
            } else if (count2 == 0 && candidate1 != nums[i]) {
                count2 = 1;
                candidate2 = nums[i];
            } else if (candidate1 == nums[i]) {
                count1++;
            } else if (candidate2 == nums[i]) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for(int i = 0; i < nums.length; i++){
            if(candidate1 == nums[i]){
                count1++;
            } else if (candidate2 == nums[i]) {
                count2++;
            }
        }

       if(count1 > thirdOfTheLength){
           list.add(candidate1);
       }
       if(count2 >thirdOfTheLength){
           list.add(candidate2);
       }
       return list;

    }

    public  static int countPairs(List<Integer> nums, int target) {

        int pairsCount = 0;

        for(int i = 0; i<nums.size(); i++){
            for(int j = i+1 ;j<nums.size();j++ ){
                if((nums.get(i)+nums.get(j))<target)
                    pairsCount++;
            }
        }
        return pairsCount;
    }
    //////easy
    //1913. Maximum Product Difference Between Two Pairs
    public static int maxProductDifference(int[] nums) {

        Arrays.sort(nums);

        return (nums[nums.length-1]*nums[nums.length-2]) - (nums[0]*nums[1]);
    }
    ///// 2942. Find Words Containing Character

    public List<Integer> findWordsContaining(String[] words, char x) {

        List<Integer> result = new ArrayList<>();
        for(int i = 0 ;i<words.length;i++){
            if(words[i].indexOf(x)!=-1){
                result.add(i);
            }
        }
        return result;
    }
// 1672. Richest Customer Wealth

    public int maximumWealth(int[][] accounts) {

        int maxWealth = Integer.MIN_VALUE;

        for(int i = 0; i<accounts.length;i++){
            int lineSum = 0;
            for(int j = 0; j<accounts[i].length;j++){
                lineSum += accounts[i][j];
            }
            maxWealth = Math.max(lineSum, maxWealth);
        }
        return maxWealth;
    }

    ///2798. Number of Employees Who Met the Target
    public static int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count = 0;

        for(int i: hours){
            if(target<=i){
                count++;
            }
        }
        return count;
    }

    /////1431. Kids With the Greatest Number of Candies
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        for(int candy : candies){
             max = Math.max(max,candy);
        }

        for(int candy : candies){
            result.add((candy + extraCandies)>= max);
        }
        return result;
    }

    /////1480. Running Sum of 1d Array
    public static int[] runningSum(int[] nums) {
        int[] resultArray = new int[nums.length];

        int count = 0;

        for(int i = 0; i<nums.length;i++){
            count+=nums[i];
            resultArray[i] = count;
        }
        return resultArray;
    }

   /// 1365. How Many Numbers Are Smaller Than the Current Number

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];

        for(int i = 0; i<nums.length;i++){
            int count = 0;
            for(int j = 0;j<nums.length;j++){
                if(nums[i]>nums[j]){
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }

    public static int mostWordsFound(String[] sentences) {
        int counter = 0;

        for (String sentence : sentences) {
            counter = Math.max(counter, sentence.split(" ").length);
        }
        return counter;
    }
    public static int mostWordsFound2(String[] sentences) {
        int counter = 0;

        StringTokenizer tokenizer ;
        for (String sentence : sentences) {
            tokenizer = new StringTokenizer(sentence," ");
            counter = Math.max(counter, tokenizer.countTokens());
        }
        return counter;
    }

    //// 2574. Left and Right Sum Differences
    public static int[] leftRightDifference(int[] nums) {

        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        int[] result = new int[nums.length];

        int leftSumCounter = 0;
        for(int i = 0; i<nums.length;i++){
            leftSum[i] = leftSumCounter;
            leftSumCounter+=nums[i];
        }

        int rightSumCounter = 0;

        for(int i = nums.length-1; i>=0;i--){
            rightSum[i] = rightSumCounter;
            rightSumCounter += nums[i];
        }

        for(int i = 0;i<nums.length;i++){

            if(leftSum[i]>=rightSum[i]){
                result[i] = leftSum[i]-rightSum[i];
            }
            else result[i] = rightSum[i] - leftSum[i];
        }
        return result;
    }

    /////1389. Create Target Array in the Given Order

    public  static int[] createTargetArray(int[] nums, int[] index) {

        List<Integer> list = new ArrayList<>(nums.length);
        int[] result = new int[nums.length];

        for(int i = 0; i<nums.length;i++){
            list.add(index[i],nums[i]);
        }
        for(int i = 0 ;i<result.length;i++){
            result[i] = list.get(i);
        }
        return result;
    }

    //// 1662. Check If Two String Arrays are Equivalent

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        StringBuilder string1 = new StringBuilder();
        StringBuilder string2 = new StringBuilder();

        for (String s : word1) {
            string1.append(s);
        }

        for (String s : word2) {
            string2.append(s);
        }
        return string1.toString().contentEquals(string2);
    }

    ////1528. Shuffle String
    public static String restoreString(String s, int[] indices) {

        char[] array = new char[indices.length];

        for(int i = 0; i<indices.length;i++){
            array[indices[i]] = s.charAt(i);
        }
        return new String(array);
    }

    ///1816. Truncate Sentence

    public  static String truncateSentence(String s, int k) {
        int spaceCounter = 0;

        for(int i = 0 ; i<s.length();i++){
            if(s.charAt(i)==' '){
                spaceCounter++;
            }
            if(spaceCounter==k){
                s = s.substring(0,i);
            }
        }
        return s;
    }
///1313. Decompress Run-Length Encoded List

    public static int[] decompressRLElist(int[] nums) {

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i<nums.length;i+=2){
            int j = nums[i];
            while(j>0){
                list.add(nums[i+1]);
                j--;
            }
        }
        int[] result = new int[list.size()];
        for(int i = 0; i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }

    public static int[] decompressRLElist2(int[] nums) {

        int arraySize = 0;

        for(int i = 0; i<nums.length;i+=2){
            arraySize+= nums[i];
        }

        int[] result = new int[arraySize];
        int currentIndex= 0 ;

        for(int i = 0; i<nums.length;i+=2){
            int j = nums[i];
            while(j>0){
                result[currentIndex] = nums[i+1];
                j--;
                currentIndex++;
            }
        }
        return result;
    }
    /// 1773. Count Items Matching a Rule
    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

        int countMatches = 0;

        int index = switch (ruleKey) {
            case "type" -> 0;
            case "color" -> 1;
            case "name" -> 2;
            default -> -1;
        };

        for(List<String> element: items){
            if(element.get(index).equals(ruleValue)){
                countMatches++;
            }
        }
        return countMatches;
    }
    ////2828. Check if a String Is an Acronym of Words

    public  static boolean isAcronym(List<String> words, String s) {

        char[] array = new char[words.size()];

        for(int i = 0; i<words.size();i++){
           array[i] =  words.get(i).charAt(0);
        }

        return new String(array).equals(s);
    }

   /// 2535. Difference Between Element Sum and Digit Sum of an Array


    public static int differenceOfSum(int[] nums) {

        int elementSum = 0;
        int digitSum = 0;

        for (int num : nums) {
            if (num <= 9) {
                elementSum += num;
                digitSum += num;
            } else {
                elementSum += num;
                int element = num;
                while (element != 0) {
                    digitSum += element % 10;
                    element /= 10;
                }
            }
        }
        return elementSum-digitSum;
    }

    /////  2006. Count Number of Pairs With Absolute Difference K


    public static  int countKDifference(int[] nums, int k) {

        int count = 0;

        for(int i =0 ; i<nums.length;i++){
            int requiredElement = nums[i]+k;
            int requiredElement2 = nums[i]-k;
            for(int j = i+1; j<nums.length;j++){
                if(requiredElement==nums[j]||requiredElement2==nums[j]){
                    count++;
                }
            }
        }
        return count;
    }
    public static  int countKDifference2(int[] nums, int k) {

        int count = 0;

        for(int i =0 ; i<nums.length;i++){
            for(int j = i+1; j<nums.length;j++){
                if(nums[i]-k==nums[j]||nums[i]+k==nums[j]){
                    count++;
                }
            }
        }
        return count;
    }
    public static  int countKDifference3(int[] nums, int k) {

        int count=0;
        for(int i=0; i<nums.length-1; i++) {
            for (int j = i; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    count++;
                }
            }
        }
        return count;
    }


    //// 2367. Number of Arithmetic Triplets
    public  static int arithmeticTriplets(int[] nums, int diff) {

        int tripletsCount = 0;

        for(int i = nums.length-1 ; i>=0; i--){
            int middleElementIndex = binarySearch2(nums,nums[i]-diff,i);
            if(middleElementIndex !=-1){
                int leftElementIndex = binarySearch2(nums,nums[middleElementIndex]-diff,middleElementIndex);
                if(leftElementIndex != -1){
                    tripletsCount++;
                }
            }
        }
        return tripletsCount;
    }

    public static int binarySearch2(int[] array, int element, int lastIndex){

        int left = 0;
        int right = lastIndex-1;
        int middle;

        while(right>=left){
            middle = left + (right-left) /2;
            if(array[middle]==element){
                return middle;
            }
            if(element>array[middle]){
                left = middle +1;
            }
            else right = middle - 1;
        }
        return  -1;
    }

    public static int arithmeticTriplets2(int[] nums, int diff) {
        int count = 0;
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num - diff) && seen.contains(num - diff * 2)) {
                ++count;
            }
            seen.add(num);
        }
        return count;
    }

    ///804. Unique Morse Code Words

    public  static int uniqueMorseRepresentations(String[] words) {

        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--",
                "-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        Set<String> setOfWords = new HashSet<>();

        StringBuilder representation = new StringBuilder();
        for(String word: words){
           representation.setLength(0);
            for(int i = 0 ; i<word.length();i++){
                representation.append(morse[word.charAt(i)-'a']);
            }
            setOfWords.add(representation.toString());
        }
        return setOfWords.size();
    }

    ///1684. Count the Number of Consistent Strings

    public  static int countConsistentStrings(String allowed, String[] words) {

        int count = words.length;
        Set<Character> symbols = new HashSet<>(allowed.length());

        for(Character c : allowed.toCharArray()){
            symbols.add(c);
        }

        for(String word: words){
            for(int i = 0; i<word.length();i++){
                if (!symbols.contains(word.charAt(i))) {
                    count--;
                    break;
                }
            }
        }
        return count;
    }

    ///1732. Find the Highest Altitude

    public int largestAltitude(int[] gain) {

        int largest = 0;

        int current = 0;


        for (int i : gain) {
            current += i;
            largest = Math.max(current, largest);
        }
        return largest;
    }

    /// 1464. Maximum Product of Two Elements in an Array
    public static int maxProduct(int[] nums) {

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;


       for(int element : nums){
           if(element>max1){
               max2 = max1;
               max1 = element;
           } else if (element>max2) {
               max2 = element;
           }
       }
       return (max1-1) *(max2-1);
    }

    ///2656. Maximum Sum With Exactly K Elements

    public static int maximizeSum(int[] nums, int k) {
        int max = Integer.MIN_VALUE;

        for(int current : nums){
           max = Math.max(current,max);
        }
        int sum = 0;

        for(int i = 0 ;i<k;i++){
           sum+=max;
           max++;
        }
        return sum;
    }
    //// 2418. Sort the People

    public static String[] sortPeople(String[] names, int[] heights) {

        Map<Integer, String> repository = new TreeMap<>(Comparator.reverseOrder());

        for(int i = 0; i<heights.length; i++){
            repository.put(heights[i],names[i]);
        }
        return repository.values().toArray(new String[0]);
    }


    //// 2108. Find First Palindromic String in the Array

    public static String firstPalindrome(String[] words) {

        for(String word : words){
            StringBuilder stringBuilder = new StringBuilder(word);
            if(stringBuilder.reverse().toString().equals(word)){
                return word;
            }
        }
        return "";
    }
}
