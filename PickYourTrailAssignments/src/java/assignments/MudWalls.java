package java.assignments;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MudWalls {
 
    public static int maxHeight(int[] stickPositions, int[] stickHeights) {
        int n = stickPositions.length;
        //int m = stickHeights.length;
        int max = 0;
 
        for (int i=0; i<n-1; i++) {
            if (stickPositions[i]<stickPositions[i+1]-1) {
                // We have a gap
                int heightDiff =  Math.abs(stickHeights[i+1] - stickHeights[i]);
                int gapLen = stickPositions[i+1] - stickPositions[i] - 1;
                int localMax = 0;
                if (gapLen > heightDiff) {
                    int low = Math.max(stickHeights[i+1], stickHeights[i]) + 1;
                    int remainingGap = gapLen - heightDiff - 1;
                    localMax = low + remainingGap/2;
 
                } else {
                    localMax = Math.min(stickHeights[i+1], stickHeights[i]) + gapLen;
                }
 
                max = Math.max(max, localMax);
            }
        }
 
        return max;
    }
 
    public static void main(String[] args){
 
        Scanner sc = new Scanner(System.in);
 
        int[] stickPositions=null;
		int[] stickHeights=null;
		try {
			int n = sc.nextInt();
			stickPositions = new int[n];
			for (int i = 0; i < n; i++) {
			    stickPositions[i] = sc.nextInt();
			}
			n = sc.nextInt();
			stickHeights = new int[n];
			for (int i = 0; i < n; i++) {
			    stickHeights[i] = sc.nextInt();
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			sc.close();
		}
 
 
        System.out.println(maxHeight(stickPositions, stickHeights));
    }
}
