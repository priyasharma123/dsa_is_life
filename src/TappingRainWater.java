public class TappingRainWater {
    public static void main(String[] args) {
        int[] prices = {3, 0, 1, 3, 5}; //2+3=5 // 3 3 3 3 5 //5 5 5 5 5 //0 3 2 0
        System.out.println("water : " + tappingRainWaterSmart(prices));
    }

    //2 0 2 // 3 0 1 2 5
    private static int tappingRainWater(int[] pillars) {
        int length = pillars.length;
        int result = 0, lMax, rMax;
        for (int i = 1; i < length - 1; i++) {
            lMax = pillars[i];
            rMax = pillars[i];
            for (int j = 0; j < i; j++) {
                lMax = Math.max(lMax, pillars[j]);
            }
            for (int k = i + 1; k < length; k++) {
                rMax = Math.max(rMax, pillars[k]);
            }
            result = result + (Math.min(lMax, rMax) - pillars[i]);
        }
        return result;
    }

    private static int tappingRainWaterSmart(int[] pillars){
        int result = 0;
        int length = pillars.length;
        int lmax[] = new int[length];
        int rMax[] = new int[length];
        lmax[0] = pillars[0];
        rMax[length-1] = pillars[length-1];
        for(int i = 1; i < length; i++){
            lmax[i] = Math.max(lmax[i-1],pillars[i]);
        }

        for(int i = length-2; i >=0; i--){
            rMax[i] = Math.max(lmax[i+1],pillars[i]);
        }

        for(int i = 0; i < length; i++){
            result = result+ (Math.min(lmax[i],rMax[i])-pillars[i]);
        }
        return result;
    }
}

