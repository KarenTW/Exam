package div.karen;
/* Author: Karen 2017.3.13
 * Description : Q5. Calculate the sum of two integers a and b, but you are not allowed to use the operator + and */
public class CalculateSumWithoutOperator {

	public CalculateSumWithoutOperator() {
	}

	public int getSum(int p, int q)
	{
	    int result = p ^ q; // sum of p and z is XOR
	    int carry = (p & q) << 1;  // shift carry to p AND q
	    if (carry != 0) {
	        return getSum(result, carry);
	    }
	    return result;
	}

	public static void main(String[] args) {
		CalculateSumWithoutOperator sb = new CalculateSumWithoutOperator();
		int param1 = Integer.parseInt(args[0]);
		int param2 = Integer.parseInt(args[1]);
		System.out.println("a = " + param1);
		System.out.println("b = " + param2);
		System.out.println(param1+" + " + param2 + " = " +sb.getSum(param1, param2));
	}
}
