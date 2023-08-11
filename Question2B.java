import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Question2B {


    List<Integer> whiteListedPorts;
    Random random;
    
    public Question2B(int k, int[] blackListedPorts){
        whiteListedPorts= new ArrayList<>(); //Using an arraylist to store all white listed port numbers
        random = new Random(); 



        for(int i=0; i<k;i++){
            if(!PresentInBlackList(blackListedPorts, i)){
                whiteListedPorts.add(i); //If the number is not present in black list, it will be added in white list
            }

        }

    

    }

    public int get(){
        int randomIndex= random.nextInt(whiteListedPorts.size()); //generating a random index from the available index range in white list
        return whiteListedPorts.get(randomIndex); 
    }


    boolean PresentInBlackList(int[] arr, int target){
        for(int num:arr){
            if(num==target){
                return true;
            }
        }
        return false;
    } //this function uses for each loop to checks if the given number (target) is available in the given array (arr) or not.

    public static void main(String[] args) {
       int[] blackListedPorts= {2,3,5};
       int k=7;
       Question2B q= new Question2B(k, blackListedPorts);
       System.out.println(q.get());
       System.out.println(q.get());
       System.out.println(q.get());
       System.out.println(q.get());
    
    }
    
}
