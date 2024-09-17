package binarySearch;

import java.util.Arrays;

/*
 * Koko Eating Bananas
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. 
The guards have gone and will come back in h hours.
Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. 
If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
Return the minimum integer k such that she can eat all the bananas within h hours.

Example 1:
Input: piles = [3,6,7,11], h = 8
Output: 4

Example 2:
Input: piles = [30,11,23,4,20], h = 5
Output: 30

Example 3:
Input: piles = [30,11,23,4,20], h = 6
Output: 23
 */

public class KokoEatingBananas {

	public static void main(String[] args) {
		int[] piles = {30,11,23,4,20};
		int h = 6;
		int k = minEatingSpeed(piles, h);
		System.out.println(k);
	}

	public static int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        
        for (int num: piles) {
        	max = Math.max(max, num);
        }
        
        int l = 1, r = max;
        
        while (l < r) {
        	int k = (l + r) / 2;
        	if (kWorks(k, piles, h)) {
        		r = k;
        	} else {
        		l = k + 1;
        	}
        }
        
        return r;
    }
	
	public static boolean kWorks(int k, int[] piles, int h) {
		int hrs = 0;
		
		for (int num: piles) {
			double n = num * 1.0 / k;
			hrs += Math.ceil(n);
		}
		
		return hrs <= h;
	}
}
