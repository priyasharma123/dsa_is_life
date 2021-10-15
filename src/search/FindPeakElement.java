package search;

public class FindPeakElement {
    public static void main(String args[]){
        int arr[] = {80,70,90};
        System.out.println("num found at index : "+findPeakElement(arr));
        System.out.println("num found at index : "+findPeakElementEffi(arr));
    }
//A peak element is an element that is strictly greater than or equal to its neighbors.
    public static int findPeakElement(int[] arr){
        if(arr.length == 1) return arr[0];
        if(arr[0] >= arr[1]) return arr[0];
        if(arr[arr.length-1] >= arr[arr.length-2]) return arr[arr.length-1];
        for(int i = 1;i < arr.length-1;i++){
            if(arr[i-1]  <= arr[i] && arr[i] >=arr[i+1]) return arr[i];
        }
        return -1;
    }

    //efficient approach
    public static int findPeakElementEffi(int[] arr){
        int low =0;
        int high = arr.length-1;
        int n = arr.length-1;
        while(low <= high){
            int mid = (low+high)/2;
            if((mid ==0 || arr[mid-1] <= arr[mid]) && (mid ==n-1 || arr[mid+1] <= arr[mid])) return mid;
            if(mid > 0 && arr[mid-1] >= arr[mid]) high = mid-1;
            else low = mid+1;
        }
        return -1;
    }

}
