package SPOJ;

import java.util.Arrays;
import java.util.Scanner;

public class SmallFactorial {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		int input[] = new int[tc];
		
		for(int i=0;i<tc;i++){
			input[i] = sc.nextInt();
		}
		
		
		
		for(int i=0;i<tc;i++){
			int output [] = new int[1];
			output[0] = 1;
			
			for(int j=2;j<=input[i];j++){
				output = findFactorial(output,j);
			}
			String result = "";
			for(int k=output.length-1;k>=0;k--){
				result = result + output[k];
			}
			System.out.println(result);
		}
	}

	private static int[] findFactorial(int[] output, int item) {
		
		
		int carry=0;
		
		for(int i=0;i<output.length;i++){
			int sum = output[i]*item+carry;
			output[i] = sum%10;
			carry = sum/10;
		}
		
		if(carry>0){
			int index=0;
			int newcarry = carry;
			
			while(carry>0){
				carry = carry/10;
				index++;
			}
			
			int newoutput[]  = new int[output.length+index];
			
			for(int i=0;i<output.length;i++){
				newoutput[i] = output[i];
			}

			for(int i=output.length;i<output.length+index;i++){
				newoutput[i] = newcarry%10;
				newcarry = newcarry/10;
			}
			return newoutput;
		}
		
		return output;
	}
}
