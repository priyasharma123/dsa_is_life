package search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class findNumInPairofSum {
    public static void main(String args[]){
        int arr[] = {1,2,3,34,45,100};
        int unsorted[] = {3,4,0,1,3};
        findNumInPairofSumInSortedArr(arr,37);
        findNumInPairofSumInUnSortedArr(unsorted,6);
        findNumInTripletofSumInSortedArr(unsorted,7);
    }

    private static void findNumInPairofSumInSortedArr(int[] arr,int num){
        int left =0 ,right = arr.length-1;
        while(left <= right){
            if((arr[left]+arr[right]) == num) {System.out.println("found pair at index " + left + " element is : " + arr[left]
                    + " at index  : "+right+" element is : " + arr[right]  + " sum is : " + num);
            break;
            }
            else if((arr[left]+arr[right]) > num){ right--;}
            else{left++;}
        }
    }

    private static void findNumInPairofSumInUnSortedArr(int[] arr,int num){
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i =0; i < arr.length;i++){
            int temp = num - arr[i];
            if(hashMap.containsKey(temp)){
                System.out.println("found pair at index " + i + " element is : " + arr[i]
                        + " at index  : "+hashMap.get(temp)+" element is : " + temp  + " sum is : " + num);
                break;
            }
            hashMap.put(arr[i],1);
        }
    }

    private static boolean findNumInPairofSumInSortedArr(int[] arr,int left,int right,int num){
        while(left <= right){
            if((arr[left]+arr[right]) == num) {System.out.println("found triplet at index " + left + " element is : " + arr[left]
                    + " at index  : "+right+" element is : " + arr[right]);
                return true;
            }
            else if((arr[left]+arr[right]) > num){ right--;}
            else{left++;}

        }
        return false;
    }

    //it is better for both sorted and unsorted array bcoz hashing takes O(n2) + O(n)-> storage space two pointer approach takes only O(n2) and no extra space
    private static void findNumInTripletofSumInSortedArr(int[] arr,int num){
        for(int i =0; i < arr.length;i++){
            if(findNumInPairofSumInSortedArr(arr,i+1,arr.length-1,num-arr[i])){
                System.out.println("index is :  " + i + " element is : "+arr[i]);
            }
        }
    }

//221 321
//    [12,13,23,28,43,44,59,60,61,68,70,86,88,92,124,125,136,168,173,173,180,199,212,221,227,230,277,282,306,314,316,321,325,328,336,337,363,365,368,370,370,371,375,384,387,394,400,404,414,422,422,427,430,435,457,493,506,527,531,538,541,546,568,583,585,587,650,652,677,691,730,737,740,751,755,764,778,783,785,789,794,803,809,815,847,858,863,863,874,887,896,916,920,926,927,930,933,957,981,997]
  //          542

}
