package aws.prog;

import java.util.Scanner;

/**
 * Highest perfect root.
 * 
 * @author nicomartin.enego
 *
 */
public class ProgCon21 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tries = Integer.parseInt(in.nextLine());
		for (int count = 0; count < tries; count++) {
			long inputz = Integer.parseInt(in.nextLine());
			doGame(count, inputz);
		}
	}

	private static void doGame(int count, long inputz) {
		// TODO Auto-generated method stub
		double root = inputz;
		long ans = 1;
		for (long p = 2; p < inputz / 2; p++) {
			double temp = posRoot(inputz, p);
			if (temp == Math.floor(temp) && p > ans) {
				ans = p;
				root = temp;
			}
		}
		System.out.println((long) ans + " (" + (long) root + "^" + (long) ans
				+ ")");
	}

	private static double posRoot(long num, long root) {
		return Math.pow(num, 1.0 / root);
	}

}
