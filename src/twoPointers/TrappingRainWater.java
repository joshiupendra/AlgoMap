package twoPointers;

/*
 * Trapping Rain Water
Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it can trap after raining.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
In this case, 6 units of rain water (blue section) are being trapped.

Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9
 */

public class TrappingRainWater {

	public static void main(String[] args) {
		int[] height = {4,2,0,3,2,5};
		int result = trap(height);
		System.out.println(result);
	}

	public static int trap(int[] height) {
        int result = 0;
        if (height.length < 2) {
        	return result;
        }
        
        int[] water = new int[height.length];
        int right = height[0], left = 0;
        water[0] = 0;
        
        for (int i=1; i<height.length; i++) {
        	int k = 0;
        	int j = height.length - 1;
        	right = height[0];
        	left = height[j];
        	while (k < i || j > i) {
        		if (k < i) {
        			right = Math.max(height[k], right);
        			k++;
        		}
        		if (j > i) {
        			left = Math.max(height[j], left);
        			j--;
        		}
        		int temp = Math.min(right, left);
        		water[i] = (temp > height[i])? temp - height[i] : 0;
        		
        	}
        	//System.out.println(i + " " + height[i] + " " + right + " " + left + " " + water[i]);
        }
        for (int w: water) {
        	//System.out.print(w + " ");
        	result += w;
        }
        
        return result;
    }
}
