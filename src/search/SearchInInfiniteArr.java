package search;

public class SearchInInfiniteArr {
    public static void main(String args[]){
        int arr[] = {12,34,56,78,900,901,8990,9990,66665,66668,66669,777777,888888,999999,10000000,444444444,555555555,666666666,777777777,888888888,999999999};
        System.out.println("num found at index : "+findNumInAnInfiteArr(arr,66669));
    }

    //complexity O(log(indexofelement)) //unbounded binary search
    private static int findNumInAnInfiteArr(int[] arr,int num){
        int i=1;
        if(arr[0] == num ) return 0;
        while(arr[i] < num){ i = i*2;}
        if(arr[i] == num) return i;
        return binarySearchEffi(arr,num,(i/2)+1,i-1);
    }

    private static int binarySearchEffi(int[] elements,int num,int low,int high){

        while (low < high){
            int mid =  (low+high)/2;
            if(elements[mid] == num) return mid;
            else if (num < elements[mid]) {
                high = mid;
            }
            else{
                low = mid +1;
            }
        }
        return -1;
    }
}
