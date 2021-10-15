public class ArrayOperations {
    public static void main(String[] args) {
        int[] elements = {10,10,20,20,30,30,40,40};
        System.out.println("Largest element in an  array : " + findLargestElementInArr(elements));
        System.out.println("Second Largest element in an  array : " + findSecondLargestElementInArr(elements));
        System.out.println("total length of array : " + elements.length);
        System.out.println("max diff is  : " +countMaximumDiffEffi(elements));
        //leaderInArr(elements);

        leaderInArrEfficient(elements);
        printFreq(elements);
//        int[] rotatedArrByD = leftRotateArrayByN(elements,4);
//        for(int i =0;i<rotatedArrByD.length ; i++){
//
//            System.out.println( rotatedArrByD[i]);
//        }
//        int[] rotatedArr = leftRotateAnArrayByOne(elements);
//        for(int i =0;i<rotatedArr.length ; i++){
//
//            System.out.println( rotatedArr[i]);
//        }
//
//        int[] removeZero = removeZeroFromArray(elements);System.out.println("removed sero : ");
//        for(int i =0;i<removeZero.length ; i++){
//
//            System.out.println( removeZero[i]);
//        }
//
//        int[] nonDups = removeDuplicates(elements);
//        System.out.println("removed duplicates : ");
//        for(int i =0;i<nonDups.length ; i++){
//
//            System.out.println( nonDups[i]);
//        }
//        int[] res = reverseAnArray(elements);
//        System.out.println("reverse of array : ");
//        for(int i =0;i<res.length ; i++){
//
//            System.out.println( res[i]);
//        }

//        System.out.println("element is deleted at pos  : " + deleteAnElement(elements,6,4));
//        System.out.println("element is deleted at pos  : " + deleteAnElement(elements,6,2));
//        System.out.println("element is deleted at pos  : " + deleteAnElement(elements,6,5));
//        System.out.println("element is deleted at pos  : " + deleteAnElement(elements,6,8));
//        System.out.println("element is deleted at pos  : " + deleteAnElement(elements,6,6));
//        System.out.println("element is deleted at pos  : " + deleteAnElement(elements,6,1));
//        System.out.println("element is deleted at pos  : " + deleteAnElement(elements,6,5));
        System.out.println("Array is sorted  : " + checkArrayIsSorted(elements));
        System.out.println("total length of array : " + elements.length);
    }

    private static void printFreq(int[] arr) {
        int size = arr.length;
        int i = 1, freq = 1;
        while (i < size) {
            while (i < size && (arr[i] == arr[i - 1])) {
                freq++;
                i++;
            }
            System.out.println("Frequency of element : " + arr[i-1] + " : " + freq);
            i++;
            freq = 1;
        }
        if (size == 1 || arr[size - 1] != arr[size - 2])
            System.out.println("Frequency of element : " + arr[size - 1] + " : " + freq);
    }
    private static void leaderInArr(int[] arr) {
        int size = arr.length;

        for (int i = 0; i < size; i++) {
            boolean flag = false;

            for (int j = i + 1; j < size; j++) {
                if (arr[i] <= arr[j]) {
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                System.out.println(arr[i]);
            }
        }
    }

    private static int countMaximumDiff(int[] arr){
        int maxDiff =0,diff=0;
        for(int i = 0; i < arr.length-1 ; i++){
            for(int j = 1; j < arr.length ; j++){
                if(arr[j] > arr[i] )
                diff = arr[j] -arr[i];
                if(diff > maxDiff)
                    maxDiff = diff;
            }
        }
        return maxDiff;
    }

    private static int countMaximumDiffEffi(int[] arr){
        int maxDiff =arr[1]-arr[0],minVal=arr[0];
            for(int j = 1; j < arr.length ; j++){
                maxDiff = Math.max(maxDiff,arr[j]-minVal);
                minVal = Math.min(minVal,arr[j]);

        }
        return maxDiff;
    }
//int[] elements = {30,10,20,7,30,8,12};
    private static void leaderInArrEfficient(int[] arr) {
        int size = arr.length;
        int curr_leader = arr[size - 1];
        System.out.println(curr_leader);
        for (int i = size - 2; i >= 0; i--) {
            if (curr_leader < arr[i]) {
                curr_leader = arr[i];
                System.out.println(curr_leader);
            }

        }
    }
    private static int[] leftRotateArrayByNBetterApproach(int[] array,int length, int n){
        reverseArr(array,0,n-1);
        reverseArr(array,n,length-1);
        reverseArr(array,0,length-1);
        return array;
    }

    private static void reverseArr(int[] array,int low, int high){
        while(low < high){
            swap(array[low],array[high]);
            low ++;
            high--;
        }
    }

    private static  void swap(int num1, int num2){
        int temp = num1;
        num1 = num2;
        num2 = temp;
    }
    private static int [] leftRotateAnArrayByOne(int[] array){
        int temp = array[0];
        int len = array.length;
        for(int i = 1; i < array.length; i++){
            array[i-1] = array[i];
        }
        array[len-1] = temp;
        return array;
    }

    private static int[] leftRotateArrayByN(int[] array,int n){
        int[] temp = new int[n];
        for(int i = 0; i < n;i++){
            temp[i] = array[i];
        }
        int i =0;
        for(int j = n; j < array.length; j ++){
            array[i] = array[j];
            i++;
        }
        int j =0;
        for(int k =array.length-n;k < array.length;k++){
            array[k] =temp[j];
            j++;
        }
        return array;
    }
    private static int[] removeZeroFromArray(int[] array){
        int res = 0;
        for(int i = 0 ; i  < array.length; i++){
            if( (array[i] !=0)){
                array[res] = array[i];
                res++;
            }else{
                array[i] = 0;
            }
        }
        return array;
    }
    private static int[] removeDuplicates(int[] array){
        int res = 1;
        for(int i = 1 ; i  < array.length; i++){
                if(array[i] != array[res-1]){
                    array[res] = array[i];
                    res++;
                }
        }
        System.out.println("total duplicates removed : " + (array.length-res));
        return array;
    }
    private static boolean insertArray(int arr[], int size, int index, int element) {
        return false;
    }

    private static int countCapacity(int arr[]) {
        int capacity = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 0) {
                capacity ++;
            } else if (arr[i] != 0) {
                capacity = arr.length - capacity;
                if(arr.length == capacity){return 0;}

            }
        }

        return capacity;
    }

    private static int deleteAnElement(int[] arr,int capacity,int element){
        int index = -1;
        if(arr[capacity-1] == element) return capacity-1;
        for(int i = 0; i < capacity-1 ; i++){
            if(arr[i] == element){
                index = i;
                break;
            }
        }

        if(index == capacity) return capacity-1;
        for(int j = index; j < capacity-1 && j !=-1; j++){
            arr[j] = arr[j+1];
        }
        return index;
    }
//{20,10,6};
    private static int findLargestElementInArr(int[] array){
        int  maxElement = 0 ;
        for(int i = 1; i < array.length; i++){
            if(array[maxElement] < array[i]){
                maxElement = i;
            }
        }
        return maxElement;
    }

    private static int findSecondLargestElementInArr(int[] array) {
        int largest = 0;
        int secondLargest = 0, index = -1;
        for(int i =1; i< array.length; i++){
            if(array[i] > array[largest]){
                index = largest;
                largest = i;
            }
            if(array[i] != array[largest]){
                if(index == -1 || array[i] > array[index]){
                    index = i;
                }
            }
        }
        return index;
    }
//10 20 30 40
    private static boolean checkArrayIsSorted(int[] array){
        boolean res = true;
        for (int i =0; i < array.length-1; i++){
                if( array[i] > array[i+1]) res = false;

        }
        return res;
    }

    private static int[] reverseAnArray(int[] arr ){
        int low =0, high = arr.length-1;
        while(low < high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low ++;
            high --;
        }
        return arr;
    }
}
