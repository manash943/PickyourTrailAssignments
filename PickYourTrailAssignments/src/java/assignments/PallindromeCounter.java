package java.assignments;

import java.util.Scanner;

public class PallindromeCounter {

public int getPallindromeCounter(String s) {
		
		char str[] = s.toCharArray();
		int count =0;
		int n = str.length;
		int a[][] = new int [n][n];
		for(int i=0;i<n ; i++) {
			
			a[i][i]= 1;
			count ++;
			
		}
		for(int size=2; size<=n;size++) {
			
			for(int i=0;i<=n-size;i++) {
				
				int j= i+size-1;
				if(str[i]==str[j]) {
					
					a[i][j] = Math.max(Math.max(a[i][j-1], a[i+1][j]), a[i+1][j-1])+1;
				
					if(a[i][j] >0) {
						count ++;
					}
					
					
				}else {
					a[i][j] =0;
				}
			}
			
		}
		
		return count;
		
	}

public static void main(String args[]) {
	
	Scanner sc= null;
	try {
		sc= new Scanner(System.in);
		String inputString=sc.nextLine();
		PallindromeCounter pc= new PallindromeCounter();
		System.out.println(pc.getPallindromeCounter(inputString));
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		sc.close();
	}
	
}
	
}
