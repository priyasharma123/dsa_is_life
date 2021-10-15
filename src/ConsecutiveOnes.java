public class ConsecutiveOnes {

    public static void main(String[] args) {
        int[] prices = {1, 0, 1, 1, 1,1,0,1,1,1,1,1,1,0};
        System.out.println("water : " + countMaxConsecutive1(prices));
    }

    private static int countMaxConsecutive1(int[] elements){
        int intialCount = 0,finalCount = 0;
        for(int i = 0;i < elements.length; i++){
            if(elements[i] == 1){
                intialCount++;
                finalCount = Math.max(intialCount,finalCount);
            }else{
                intialCount = 0;
            }
        }
        return finalCount;
    }
}
