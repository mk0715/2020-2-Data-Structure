import java.util.*;

/**
 * Lab 001 
 * @version 1.0
 * @author Sanghwan Lee
 */

class LabTest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(true){
			System.err.print("echo > ");
			String cmd = in.next();
			if(cmd.equals("quit"))
				break;
			System.out.println(cmd + " !!");
		}

		in.close();	
	}
}
