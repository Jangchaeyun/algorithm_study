import java.util.*;
import java.io.*;

public class Main {
    
	static int N;
	static char[][][] block;
	
	static boolean[][] impossibleNum;
	
	static double sum;
	static double now;
	static double cnt;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(br.readLine());
    	
    	block = new char[N][5][3];
    	
    	for(int t=0; t<5; t++) {
    		String line = br.readLine();
    		
    		int n=0;
    		int k=0;
    		int j=0;
    		while(k < 3*N + N-1) {
    			char c = line.charAt(k);
    			
    			if(k % 4 == 3) { 
    				k++;
    				continue;
    			}
    			
    			if(j > 2) {
    				j = 0;
    				n++;
    			}
    			
    			block[n][t][j] = c;
    			j++;
    			k++;
    		}	
    	}
    	
    	impossibleNum = new boolean[N][10];
    	
    	for(int n=0; n<N; n++) {
    		for(int i=0; i<5; i++) {
    			for(int j=0; j<3; j++) {
    				if(block[n][i][j] == '#') {
    					check(n, i, j);
    				}
    			}
    		}
    	}

    	sum = 0;
    	now = 0;
    	cnt = 1;    	
    	
    	answer();

    	double ans = sum / cnt;
    	System.out.println(ans);
    }
    
    static void answer() {
    	double numCnt = 0;
    	double numSum = 0;
    	double totalCnt = 1;
    	
    	for(int n=0; n<N; n++) {
    		for(int i=0; i<10; i++) {
    			if(!impossibleNum[n][i]) {
    				numCnt++;
    			}
    		}
    		totalCnt *= numCnt;
    	}

    	int multi = 1;
    	for(int i=1; i<N; i++) {
    		multi *= 10;
    	}
    	for(int n=0; n<N; n++) {
    		numCnt = 0;
    		numSum = 0;
    		for(int i=0; i<10; i++) {
    			if(impossibleNum[n][i]) continue;
    			
    			numCnt++;
    			
    			numSum += i * multi;    			
    		}
    		
    		double a = totalCnt / numCnt;
    		
    		sum += numSum * a;
    		
    		multi /= 10;
    	}

    	cnt = totalCnt;
    }
    
    static void check(int n, int i, int j) {
    	switch(i) {
	    	case 0:
	    		if(j == 0) {
	    			impossibleNum[n][1] = true;
	    		}
	    		if(j == 1) {
	    			impossibleNum[n][1] = true;
	    			impossibleNum[n][4] = true;
	    		}
	    		if(j == 2) {
	    			
	    		}
	    		break;
	    	case 1:
	    		if(j == 0) {
	    			impossibleNum[n][1] = true;
	    			impossibleNum[n][2] = true;
	    			impossibleNum[n][3] = true;
	    			impossibleNum[n][7] = true;
	    		}
	    		if(j == 1) {
	    			System.out.println(-1);
	    			System.exit(0);
	    		}
	    		if(j == 2) {
	    			impossibleNum[n][5] = true;
	    			impossibleNum[n][6] = true;
	    		}
	    		break;
	    	case 2:
	    		if(j == 0) {
	    			impossibleNum[n][1] = true;
	    			impossibleNum[n][7] = true;
	    		}
	    		if(j == 1) {
	    			impossibleNum[n][0] = true;
	    			impossibleNum[n][1] = true;
	    			impossibleNum[n][7] = true;
	    		}
	    		if(j == 2) {
	    			
	    		}
	    		break;
	    	case 3:
	    		if(j == 0) {
	    			impossibleNum[n][1] = true;
	    			impossibleNum[n][3] = true;
	    			impossibleNum[n][4] = true;
	    			impossibleNum[n][5] = true;
	    			impossibleNum[n][7] = true;
	    			impossibleNum[n][9] = true;
	    		}
	    		if(j == 1) {
	    			System.out.println(-1);
	    			System.exit(0);;
	    		}
	    		if(j == 2) {
	    			impossibleNum[n][2] = true;
	    		}
	    		break;
	    	case 4:
	    		if(j == 0) {
	    			impossibleNum[n][1] = true;
	    			impossibleNum[n][4] = true;
	    			impossibleNum[n][7] = true;
	    		}
	    		if(j == 1) {
	    			impossibleNum[n][1] = true;
	    			impossibleNum[n][4] = true;
	    			impossibleNum[n][7] = true;
	    		}
	    		if(j == 2) {
	    			
	    		}
	    		break;
    	}
    }
}