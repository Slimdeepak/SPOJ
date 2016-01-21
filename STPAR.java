package SPOJ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class STPAR {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int number = sc.nextInt();
			if(number == 0) break;
			Queue<Integer> queue = new LinkedList<Integer>();
			for(int i=0;i<number;i++){
				queue.add(sc.nextInt());
			}
			Stack<Integer> stack = new Stack<>();
			List<Integer> list = new ArrayList<Integer>();
			
			int k =1;
			while(true){
				if(!queue.isEmpty() && queue.peek()==k){
					list.add(queue.poll());
				}
				else{
					if(stack.isEmpty()){
						stack.push(queue.poll());
					}
					else if(!stack.isEmpty() && stack.peek()!=list.size()+1){
						if(queue.isEmpty()){
							System.out.println("NO");
							break;
						}
						stack.push(queue.poll());
					}
					else{
						list.add(stack.pop());
					}
				}
				k = list.size()+1;
				if(list.size()==number){
					System.out.println("YES");
					break;
				}
			}
		}
	}
}
