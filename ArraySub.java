package SPOJ;
import java.util.ArrayDeque;
import java.util.Scanner;

public class ArraySub {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int input[] = new int[len];
		for(int i=0;i<input.length;i++){
			input[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		
		//initialize a dequeue
		//we maintain a dequeue in sorted order from front to rear in decreasing order
		//we remove useless element we only keep elements from current window
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		int i=0;
		for(i=0;i<k;i++){
			while(!queue.isEmpty() && input[queue.peekLast()]<=input[i])
				queue.pollLast();

			queue.add(i);
		}
		/*7 
		1 2 8 4 5 2 3 
		4 */
		for(;i<len;i++){
			System.out.print(input[queue.getFirst()]+" ");
			
			//all elements left/out of window
			while(!queue.isEmpty() && queue.getFirst()<=i-k)
				queue.pollFirst();
			
			//if current element is greater then front element
			while(!queue.isEmpty() && input[queue.getLast()]<=input[i])
				queue.pollLast();
			
			queue.add(i);
		}
		System.out.print(input[queue.getFirst()]);
	}
}
