import java.util.Arrays;

class Algorithms {
    public static void main(String[] args) {
        int [] array = new int[]{-2,0,9,-11,8,5,-6,3,14,0,15,14,7,8,2,-88,11};
      // bubbleSort2(array);

      // System.out.println(binarySearch(array,-6));
      //  System.out.println(Arrays.toString(array));
       // System.out.println(binarySearch2(array,-88));
       // System.out.println(Arrays.toString(bubbleSort2((new int[]{11,-2,9,-11,8,5,14,0,15,14,7,8,2}))));
    }
  public static int binarySearch(int[] array, int element){

        int left = 0;
        int right = array.length-1;
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

 public static void selectSort(int[] nums){

        for(int i = 0; i<nums.length-1;i++){
            int minIndex = i;
            for(int j = i+1;j<nums.length;j++){
                if(nums[j]<nums[minIndex]){
                    minIndex = j;
                }
            }
            int minValue = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = minValue;
        }
    }

    public static void bubbleSort(int[] nums) {

        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[i - 1]) {
                    int temp = nums[i - 1];
                    nums[i-1] = nums[i];
                    nums[i] = temp;
                    isSorted = false;
                }
            }
        }
    }

    public static int minIndex(int[] nums){
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;

        for(int i = 0;i< nums.length;i++){
            if(nums[i]<minValue){
                minValue = nums[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

}
