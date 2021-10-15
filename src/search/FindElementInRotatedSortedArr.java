package search;

public class FindElementInRotatedSortedArr {

    public static void main(String args[]){
        int arr[] = {3,1};
        System.out.println("num found at index : "+search(arr,1));
    }

    public static int search(int[] arr, int target) {//binary search with some changes
        int lo=0;//low
        int hi=arr.length-1;//high
        while(lo<hi){

            int mid = lo+((hi-lo)/2);//middle of the range (lo,hi)
            if(arr[mid]==target){
                return mid;
            }
            if(arr[lo]<=arr[mid]){//we have to check for two sorted halfs
                if(arr[lo]<=target && target<arr[mid]){//we have to check that the target is present in the first sorted half or not
                    hi=mid-1;
                }else{
                    lo=mid+1;
                }
            }else{
                if(arr[mid]<target && target<=arr[hi]){//we have to check that the target is present in second sorted half or not
                    lo=mid+1;
                }else{
                    hi=mid-1;
                }
            }
        }
        return arr[lo]==target ? lo : -1;//lo will reach to the desired index after above iteration
    }
}
