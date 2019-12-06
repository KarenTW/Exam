package div.karen;
/* Author: Karen 2017.3.13
 * Description : Q1. Write a function that takes a string as input and returns the string reversed.  */
public class ReverseString {

	public ReverseString() {
	}

	public String reverse(String originalString) {
		
		//find the char from the string
		char[] in = originalString.toCharArray();
		String result = "";
		
		//for loop to append the char from the end to the front
		for (int i = in.length - 1; i >= 0; i--) {
			result += in[i];
		}
		return result;
	}

	public static void main(String[] args) {
		ReverseString sb = new ReverseString();
		String input = "";
		
		//Append string together
		for(String sr:args){
			input+=sr;
		}
		System.out.println(sb.reverse(input));
	}
}
