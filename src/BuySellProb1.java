public class BuySellProb1 {
    public static void main(String[] args) {
        int[] prices = {1,5,3,8,12};
        System.out.println("prodfit : " +buyAndSell(prices));
    }

    private static int buyAndSell(int[] prices){
        int profit=0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i-1]){
                profit +=prices[i] - prices[i-1];
            }
        }
        return  profit;
    }
    //1 5 3 8 12
    // 30 20 10
}
