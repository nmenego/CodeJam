package aws.prog;

import java.util.Scanner;

/**
 * Matrix encoding decoding.
 * 
 * @author nicomartin.enego
 *
 */
public class ProgCon22 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tries = Integer.parseInt(in.nextLine());
		for (int count = 0; count < tries; count++) {
			String inputz = in.nextLine();
			doGame(count, inputz);
		}
	}

	private static void doGame(int count, String inputz) {
		String[] arg = inputz.split(", ", 3);
		String enc = arg[0].trim();
		String theString = arg[2].trim();
		int width = Integer.parseInt(arg[1].trim());
		int height = (int) Math.ceil(new Double(theString.length())
				/ new Double(width));
		int ptr = 0;

		String ans = "";
		char[][] matrix = new char[width][height];
		if (enc.equals("D")) {

			// decode
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					if (ptr > theString.length())
						break;
					if (ptr == theString.length()) {
						matrix[i][j] = 'x';
					} else {
						matrix[i][j] = theString.charAt(ptr);
					}
					ptr++;
				}
			}

			for (int x = 0; x < height; x++) {
				for (int y = 0; y < width; y++) {
					ans += matrix[y][x];
				}
			}
		} else {

			// encode
			for (int j = 0; j < height; j++) {
				for (int i = 0; i < width; i++) {
					if (ptr > theString.length())
						break;
					if (ptr == theString.length()) {
						matrix[i][j] = 'x';
					} else {
						matrix[i][j] = theString.charAt(ptr);
					}
					ptr++;
				}
			}

			for (int y = 0; y < width; y++) {
				for (int x = 0; x < height; x++) {
					ans += matrix[y][x];
				}
			}
		}

		System.out.println(ans);
	}
}
