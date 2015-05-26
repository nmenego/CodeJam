package aws.prog;

import java.util.Scanner;

/**
 * Translating input to variable formats
 * 
 * @author nicomartin.enego
 *
 */
public class ProgCon19 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tries = Integer.parseInt(in.nextLine());
		for (int count = 0; count < tries; count++) {
			String inputz = in.nextLine();
			doGame(inputz);
		}
	}

	public static void doGame(String text) {
		String[] textz = text.split("\\s");
		String out = "";
		if (textz[0].equals("0")) {
			out = textz[1];
			for (int i = 2; i < textz.length; i++) {
				out = out + textz[i].substring(0, 1).toUpperCase()
						+ textz[i].substring(1);
			}
		} else if (textz[0].equals("1")) {
			for (int i = 1; i < textz.length; i++) {
				if (i == textz.length - 1) {
					out = out + textz[i];
				} else {
					out = out + textz[i] + "_";
				}
			}
		} else {
			for (int i = 1; i < textz.length; i++) {
				if (i == textz.length - 1) {
					out = out + textz[i].toUpperCase();
				} else {
					out = out + textz[i].toUpperCase() + "_";
				}
			}
		}
		System.out.println(out);
	}
}
