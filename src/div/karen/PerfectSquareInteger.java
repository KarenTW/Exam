package div.karen;
/* Author: Karen 2017.3.13
 * Description : Q2. Given a positive integer num, write a function which returns True if num is a perfect square else False. */
public class PerfectSquareInteger {

	public PerfectSquareInteger() {
	}

	public boolean PerfectSquare(int number) {
		// 1 is perfect square, return true, return false for the negative integer and 0
		if (number == 1) {
			return true;
		} else if (number < 1) {
			return false;
		}

		// define the smallest square to currentSquare : 4, and current number: 2
		long currentSquareNumber = 4;
		long currentNumber = 2;

		// for loop to calculate the number until number is equal or more than currentSquareNumber
		while (currentSquareNumber <= number) {
			if (currentSquareNumber == number){
				return true;
			}
			// increment current number
			currentNumber ++;
			// set the currentSquareNumber to currentNumber square.
			currentSquareNumber = currentNumber * currentNumber;
		}

		// no match
		return false;
	}

	public static void main(String[] args) {
		PerfectSquareInteger ps = new PerfectSquareInteger();
		try {
			System.out.println(ps.PerfectSquare(Integer.parseInt(args[0])));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
