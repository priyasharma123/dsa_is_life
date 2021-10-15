package search;

public class BinarySearchIterativeAppr {
    public static void main(String args[]){
        int[] elements = {2,3,4,7,8,10,45,90};
        System.out.println("element found at index : " + binarySearch(elements,10));
        System.out.println("element found at index : " + binarySearchRecursive(elements,90,0,elements.length));
        System.out.println("element found at index : " + binarySearchEffi(elements,45));
        //
    }
   // O(logn) auxillary space O(1)
    private static int binarySearch(int[] elements,int num){
        int size = elements.length;int left =0;
        int mid =  size/2;
        int right = mid+1;
        if(elements[mid] == num){
           return mid;
        }
        if(num < elements[mid]) {
            while (left < mid) {
                if (elements[left] == num) {
                    return left;
                }
                left ++;
            }
        } else {

            while (right < size) {
                if (elements[right] == num) {
                    return right;
                }
                right ++;
            }
        }
        return -1;
    }

    //binaey search complexity depends upon hieght of tree
    // 2 3 45 67 8 make a tree of it so complexity will be height of tree
    /*  45
        | |
        3  67
        |   |
        2   8
*/
    private static int binarySearchEffi(int[] elements,int num){
        int high = elements.length;int low =0;

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

//O(logn) auxillary space O(logn)
    private static int binarySearchRecursive(int[] elements,int num,int low , int high){
        int mid = (low+high)/2;
        if(low >= high) return  -1;
        if(elements[mid] == num) return mid;
        else if(num < elements[mid] ){
            return binarySearchRecursive(elements,num,low,mid);
        }else{
            return binarySearchRecursive(elements,num,mid+1,high);
        }
    }


}
