public class MaximumSubArray {
    public static void main(String[] args) {
        int[] elements = {1,2,4,1,6};
        System.out.println("max sum : " + maximumEvenOddlen(elements));

    }

    private static int maximumSubArray(int[] elements) {
        int maxEnding = elements[0],res = elements[0];
        for(int i =1;i< elements.length;i++){
           maxEnding = Math.max(maxEnding+elements[i],elements[i]);
           res = Math.max(res,maxEnding);
        }
        return  res;
    }
    private static int maximumEvenOddlen(int[] elements) {
        int count =1,maxCount=1;
        for(int i =1;i< elements.length;i++){
            if(((elements[i]%2==0 )&& (elements[i-1]%2!=0)) || (elements[i]%2!=0 )&& (elements[i-1]%2==0)){
                count++;
                maxCount = Math.max(count,maxCount);
            }
            else count =1;

        }
        return maxCount;
    }

}
