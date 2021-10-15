package search;

public class SquareRootFunction {
    public static void main(String args[]){
        int arr[] = {12,34,56,78,900,901,8990,9990,66665,66668,66669,777777,888888,999999,10000000,444444444,555555555,666666666,777777777,888888888,999999999};
        System.out.println("square root of num : "+ squareRootFun(144));
    }

    private static int squareRootFun(int num){
        int ans =0;
        int high = num;
        int low =1;
        while(low <= high){
            int mid = (low+high)/2;
            int sqans = mid * mid;
            if(sqans == num){
                return mid;
            }else if(sqans > num){
                high = mid-1;
            }else{
                low = mid+1;
                ans =mid;
            }
        }
        return ans;
    }


}
