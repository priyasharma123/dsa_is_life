/**
 * Majority element element which is present in array more than length/2 times i.e (length/2)+1
 * **/

public class MajorityElement {
    public static void main(String[] args) {
        int[] elements = {1,5,1,1,6,1};
        System.out.println("majority number index : " + majorityElementEffi(elements));
    }

    private static int majorityElement(int[] elements){
        int length = (elements.length/2),index=0;
        for(int i =0;i  <elements.length;i++ ){
           int countNum=1;
            for(int j =i+1;j  <elements.length;j++ ){
                if(elements[i] == elements[j]){
                    countNum++;
                }
            }
            if(countNum > length){
                return i;
            }
        }

        return -1;
    }

    private static int majorityElementEffi(int[] elements){
        int res = 0,count =1;
        for(int i=1;i < elements.length; i++){
            if(elements[res] == elements[i]){
                count++;
            }
            else{
                count--;
            }
            if(count == 0){
                count = 1 ; res =i;
            }
        }
        count = 0;
        for (int j = 0 ; j < elements.length;j++){
            if(elements[j] == elements[res]){
                count++;
            }

        }
        if(count <=( elements.length/2)) return -1;
        return res;
    }
}

