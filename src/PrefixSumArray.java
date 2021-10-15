public class PrefixSumArray {
    public static void main(String[] args) {
        int[] elements = {3,4,8,-9,20,6};// 2 5 9 14 20 27 35 21
       // prefixSumArray(elements,3,6);
        // 3 4 8 -9 20 6  36 3 33 7 29 15 21
        System.out.println("has equi point  " + findArrayHasEquiPoint(elements));
        // 4 2 -2 4 6 4
    }

    /*
    * In this proob we have to find sum of elements from left index to right index
    *
    * */
 private static void prefixSumArray(int[] elements, int l, int r){
        /*find the sum of elements present in the array like first+ sec then first+sec+third*/
     int prefix_sum[] = new int[elements.length];
      prefix_sum[0] =elements[0];
     for(int i=1;i< elements.length;i++){
         prefix_sum[i] = prefix_sum[i-1]+elements[i];
     }
     if(elements.length > 0){
         System.out.println("prefix sum : " + (prefix_sum[r]-prefix_sum[l-1]));
     }
 }

 private static boolean findArrayHasEquiPoint(int[] elements){
     int sum =0;
     for(int i =0; i < elements.length; i++){
         sum += elements[i];
     }
     int l_sum =0;
     for(int i =0 ; i< elements.length ; i++){


         sum-=elements[i];
         if(l_sum == sum) return true;
         l_sum +=elements[i];
     }
     return false;
 }

}
