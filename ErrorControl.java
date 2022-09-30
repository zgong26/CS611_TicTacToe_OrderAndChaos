
/*
 * for handling errors that might occur during a game
 */
import java.util.Scanner;

public class ErrorControl {
	static Scanner in = new Scanner(System.in);

	public static String cellInput(int size) {
		String input = "";
		int num = -1;
		boolean valid = false;
		do {
			input = in.nextLine();
			try {
				num = Integer.parseInt(input);
			} catch (Exception e) {
				System.out.println("Invalid input. \nPlease enter a valid number on the board");
				continue;
			}
			if (num < 1 || num > size) {
				System.out.println("Invalid input. \nPlease enter a valid number on the board");
				valid = false;
			} else
				valid = true;
		} while (!valid);
		return input;
	}

	public static int integerInput(int low, int high) {
		int num = 0;
		boolean valid = false;
		do {
			String str = in.nextLine();
			try {
				num = Integer.parseInt(str);

			} catch (Exception e) {
				System.out.println("Invalid input. \nPlease enter a valid integer between " + low + " and " + high);
				continue;
			}
			if (num >= low && num <= high)
				valid = true;
			else {
				valid = false;
				System.out.printf("Invalid input. \nPlease enter a valid integer between %d and %d\n", low, high);
			}
		} while (!valid);
		return num;
	}

	public static String OCPlace() {
		String input = "";
		boolean valid = false;
		do {
			input = in.nextLine().toUpperCase();
			try {
				String[] arr = input.split(",");
				if (arr.length != 2) {
					System.out.println("Invalid input. \nPlease enter the input in format of (position,chess)");
					continue;
				}
				if ((Integer.parseInt(arr[0]) >= 1 && Integer.parseInt(arr[0]) <= 36)
						&& (arr[1].equals("O") || arr[1].equals("X")))
					valid = true;
				else {
					valid = false;
					System.out.printf(
							"Invalid input. \nChess should be placed on cell 1-36 only, and only O and X are allowed to be placed\n");
				}
			} catch (Exception e) {
				System.out.println("Invalid input. \nPlease enter the input in format of (position,chess)");
				continue;
			}
		} while (!valid);
		return input;
	}

}
