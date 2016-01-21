package SPOJ;

import java.util.Scanner;
import java.util.*;

public class EGYPIZZA {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		String input[] = new String[number];

		for(int i=0;i<number;i++){
			input[i] = sc.next();
		}
		double array[] = new double[number];

		for(int i=0;i<number;i++){
			int arr[] = new int[2];
			arr[0] = Integer.parseInt(input[i].split("/")[0]);
			arr[1] = Integer.parseInt(input[i].split("/")[1]);
			array[i]= (double)arr[0]/arr[1];
		}
		Arrays.sort(array);
		ArrayList<Double> half = new ArrayList<Double>();
		ArrayList<Double> quarter = new ArrayList<Double>();
		ArrayList<Double> threequarter = new ArrayList<Double>();
		for(int i=0;i<number;i++){
			if(array[i]==0.5){
				half.add(array[i]);
			}
			else if(array[i]==0.25){
				quarter.add(array[i]);
			}
			else{
				threequarter.add(array[i]);
			}
		}
		int result = 0;
		
		int len = Math.min(quarter.size(),threequarter.size());
		result +=len;
		for(int i=0;i<len;i++){
			quarter.remove(0);
			threequarter.remove(0);
		}
		
		int halflength = half.size();
		result+=halflength/2;
		if(halflength%2==0){
			half.clear();
			if(!quarter.isEmpty())
			result+=(quarter.size()/4)+1;
		}
		else{
			half.clear();
			half.add(0.5);
			if(quarter.size()>2){
				result+=1;
				quarter.remove(0);
				quarter.remove(0);
				result+=(quarter.size()/4)+1;
			}
			else{
				result+=1;
			}
		}
		result+=threequarter.size();
		System.out.println(result+1);
	}
}
