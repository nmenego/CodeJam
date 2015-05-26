package aws.prog;

import java.util.Scanner;

/**
 * Print text vertically
 * 
 * @author nicomartin.enego
 *
 */
public class ProgCon20 {

	static char[][] answer;
	static int longestString = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tries = Integer.parseInt(in.nextLine());
		answer = new char[256][tries];

		for (int count = 0; count < tries; count++) {
			String inputz = in.nextLine();
			doGame(count, inputz);
		}

		for (int count2 = 0; count2 < longestString; count2++) {
			System.out.println(String.valueOf(answer[count2]));
		}
	}

	private static void doGame(int count, String inputz) {
		if (inputz.length() > longestString) {
			longestString = inputz.length();
		}
		for (int i = 0; i < inputz.length(); i++) {
			answer[i][count] = inputz.charAt(i);
		}

	}

}
