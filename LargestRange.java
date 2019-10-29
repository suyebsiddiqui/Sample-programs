import java.util.HashMap;

public class LargestRange {

    public static int[] largestRange(int[] array) {
        int[] bestRange = new int[2];
        int longestlength = 0;
        HashMap<Integer, Boolean> nums = new HashMap<>();
        for(int num: array) {
            nums.put(num, true);
        }
        for(int num : array) {
            if(!nums.get(num)) {
                continue;
            }

            nums.put(num, false);
            int currentLength = 1;
            int left = num-1;
            int right = num+1;
            while(nums.containsKey(left)) {
                nums.put(left, false);
                currentLength++;
                left--;
            }
            while(nums.containsKey(right)) {
                nums.put(right, false);
                currentLength++;
                right++;
            }
            if(currentLength> longestlength) {
                longestlength = currentLength;
                bestRange = new int[] {left + 1, right - 1};
            }
        }

        return bestRange;
    }

    public static void main(String args[]) {

        int[] sample = new int[] {8,4,2,10,3,6,7,9,1};
        int[] result = largestRange(sample);
        System.out.println("[" + result[0] + " " + result[1] + "]");
    }
}
