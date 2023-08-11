public class Question1A{

    public int getMinimumCost(int[][] price){
        int n= price.length;

        // Initialize the dynamic programming table
        int[][] dp = new int[n][3];
        dp[0][0]= price[0][0];
        dp[0][1]= price[0][1];
        dp[0][2]= price[0][2];

        // Iterate over the remaining rows
        for(int i=1; i<n; i++){

            //Calculate the minimum cost for each color option
            dp[i][0]= price[i][0]+ Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1]= price[i][1]+ Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2]= price[i][2]+ Math.min(dp[i-1][0], dp[i-1][1]);
        }

        // Find the minimum cost from the last row
        int minCost= Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));

        return minCost;


    }

   public static void main(String[] args) {

        Question1A q= new Question1A();

        int[][] price= {{14,4,11}, {11,14,3}, {14,2,10}};
        int minCost = q.getMinimumCost(price);
        System.out.println("Minimum cost is:" + minCost);
    }
}