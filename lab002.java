import java.util.*;

/**
 * Lab 002 
 * @version 1.0
 * @author Sanghwan Lee
 * @id 20181234
 */

class LabTest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(true) {
			System.err.println("Enter n m : ");
			int n = in.nextInt();
			int m = in.nextInt();
			if(n == 0) 
				break;

			System.out.println("Combination(" +  
				n + ", " + m + ") : " + 
				Combi(n, m));
		}
	}
	static int Combi(int n, int m) {
		System.out.println("Combi(" + n + ", " + m + ")");
		if(m == 0 || n == m){
			return 1;
		}
		else {
			return Combi(n-1,m) + Combi(n-1, m-1);
		}
	}
}

