import java.util.*;
class Solution {
    public int maxArea(int[] height) {
        return container(height);
    }

    public int container(int[] height){
        int maxwater=Integer.MIN_VALUE;
        int lp=0;
        int rp=height.length-1;
        while(lp<rp){
            int h=Math.min(height[lp],height[rp]);
            int width=rp-lp;
            int currwater=h*width;
            maxwater=Math.max(currwater,maxwater);
            if(height[lp]<height[rp]){
                lp++;
            }else{
                rp--;
            }
        }
        return maxwater;
    }
}