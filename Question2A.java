import java.util.Arrays;
import java.util.Collections;

public class Question2A {


    int longestDecreasingSubsequence(int[] nums, int k){

        int len =nums.length;

        int dp[]= new int[len];
        for(int i=0; i<len;i++){
            dp[i]=1;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] < nums[j] && nums[j] - nums[i] <= k) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLength=1;

        Arrays.sort(dp);
        maxLength=dp[len-1];
        return maxLength;



    }


    public static void main(String[] args) {
        
        int[] nums = {8, 4, 5, 2, 1, 4, 3, 4, 3, 1, 15};
        int k = 3;
        Question2A q= new Question2A();
        System.out.println(q.longestDecreasingSubsequence(nums, k));
        
    }
    
}
