/*
* if first and last element of an array is same it means diff count of zero and ones
* ex 001100 -> 2 zero's grp 1 one group
* if first and last element of an array is diff it means same count of zero and ones
 * ex 0011 -> 1 zero's grp 1 one group
 * if you want to make both array same then  always start fliping from 2nd group
* */
// 11000111 00110011
public class MinimumFlipsGroupsToMakeArraySame {
    public static void main(String[] args) {
        int[] elements = {1,0,1,1,0,1};
        minimumFlipsGroupsToMakeArraySame(elements);
    }

    private static void minimumFlipsGroupsToMakeArraySame(int[] elements){
        for(int i = 1 ; i< elements.length;i++){
            if(elements[i-1]!= elements[i]){
                if(elements[i] != elements[0])
                System.out.print("from index " + i +"->");
                else
                    System.out.println(" end index " + (i -1));
            }
        }
        if(elements[elements.length-1] != elements[0])
            System.out.println(" end index " + (elements.length-1));
    }
}
