package search;

public class findFirstOccurenceOfElement {
    public static void main(String args[]){
        int[] elements = {0,0,1,1,1};
        System.out.println("element found at index : " + findFirstOccurenceOfElement(elements,10));
        System.out.println("last Occurence of element : " +findLastOccurenceOfElement(elements,10));
        System.out.println("count num of Occurence of element : "+ countNumofOcuurences(elements,10));
        System.out.println("count num of 1 in binary arr : "+count1inBinaryArray(elements,1));
    }
    //time complexity O(logn)
    private static int findFirstOccurenceOfElement(int[] elements,int num){
        int high = elements.length-1;
        int low =0;

        while(low <=high){ int mid = (high+low)/2;


            if(num > elements[mid]){
                low = mid +1;
            }
            else if(num < elements[mid]){
                high = mid -1;
            } else{
                if(mid == 0 || elements[mid-1] != elements[mid] ){
                    return mid;
                }else{
                    high = mid-1;
                }
            }

        }
        return -1;
    }

    //time complexity O(logn)
    private static int findLastOccurenceOfElement(int[] elements,int num){
        int high = elements.length-1;
        int n =  elements.length;
        int low =0;
        while(low <= high){
            int mid = (low+high)/2;
            if(num > elements[mid]){
                low = mid+1;
            }
            else if(num < elements[mid]){
                high = mid -1;
            }else{
                if(mid == n-1 || elements[mid+1] != elements[mid]){
                    return mid;
                }else{
                    low = mid +1;
                }
            }
        }
        return -1;
    }

    //time complexity O(logn) (lastOccurence - first ) +1
    private static int countNumofOcuurences(int[] elements,int num){
        int first = findFirstOccurenceOfElement(elements,10);
        if(first == -1) return -1;
        else return (findLastOccurenceOfElement(elements,10)-findFirstOccurenceOfElement(elements,10))+1;
    }

    private static int count1inBinaryArray(int[] elements,int num){
        int first = findFirstOccurenceOfElement(elements,1);
        if(first == -1) return -1;
        else
            return ((elements.length-1)-first)+1;
    }

    private static int count1inBinaryArrayEffient(int[] elements){
        int high = elements.length-1;
        int low =0;
        while(low <= high){
            int mid = (low + high)/2;
            if(elements[mid] == 0){
                low = mid +1;
            }else{
                if(mid==0 || elements[mid-1]!=elements[mid]){
                    return elements.length-mid;
                }else{
                    high = mid -1;
                }
            }
        }
        return -1;
    }
}
