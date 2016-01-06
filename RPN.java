package SPOJ;

import java.util.Scanner;
import java.util.Stack;

public class RPN {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		String input[] = new String[tc];
		for (int i = 0; i < tc; i++) {
			input[i] = sc.next();
		}

		Stack<String> stack = new Stack<String>();
		for (int j = 0; j < tc; j++) {
			int i = 0;
			StringBuilder sb = new StringBuilder();
			while (i < input[j].length()) {
				if (input[j].substring(i, i + 1).equals(")")) {
					String a = stack.pop();
					String b = stack.pop();
					String c = stack.pop();
					stack.pop();
					String d = c + a + b;
					stack.push(d);
				} else {
					stack.push(input[j].substring(i, i + 1));
				}
				i++;
			}
			System.out.println(stack.pop());
		}
	}
	
}
