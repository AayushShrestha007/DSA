
public class Question1B {
    int minimumCoinCalc(int ratings[]){
        int len= ratings.length;
        int minCoins=0;

        int[] coins= new int[len];

        for(int i=0;i<len;i++){
            coins[i]=1;
        } // Initializing all the coin array with a default of 1. 


        //Comparing the rating left to right
        for(int i=1;i<len;i++){
            if(ratings[i]>ratings[i-1]){
                coins[i]= coins[i-1]+1;
            }
        }

        //Comparing the rating right to left
        for(int i=len-2;i>0;i--){
            if((ratings[i]>ratings[i+1]) && coins[i]<=coins[i+1]){
                coins[i]=coins[i+1]+1;
            }
        }

        for(int i=0;i<len; i++){
            minCoins += coins[i];
        }
        return minCoins;
    }



    public static void main(String[] args) {

        Question1B q= new Question1B();
        int[] ratings= {1,2,4,3,2,1};
        int minCoins= q.minimumCoinCalc(ratings);
        System.out.println(minCoins);

    }
}
