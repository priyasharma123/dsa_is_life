package search;


/* Array size n greate rthan eqaul 2
only one element repeats (any number one time)
all elemnt zero to max are present
0 <= max(element) <= n-2
 */
public class RepeatingElement {
    public static void main(String args[]){
        int arr[] = {1,0,2,3,4,5,2};
        System.out.println("found repeating element : " + findRepeatingElement(arr));
    }
    //effiecient approach
    //time : o(n) space O(n)
    //array contains element which contains max element  less than n-2 and elements present like index only
    private static int findRepeatingElement(int arr[]){
        int size = arr.length;
        boolean[] visted = new boolean[size];
        for(int i=0;i < size; i++){
            if(visted[arr[i]]) return  arr[i];
            visted[arr[i]] = true;
        }
        return -1;
    }
}
