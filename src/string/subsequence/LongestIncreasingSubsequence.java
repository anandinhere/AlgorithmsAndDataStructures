package string.subsequence;

public class LongestIncreasingSubsequence {


    public static void main(String[] args) {

        int[] arr = new int[]{100,101,1,2,3,4,5};

        System.out.println( getLIS(arr,0,0,Integer.MIN_VALUE) );

    }


    //2 changing params prev and start. so O(mn)
    private static int getLIS(int[] arr, int start, int count, int prev) {

        if(start==arr.length){
            return count;
        }

        int count1 = 0;
        if(arr[start]>prev){
            count1 = getLIS(arr,start + 1,count + 1, arr[start]);
        }
        int count3 = getLIS(arr,start + 1,count, prev);

        return Math.max(count1,count3);

    }
}
