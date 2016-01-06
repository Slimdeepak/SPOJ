package SPOJ;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class Coin {
	public static HashMap<Integer,BigInteger> memo = new HashMap<Integer,BigInteger>();	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<=11;i++){
			memo.put(i,new BigInteger(""+i));
		}
		int num = 0;
		while(true){
			num = sc.nextInt();
			System.out.println(findProfit(num,memo));
			if(!sc.hasNextInt())break;
		}	
	}

	private static BigInteger findProfit(int num, HashMap<Integer, BigInteger> memo) {
			if(memo.containsKey(num)){
				return memo.get(num);
			}
			else{
				BigInteger newnumber = findProfit((int)Math.floor(num/2), memo).add(findProfit((int)Math.floor(num/3), memo)).add(findProfit((int)Math.floor(num/4), memo));
				memo.put(num,newnumber);
				return memo.get(num);
			}
	}
}
