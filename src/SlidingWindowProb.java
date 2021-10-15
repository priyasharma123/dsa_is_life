/**
 * find the sum of kth element in an array then add other k elements in this way find the max sum
 * **/
public class SlidingWindowProb {
    public static void main(String[] args) {
        int[] elements = {3, 0, 1, 3, 5,6}; //2+3=5 // 3 3 3 3 5 //5 5 5 5 5 //0 3 2 0
        System.out.println("max sum of kth element : " + slidingWindowProb(elements,3));
        System.out.println("max sum of kth element : " + slidingWindowProbEffi(elements,3));
        System.out.println("max sum of kth element : " + findElementInKthSubArray(elements,3,4));
        System.out.println("max sum of kth element : " + findIfNumThereInSubArray(elements,11));
        int[] ele = NBonnaciProblem(3,10);
        for(int i = 0; i< ele.length;i++){
            System.out.print(" " + ele[i]);
        }

    }

    private static int slidingWindowProb(int[] elements,int k) {
        int sum = 0,maxSum=0;
        for(int i = 0; i<= elements.length-k;i++){
            sum =0;
            for(int j=i;j < i+k;j++){
                sum = sum + elements[j];
                maxSum = Math.max(sum,maxSum);
            }
        }
        return maxSum;
    }

    /* here we are adding kth element then we traverse from k element add next element and add substract the i-k i.e previous first element and find max sum
    * */
    private static int slidingWindowProbEffi(int[] elements,int k) {
        int sum = 0,maxSum=0;
        for(int i = 0; i<k;i++) {
            sum += elements[i];
        }
            for(int j=k;j < elements.length;j++){
                sum = (sum + elements[j]) - elements[j-k];
                maxSum = Math.max(sum,maxSum);
            }

        return maxSum;
    }

    /* find if given num  present in the sum of kth subarray
     * */
    private static boolean findElementInKthSubArray(int[] elements,int k,int num) {
        int sum = 0;
        for(int i = 0; i<k;i++) {
            sum += elements[i];
            if(sum == num) return true;
        }
        for(int j=k;j < elements.length;j++){
            sum = (sum + elements[j]) - elements[j-k];
            if(sum == num) return true;
        }

        return false;
    }

    private static boolean findIfNumThereInSubArray(int[] elements,int num){
        int size = elements.length, curr_sum = elements[0],s =0;
        for(int i = 1; i< size;i++){
            while(curr_sum > num && (s < i-1)){
                curr_sum -= elements[s]; s++;
            }
            if(curr_sum == num) return true;
            if(i < size) {
                curr_sum += elements[i];
                if (i == size - 1) {
                    while (curr_sum > num && (s < i - 1)) {
                        curr_sum -= elements[s];
                        s++;
                    }
                }
            }
            System.out.println("i value : " + i);
        }

        return curr_sum == num;
    }

    /*
    * similar like fibonnaci just here we have to print sum of N numbers, m : how many num u want to print
    * */ // 0 0 1
    private static int[] NBonnaciProblem(int n,int m){
        int arr[] = new int[m];
        int i =0,j =0;
        while(i < n && i < m){
            if(i == n-1){arr[i] = 1;}
            else arr[i] = 0;
            i++;
        }
        for(int k = n; k < m ; k++){
            int b =k-n, sum =0;
            for(int Z =0; Z < n ;Z++){
              sum +=arr[b];
              b++;
            }
            arr[k] = sum;
        }
        return arr;
    }
}
